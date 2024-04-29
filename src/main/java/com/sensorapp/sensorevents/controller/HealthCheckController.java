package com.sensorapp.sensorevents.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${basepath}/")
public class HealthCheckController {

		@GetMapping(value ="/health", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> getHealth() {
			return new ResponseEntity<>("Service SENSOR-EVENTS is running", HttpStatus.OK);
		}
}
