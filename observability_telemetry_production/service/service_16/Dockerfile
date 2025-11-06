FROM eclipse-temurin:21-jdk

# Create app directory
WORKDIR /app

# Copy Spring Boot jar
COPY target_jar/m-myapp-16.jar /app/app.jar

# Download OpenTelemetry Java Agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.27.0/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar

# Expose application and Prometheus metrics ports
EXPOSE 8080 9464

# Default entrypoint (can be overridden in docker-compose)
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/app.jar"]

