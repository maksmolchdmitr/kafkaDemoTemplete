package com.example.kafkademoexample;

import com.example.kafkademoexample.configuration.KafkaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaConfig.class)
public class KafkaDemoExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoExampleApplication.class, args);
    }

}
