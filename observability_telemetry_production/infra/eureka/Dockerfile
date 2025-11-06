# Simple Spring Boot Eureka server build image placeholder
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target_jar/OBS_Discovery_Server.jar /app/eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
