package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	public NewTopic topic() {
		return TopicBuilder.name(AppConstants.LOCATION_UPDATE_TOPIC.getTopic())
				.partitions(3)
				.replicas(2)
				.build();
	}

}
