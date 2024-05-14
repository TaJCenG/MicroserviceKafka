package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyKafkaConsumer {
	 private static final Logger LOGGER = LoggerFactory.getLogger(MyKafkaConsumer.class);
    @KafkaListener(topics = "my-topic")
    public void consume(String message) {
    	LOGGER.info("Received message: {}", message);
    }
    
    @GetMapping("/consume")
    public String getConsumerStatus() {
        return "Consumer is active!";
    }
}
