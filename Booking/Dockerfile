# stage 1: build
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# copy pom.xml và tải dependencies (dùng cache đã khai báo ở docker-compose.yml)
COPY pom.xml ./
RUN mvn dependency:go-offline -Dmaven.repo.local=/root/.m2 -Dmaven.wagon.http.retryHandler.count=3

# copy toàn bộ project và clean và package
COPY src ./src
RUN mvn clean package -DskipTests -Dmaven.repo.local=/root/.m2

# stage 2: Run app
FROM openjdk:17-jdk-alpine

WORKDIR /app

# copy file jar đã được build trước đó vào container
COPY --from=build /app/target/Booking-0.0.1-SNAPSHOT.jar /app/booking.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/booking.jar"]

#FROM openjdk:17-jdk-alpine
#
#WORKDIR /app
#
#COPY target/Booking-0.0.1-SNAPSHOT.jar /app/booking.jar
#
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "booking.jar"]