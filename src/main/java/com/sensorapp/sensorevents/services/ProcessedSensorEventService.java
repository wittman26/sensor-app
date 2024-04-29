package com.sensorapp.sensorevents.services;

import com.sensorapp.sensorevents.model.ProcessedSensorEvent;
import com.sensorapp.sensorevents.repository.ProcessedSensorEventRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessedSensorEventService {
    final ProcessedSensorEventRepository repository;

  public ProcessedSensorEventService(ProcessedSensorEventRepository repository) {
    this.repository = repository;
  }

  public ProcessedSensorEvent createProcessedSensorEvent(ProcessedSensorEvent processedSensorEvent) {
    return repository.save(processedSensorEvent);
  }
}
