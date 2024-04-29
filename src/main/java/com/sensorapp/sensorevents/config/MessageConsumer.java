package com.sensorapp.sensorevents.config;

import com.sensorapp.sensorevents.model.ProcessedSensorEvent;
import com.sensorapp.sensorevents.services.ProcessedSensorEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.sensorapp.sensorevents.utils.Constants.SENSOR_GROUP_ID;
import static com.sensorapp.sensorevents.utils.Constants.SENSOR_TOPIC;

@Component
public class MessageConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

  final ProcessedSensorEventService processedSensorEventService;

  public MessageConsumer(ProcessedSensorEventService processedSensorEventService) {
    this.processedSensorEventService = processedSensorEventService;
  }

  @KafkaListener(topics = SENSOR_TOPIC, groupId = SENSOR_GROUP_ID)
  public void listen(String message) {
    String randomUUID = UUID.randomUUID().toString();
    processedSensorEventService.createProcessedSensorEvent(new ProcessedSensorEvent(randomUUID, message));
    LOGGER.info("Event Processed: {} {}",randomUUID, message);
  }

}