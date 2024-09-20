FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Booking-0.0.1-SNAPSHOT.jar /app/booking.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "booking.jar"]