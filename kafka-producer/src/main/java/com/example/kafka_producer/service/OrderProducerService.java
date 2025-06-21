package com.example.kafka_producer.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

	private NewTopic topic;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public OrderProducerService(NewTopic topic, KafkaTemplate<String, String> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
        System.out.println("[Kafka Producer] Sending message: " + message);
		kafkaTemplate.send(topic.name(), message);
	}
}
