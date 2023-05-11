package com.example.kafkademoexample.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;

@Configuration
public class KafkaProducerConfiguration {
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(KafkaConfig kafkaConfig){
        return new KafkaTemplate<>(kafkaProducerFactory(kafkaConfig));
    }

    public ProducerFactory<String, String> kafkaProducerFactory(KafkaConfig kafkaConfig) {
        var config = new HashMap<String, Object>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.bootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
}
