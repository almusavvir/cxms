FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/customer-microservice-0.0.1-SNAPSHOT.jar customer-microservice.jar

ENTRYPOINT ["java", "-jar", "customer-microservice.jar"]

