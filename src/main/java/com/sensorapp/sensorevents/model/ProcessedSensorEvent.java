package com.sensorapp.sensorevents.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("processed-sensor-events")
@Getter
@Setter
public class ProcessedSensorEvent {
  @Id
  private String id;
  private String description;

  public ProcessedSensorEvent(String id, String description) {
    this.id = id;
    this.description = description;
  }
}
