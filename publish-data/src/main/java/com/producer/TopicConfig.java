package com.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

	@Value(value = "${general.topic.name}")
	private String topicName;

	@Bean
	public NewTopic generalTopic() {
		return TopicBuilder.name(topicName)
			      .partitions(3)
			      .replicas(1)
			      .build();
	}

}
