package com.sensorapp.sensorevents.repository;

import com.sensorapp.sensorevents.model.ProcessedSensorEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessedSensorEventRepository extends MongoRepository<ProcessedSensorEvent, String> {
}
