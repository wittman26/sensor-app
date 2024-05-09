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

  public Object getProcessedSensorEvents() {
    return repository.findAll();
  }

  public void deleteProcessedSensorEvent(ProcessedSensorEvent processedSensorEvent) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteProcessedSensorEvent'");
  }
  
  public ProcessedSensorEvent updateProcessedSensorEvent(ProcessedSensorEvent processedSensorEvent) {
    ProcessedSensorEvent processedSensorEventDB = repository.findById(processedSensorEvent.getId()).orElse(null);
    if(processedSensorEventDB == null){
      return null;
    }
    processedSensorEventDB.setId(processedSensorEvent.getId());
    processedSensorEventDB.setDescription(processedSensorEvent.getDescription());
    return repository.save(processedSensorEventDB);
  }

  //use junit to test updateProcessedSensorEvent

}
