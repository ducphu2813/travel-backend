FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/User-0.0.1-SNAPSHOT.jar /app/user.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "user.jar"]