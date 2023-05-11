package com.example.kafkademoexample.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "${kafka.topicName}")
    public void messageListener(String message){
        log.info("I have listened message: {}", message);
    }
}
