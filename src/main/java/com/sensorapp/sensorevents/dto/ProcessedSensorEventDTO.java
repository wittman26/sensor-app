package com.sensorapp.sensorevents.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@ToString
public class ProcessedSensorEventDTO {
    private String id;
    
    @NotBlank(message = "Sensor ID is required")
    private String sensorId;
    
    @NotBlank(message = "Sensor type is required")
    private String sensorType;
    
    @NotBlank(message = "Sensor value is required")
    private String sensorValue;
    
    @NotNull(message = "Processed value is required")
    private String processedValue;
    
    @NotNull(message = "Processed time is required")
    private String processedTime;
    
    @NotNull(message = "Processed status is required")
    private String processedStatus;
    
    @Size(max = 100, message = "Processed message must be less than or equal to 100 characters")
    private String processedMessage;
}
