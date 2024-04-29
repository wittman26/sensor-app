package com.sensorapp.sensorevents.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class SensorDTO {
  @NotBlank(message = "Id  cannot be blank")
  private String id;

  @NotNull(message = "timestamp cannot be Null")
  private Instant timestamp;
  @NotBlank(message = "type cannot be blank")
  private String type;
  @NotNull(message = "value cannot be Null")
  @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than {0.0}")
  private Double value;
}
