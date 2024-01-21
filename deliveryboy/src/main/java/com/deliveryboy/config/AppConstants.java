package com.deliveryboy.config;

public enum AppConstants {
	LOCATION_UPDATE_TOPIC("location-update-topic");
	
	private final String topic;
	AppConstants(String topic){
		this.topic = topic;
	}
	public String getTopic() {
		return topic;
	}
	
}

	


