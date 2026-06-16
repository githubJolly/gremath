/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.boot.CommandLineRunner
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 */
package com.gremath.config;

import com.gremath.content.AlgebraContent;
import com.gremath.content.AveragesContent;
import com.gremath.content.CountingContent;
import com.gremath.content.GeometryContent;
import com.gremath.content.NumberPropertiesContent;
import com.gremath.content.PercentagesContent;
import com.gremath.content.ProbabilityContent;
import com.gremath.content.ProfitInterestContent;
import com.gremath.content.RatiosContent;
import com.gremath.content.TimeSpeedDistanceContent;
import com.gremath.content.TopicContent;
import com.gremath.repository.TopicRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seedData(TopicRepository topicRepository) {
        return args -> {
            if (topicRepository.count() > 0L) {
                return;
            }
            List<TopicContent> topics = List.of(
                    new NumberPropertiesContent(),
                    new PercentagesContent(),
                    new RatiosContent(),
                    new AveragesContent(),
                    new AlgebraContent(),
                    new GeometryContent(),
                    new TimeSpeedDistanceContent(),
                    new CountingContent(),
                    new ProbabilityContent(),
                    new ProfitInterestContent());
            topics.forEach(content -> topicRepository.save(content.build()));
        };
    }
}

