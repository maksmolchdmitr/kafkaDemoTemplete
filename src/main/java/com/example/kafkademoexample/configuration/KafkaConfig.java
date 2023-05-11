package com.example.kafkademoexample.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public record KafkaConfig(
        String topicName
) {
}
