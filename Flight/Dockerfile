FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Flight-0.0.1-SNAPSHOT.jar /app/flight.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "flight.jar"]