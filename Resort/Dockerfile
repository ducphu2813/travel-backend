FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Resort-0.0.1-SNAPSHOT.jar /app/resort.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "resort.jar"]