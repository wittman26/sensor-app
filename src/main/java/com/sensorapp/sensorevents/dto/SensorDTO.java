package com.sensorapp.sensorevents.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SensorDTO {
  @NotBlank
  private String id;
  private Instant timestamp;
  @NotBlank
  private String type;
  private Double value;
}
