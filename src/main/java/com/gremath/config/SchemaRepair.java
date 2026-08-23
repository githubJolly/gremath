package com.gremath.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Hibernate {@code ddl-auto=update} will not widen an existing VARCHAR(2000) to CLOB.
 * Illustrated quiz stems exceed 2000 characters, so we alter those columns on startup.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SchemaRepair implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(SchemaRepair.class);

    private final JdbcTemplate jdbc;

    public SchemaRepair(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void run(ApplicationArguments args) {
        widenColumns();
    }

    public void widenColumns() {
        widen("sheet_answers", "question_text");
        widen("sheet_answers", "explanation");
        widen("sheet_answer_options", "option_text");
    }

    private void widen(String table, String column) {
        try {
            this.jdbc.execute("ALTER TABLE " + table + " ALTER COLUMN " + column
                    + " SET DATA TYPE CHARACTER VARYING(1000000)");
            log.info("Widened {}.{} for illustrated quiz text.", table, column);
        } catch (Exception ex) {
            log.warn("Could not widen {}.{}: {}", table, column, ex.getMessage());
        }
    }
}
