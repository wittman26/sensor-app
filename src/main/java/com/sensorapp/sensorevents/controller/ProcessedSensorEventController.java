package com.sensorapp.sensorevents.controller;

import com.sensorapp.sensorevents.dto.ProcessedSensorEventDTO;
import com.sensorapp.sensorevents.model.ProcessedSensorEvent;
import com.sensorapp.sensorevents.services.ProcessedSensorEventService;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessedSensorEventController {

    private final ProcessedSensorEventService processedSensorEventService;
    private final ModelMapper modelMapper;

    public ProcessedSensorEventController(ProcessedSensorEventService processedSensorEventService, ModelMapper modelMapper) {
        this.processedSensorEventService = processedSensorEventService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSensorEventTest() {
        return new ResponseEntity<>("Service SENSOR-EVENTS is running", HttpStatus.OK);
    }

    @GetMapping(value = "/processed-sensor-events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProcessedSensorEvents() {
        return new ResponseEntity<>(processedSensorEventService.getProcessedSensorEvents().toString(), HttpStatus.OK);
    }

    @PostMapping(value = "/processed-sensor-events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setProcessedSensorEvent(@RequestBody @Valid ProcessedSensorEventDTO processedSensorEventDTO) {
        ProcessedSensorEvent processedSensorEvent = modelMapper.map(processedSensorEventDTO, ProcessedSensorEvent.class);
        ProcessedSensorEvent processedSensorEventDB = processedSensorEventService.createProcessedSensorEvent(processedSensorEvent);
        return new ResponseEntity<>(processedSensorEventDB.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/processed-sensor-events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<String> updateProcessedSensorEvent(@RequestBody @Valid ProcessedSensorEventDTO processedSensorEventDTO) {
        ProcessedSensorEvent processedSensorEvent = modelMapper.map(processedSensorEventDTO, ProcessedSensorEvent.class);
        ProcessedSensorEvent processedSensorEventDB = processedSensorEventService.updateProcessedSensorEvent(processedSensorEvent);
        return new ResponseEntity<>(processedSensorEventDB.toString(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/processed-sensor-events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProcessedSensorEvent(@RequestBody @Valid ProcessedSensorEventDTO processedSensorEventDTO) {
        ProcessedSensorEvent processedSensorEvent = modelMapper.map(processedSensorEventDTO, ProcessedSensorEvent.class);
        processedSensorEventService.deleteProcessedSensorEvent(processedSensorEvent);
        return new ResponseEntity<>("Processed sensor event deleted successfully", HttpStatus.OK);
    }
}
