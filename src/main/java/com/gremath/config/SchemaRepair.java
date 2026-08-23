package com.gremath.config;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Hibernate {@code ddl-auto=update} will not widen an existing VARCHAR(2000).
 * Illustrated quiz stems are longer than that, so we widen (or rebuild) those columns
 * during context startup — before Tomcat accepts requests.
 */
@Component
@DependsOn("entityManagerFactory")
public class SchemaRepair {

    private static final Logger log = LoggerFactory.getLogger(SchemaRepair.class);
    private static final int WIDE = 1_000_000;

    private final JdbcTemplate jdbc;
    private volatile int questionLimit = 2000;

    public SchemaRepair(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostConstruct
    public void init() {
        widenColumns();
    }

    public void widenColumns() {
        logColumnMeta();
        ensureWide("SHEET_ANSWERS", "QUESTION_TEXT");
        ensureWide("SHEET_ANSWERS", "EXPLANATION");
        ensureWide("SHEET_ANSWER_OPTIONS", "OPTION_TEXT");
        this.questionLimit = columnLimit("SHEET_ANSWERS", "QUESTION_TEXT");
        log.info("Quiz answer text limit is now {} characters.", this.questionLimit);
    }

    /** Keep a save from dying if the live column is still a short VARCHAR. */
    public String fitText(String text) {
        if (text == null) {
            return null;
        }
        int limit = this.questionLimit > 0 ? this.questionLimit : 2000;
        if (text.length() <= limit) {
            return text;
        }
        String stripped = text.replaceAll("(?is)<svg[\\s\\S]*?</svg>", " [diagram] ");
        if (stripped.length() <= limit) {
            log.warn("Stored a question without its SVG (column limit {}).", limit);
            return stripped;
        }
        return stripped.substring(0, limit);
    }

    private void ensureWide(String table, String column) {
        int limit = columnLimit(table, column);
        if (limit <= 0) {
            log.warn("Column {}.{} not found; skip widen.", table, column);
            return;
        }
        if (limit >= 100_000) {
            return;
        }
        String[] attempts = {
                "ALTER TABLE " + table + " ALTER COLUMN " + column + " SET DATA TYPE CHARACTER VARYING(" + WIDE + ")",
                "ALTER TABLE " + table + " ALTER COLUMN " + column + " CHARACTER VARYING(" + WIDE + ")",
                "ALTER TABLE " + table + " ALTER COLUMN " + column + " SET DATA TYPE CLOB"
        };
        for (String sql : attempts) {
            try {
                this.jdbc.execute(sql);
                int now = columnLimit(table, column);
                log.info("Widened {}.{} with [{}] — new limit {}", table, column, sql, now);
                if (now >= 100_000 || now < 0) {
                    return;
                }
            } catch (Exception ex) {
                log.warn("Widen SQL failed for {}.{}: {} — {}", table, column, sql, ex.getMessage());
            }
        }
        rebuildColumn(table, column);
    }

    private void rebuildColumn(String table, String column) {
        String tmp = column + "_WIDE";
        try {
            this.jdbc.execute("ALTER TABLE " + table + " ADD COLUMN " + tmp + " CHARACTER VARYING(" + WIDE + ")");
            this.jdbc.execute("UPDATE " + table + " SET " + tmp + " = " + column);
            this.jdbc.execute("ALTER TABLE " + table + " DROP COLUMN " + column);
            this.jdbc.execute("ALTER TABLE " + table + " ALTER COLUMN " + tmp + " RENAME TO " + column);
            log.info("Rebuilt {}.{} as VARCHAR({}).", table, column, WIDE);
        } catch (Exception ex) {
            log.error("Could not rebuild {}.{}: {}", table, column, ex.getMessage());
        }
    }

    private int columnLimit(String table, String column) {
        List<Map<String, Object>> rows = this.jdbc.queryForList(
                "SELECT CHARACTER_MAXIMUM_LENGTH AS LEN, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS "
                        + "WHERE UPPER(TABLE_NAME) = ? AND UPPER(COLUMN_NAME) = ?",
                table, column);
        if (rows.isEmpty()) {
            return -1;
        }
        Object type = rows.get(0).get("DATA_TYPE");
        if (type != null && type.toString().toUpperCase().contains("CLOB")) {
            return WIDE;
        }
        Object len = rows.get(0).get("LEN");
        if (len == null) {
            return WIDE;
        }
        return ((Number) len).intValue();
    }

    private void logColumnMeta() {
        try {
            List<Map<String, Object>> rows = this.jdbc.queryForList(
                    "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH AS LEN "
                            + "FROM INFORMATION_SCHEMA.COLUMNS "
                            + "WHERE UPPER(COLUMN_NAME) IN ('QUESTION_TEXT','EXPLANATION','OPTION_TEXT')");
            log.info("Answer-text columns: {}", rows);
        } catch (Exception ex) {
            log.warn("Could not read column metadata: {}", ex.getMessage());
        }
    }
}
