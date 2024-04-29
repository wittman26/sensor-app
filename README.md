# Sensor-app

Sensor-app is an API REST application example built with Spring Boot framework.

# Getting Started

## Running using compose

Run the following commands to run locally 
```
./mvnw clean install -DskipTests
docker-compose up --build -d
```

The application will be available on port 8090 in this URL `localhost:8090/api`
Dockerfile uses DEV profile by default so all properties configuration are taken from applicatin-dev.yaml

Postman collection is provided in root folder to test the application.

## Configuration files

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

## Run application

MongoDB and Kafka should be running before starting the app.

```
mvn spring-boot:run
```

In windows systems type

```
./mvnw spring-boot:run
```

## Endpoints
A postman collection is provided in root folder.
These are the following endpoints available:

POST {{base-url}}/api/sensor-events
GET {{base-url}}/api/sensor-events


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

# Built With

This project is built using the following technologies:
- Java Spring framework 3.2.5
- Java 17
- Kafka (using Zookeeper)
- MmongoDB
- Lombok
- Modelmapper