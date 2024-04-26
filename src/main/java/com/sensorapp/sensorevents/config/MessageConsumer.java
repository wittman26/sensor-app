package com.sensorapp.sensorevents.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

  @KafkaListener(topics = "sensor-events", groupId = "sensor-app-br")
  public void listen(String message) {
    System.out.println("Received message: " + message);
  }

}