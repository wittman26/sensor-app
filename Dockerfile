##STAGE 1
## Use an existing Maven Image as base
FROM maven:3.8.3-openjdk-17-slim

# Create app directory
WORKDIR /app

# Bundle app source
COPY . /app

# Install app dependencies
RUN mvn package

#Define environment (dev, cert or prod)
ENV PROFILE "dev"

#Executes maven command sending profile as parameter
CMD ["sh", "-c", "mvn -Dspring-boot.run.profiles=${PROFILE} spring-boot:run"]