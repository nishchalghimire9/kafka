package com.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "string-techtopic", groupId = "technohunk444",containerFactory = "concurrentKafkaListenerContainer")
    public void consume(String message) {
       System.out.println("Reading message from topic = "+message);
    }

}
