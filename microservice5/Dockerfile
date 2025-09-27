FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/m-myapp-5.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]