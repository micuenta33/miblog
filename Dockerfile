# Usar una imagen base con JDK 11 y Maven
FROM maven:3.8.4-amazoncorretto-17 AS build

RUN mkdir /app

WORKDIR /app

COPY target/ejemploweb-0.0.1-SNAPSHOT.jar /app/ejemploweb-0.0.1-SNAPSHOT.jar


EXPOSE 8080

CMD java -jar ejemploweb-0.0.1-SNAPSHOT.jar