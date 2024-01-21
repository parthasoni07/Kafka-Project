package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstants;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	public boolean locationUpdate(String location) {
		this.kafkaTemplate.send(AppConstants.LOCATION_UPDATE_TOPIC.getTopic(),location);
		this.logger.info("Message produced");
		return true;
	}

}
