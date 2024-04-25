package com.sensorapp.sensorevents.repository;

import com.sensorapp.sensorevents.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SensorRepository extends MongoRepository<Sensor, String> {
  List<Sensor> findAllById(String id);
}
