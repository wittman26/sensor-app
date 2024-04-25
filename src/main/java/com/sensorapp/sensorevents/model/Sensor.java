package com.sensorapp.sensorevents.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("sensor-events")
@Getter
@Setter
public class Sensor {
  @Id
  private String id;
  private Instant timestamp;
  private String type;
  private Double value;
}
