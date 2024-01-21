package com.enduser.enduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
	
	@KafkaListener(topics = KafkaConstant.LOCATION_UPDATE_KEY, groupId = KafkaConstant.GROUP_ID)
	public void updateLocation(String value) {
		System.out.println(value);
	}

}
