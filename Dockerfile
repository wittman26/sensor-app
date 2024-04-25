##STAGE 1
## Use an existing Maven Image as base
FROM maven:3.8.3-openjdk-17-slim

# Create app directory
WORKDIR /app

# Bundle app source
COPY . /app

# Install app dependencies
RUN mvn package

##Expose on defined port
#ENV PORT 9191
#EXPOSE $PORT
##Executes maven command sending port parameter
#CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]

#Define environment (dev, cert or prod)
ENV PROFILE "dev"
#Executes maven command sending profile parameter
CMD ["sh", "-c", "mvn -Dspring-boot.run.profiles=${PROFILE} spring-boot:run"]

##########################################################

#OPTION 2
#FROM maven:3-jdk-8-alpine as builder
#
#WORKDIR c/app
#
#COPY . /app
#RUN mvn package
#
#FROM openjdk:8-jre-alpine
#COPY --from=builder /usr/src/app/target/*.jar /app.jar
#
#EXPOSE 8080
#
#ENTRYPOINT ["java"]
#CMD ["-jar", "/app.jar"]
