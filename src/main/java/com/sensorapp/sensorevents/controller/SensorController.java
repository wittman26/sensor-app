package com.sensorapp.sensorevents.controller;

import com.sensorapp.sensorevents.config.MessageProducer;
import com.sensorapp.sensorevents.dto.SensorDTO;
import com.sensorapp.sensorevents.model.Sensor;
import com.sensorapp.sensorevents.services.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sensorapp.sensorevents.utils.Constants.SENSOR_TOPIC;

@RestController
@CrossOrigin
@RequestMapping("${basepath}/sensor-events")
public class SensorController {

  final SensorService sensorService;
  final MessageProducer messageProducer;

  public SensorController(SensorService sensorService, MessageProducer messageProducer) {
    this.sensorService = sensorService;
    this.messageProducer = messageProducer;
  }

  @GetMapping(value ="healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getSensorEventTest() {
    return new ResponseEntity<>("Service SENSOR-EVENTS is running", HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sensor> setSensorEvent(@RequestBody @Valid SensorDTO sensorDto) {
      Sensor sensorDB = sensorService.createSensor(sensorDto);
      messageProducer.sendMessage(SENSOR_TOPIC, sensorDto.toString());
      return new ResponseEntity<>(sensorDB, HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<SensorDTO>> getSensorEvent() {
    List<SensorDTO> sensorDTOList = sensorService.getAllSensors();
    return new ResponseEntity<>(sensorDTOList, HttpStatus.OK);
  }

  @PostMapping("/test-kafka")
  public String sendMessage(@RequestParam("message") String message) {
    messageProducer.sendMessage("sensor-events", message);
    return "Message sent: " + message;
  }

}
