# Imagen base de Java 21
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiar el JAR generado por Maven/Gradle
COPY target/*.jar app.jar

# Exponer puerto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
