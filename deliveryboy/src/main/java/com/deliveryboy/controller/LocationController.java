package com.deliveryboy.controller;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.spi.LoggerRegistry.MapFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

@RestController()
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		Map<Integer,String> map = new HashMap<>();
		map.put(0, "Nanakheda");
		map.put(1,"Apnasweets");
		map.put(2,"TeenBatti");
		map.put(3,"Alakhdhamnagar");
		
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

		 map.forEach((key, value) ->{
			 executorService.schedule(() ->
			 {
				 this.kafkaService.locationUpdate("(" + "Rider reaches at this point" + key + " " + "with this place" + value + ")");
			 },5 * key, TimeUnit.SECONDS);
			
		 });
			
		
		
		
		return new ResponseEntity<>(Map.of("message","Location updated"), HttpStatus.OK);
		
	}

}
