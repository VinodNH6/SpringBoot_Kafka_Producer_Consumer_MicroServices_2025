package com.example.kafka_producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka_producer.service.OrderProducerService;

@RestController
public class OrderController {

    private final OrderProducerService orderService;

    public OrderController(OrderProducerService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping("/publish/{message}")
    public void publishMessageToKafka(@PathVariable("message") final String message) {
    	orderService.sendMessage(message);
    }
}
