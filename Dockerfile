# Crear una nueva imagen basada en OpenJDK 11
FROM openjdk:17-alpine
# Copiar el archivo JAR construido desde la etapa anterior
COPY target/ejemploweb-0.0.1-SNAPSHOT.jar app.jar
# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]