# Sensor-app

Sensor-app is an API REST application example built with Spring Boot framework.

# Built With

This project is built using the following technologies:
- Java Spring framework 3.2.5
- Java 17
- Kafka (using Zookeeper)
- MongoDB

Java Dependencies used
- lombok
- modelmapper
- spring-boot-starter-data-mongodb
- spring-boot-starter-web
- spring-kafka

## Interaction between components
![](/src/main/resources/static/Componentes.png)


# Setting up and run the application

## Running using compose

Run the following commands to run locally 
```
./mvnw clean install -DskipTests
docker-compose up --build -d
```

The application will be available on port 8090 in this URL `localhost:8090/api`
Dockerfile uses DEV profile by default so all properties configuration are taken from application-dev.yaml
(see [Configuration files](#configuration-files) )

Postman collection is provided in root folder to test the application.

## Running using Maven

MongoDB and Kafka should be running before starting the app.

```
mvn spring-boot:run
```

In windows systems type

```
./mvnw spring-boot:run
```

### Configuration files

Properties for configuration can be found in `/sensor-app/src/main/resources` path. The following properties files can be found:

```conf
    application-dev.yml
    application.yml
```

The following are the main properties that should be set on the **application.yml** before starting the app

```conf
# Basepath to consult the API {{base-url}}{{basepath}}/sensor-events
basepath: /api

# Database properties
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: sensor-events
server:
  port: '8091'
```

The default endpoint is: `localhost:8091/api`

## Detailed API endpoints

A postman collection is provided in root folder.
These are the following endpoints available:

POST {{base-url}}/api/sensor-events
{
    "id": "sensor_123",
    "timestamp": "2024-02-15T12:34:56Z",
    "type": "temperature",
    "value": "25.3"
}
GET {{base-url}}/api/sensor-events

### Test urls

GET {{base-url}}/api/healthcheck
POST {{base-url}}/api/sensor-events/test-kafka?message=some_message


# Install and run with Docker

To build and run the application, execute the following commands.

```
docker build -t usuario/sensor-app:latest .
docker run -d -p 8090:8090 usuario/sensor-app:latest
```

To display image list
```
docker ps
```
Get container-id and set it in the following command to show logs

```
docker logs --follow <container-id>
```

