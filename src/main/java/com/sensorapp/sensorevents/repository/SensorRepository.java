package com.sensorapp.sensorevents.repository;

import com.sensorapp.sensorevents.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepository extends MongoRepository<Sensor, String> {
}
