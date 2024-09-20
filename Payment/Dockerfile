FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Payment-0.0.1-SNAPSHOT.jar /app/payment.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "payment.jar"]