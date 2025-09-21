FROM eclipse-temurin:21-jdk
WORKDIR /app
# Create directories for config & logs
RUN mkdir /config /logs
COPY target/m-myapp-2.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]