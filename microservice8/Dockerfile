FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/m-myapp-8.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]