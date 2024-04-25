package com.sensorapp.sensorevents.services;

import com.sensorapp.sensorevents.dto.SensorDTO;
import com.sensorapp.sensorevents.model.Sensor;
import com.sensorapp.sensorevents.repository.SensorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
  final SensorRepository sensorRepository;

  final ModelMapper modelMapper;

  public SensorService(SensorRepository sensorRepository, ModelMapper modelMapper) {
    this.sensorRepository = sensorRepository;
    this.modelMapper = modelMapper;
  }

  public Sensor createSensor(SensorDTO sensorDto) {
    Sensor sensor = modelMapper.map(sensorDto, Sensor.class);
    return sensorRepository.save(sensor);
  }

  public List<SensorDTO> getAllSensors(){
    List<Sensor> sensorList = sensorRepository.findAll();

    List<SensorDTO> sensorDTOList = new ArrayList<>();
    sensorList.forEach( x ->
            sensorDTOList.add(modelMapper.map(x, SensorDTO.class))
    );
    return sensorDTOList;
  }
}
