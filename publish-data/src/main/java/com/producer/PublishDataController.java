package com.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishDataController {
	
	@Value(value = "${general.topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	@GetMapping("/publish/message")
	public String sendData(@RequestParam String message) {
		//Write code to send data to topic
		// message - is converted internally as byte array
		//Serialization means converting Object into Byte array
		//byte[] ;
		kafkaTemplate.send(topicName, message);
		return "Ahahha message is send to server successfully.";
	}

}
