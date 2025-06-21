package com.example.kafka_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(String message) {
        System.out.println("[Kafka Consumer] Received message: " + message);
    }
}

