FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Tour-0.0.1-SNAPSHOT.jar /app/tour.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "tour.jar"]