# stage 1: build
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# copy pom.xml và tải dependencies (để có thể xài cache hiệu quả)
COPY pom.xml .
RUN mvn dependency:go-offline -Dmaven.repo.local=/root/.m2 -Dmaven.wagon.http.retryHandler.count=3

# copy toàn bộ project sau đó clean và package
COPY src ./src
RUN mvn package -DskipTests -Dmaven.repo.local=/root/.m2

# stage 2: Run app
FROM openjdk:17-jdk-alpine

WORKDIR /app

# copy file jar đã được build trước đó vào container
COPY --from=build /app/target/ServiceRegistry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/service-registry.jar"]


#FROM openjdk:17-jdk-alpine AS build
#
#WORKDIR /app
#
## copy file POM trước để cache dependencies nếu không có thay đổi
#COPY pom.xml ./
#
## chạy lệnh tải dependencies trước
#RUN mvn dependency:go-offline -B
#
## sau đó mới copy toàn bộ source code vào container
#COPY src /app/src
#
## clean và package
#RUN mvn clean package -DskipTests
#
#COPY --from=build /app/target/ServiceRegistry-0.0.1-SNAPSHOT.jar /app/service-registry.jar
#
#ENV LANG=C.UTF-8
#
#EXPOSE 8761
#
#ENTRYPOINT ["java", "-jar", "/app/service-registry.jar"]