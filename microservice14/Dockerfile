# microservice/Dockerfile
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/m-myapp-14.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]