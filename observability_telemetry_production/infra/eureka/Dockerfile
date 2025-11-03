# Simple Spring Boot Eureka server build image placeholder
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/eureka-server.jar /app/eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
