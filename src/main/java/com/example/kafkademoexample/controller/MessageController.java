package com.example.kafkademoexample.controller;

import com.example.kafkademoexample.configuration.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaConfig kafkaConfig;

    public MessageController(
            KafkaTemplate<String, String> kafkaTemplate,
            KafkaConfig kafkaConfig
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfig = kafkaConfig;
    }

    @PostMapping
    public void sendMessage(
            @RequestParam String key,
            @RequestParam String message
    ) {
        var future = kafkaTemplate.send(kafkaConfig.topicName(), key, message);
        future
                .thenAccept(
                        stringStringSendResult -> log.info("I send message key:{}, value:{}",
                                stringStringSendResult.getProducerRecord().key(),
                                stringStringSendResult.getProducerRecord().value()
                        ));
    }
}
