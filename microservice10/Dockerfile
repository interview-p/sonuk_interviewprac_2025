FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/m-myapp-10.jar app.jar
VOLUME /app/logs
ENTRYPOINT ["java", "-jar", "/app/app.jar"]