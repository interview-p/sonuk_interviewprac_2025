# Build-time: you build Spring Boot jar locally and copy; image then runs it with OTEL agent
FROM eclipse-temurin:21-jdk
WORKDIR /app

# application jar (built by maven/gradle)
COPY target/m-myapp-15.jar /app/m-myapp-15.jar

# OTEL javaagent - put the jar into the folder next to Dockerfile before build
COPY opentelemetry-javaagent.jar /otel/opentelemetry-javaagent.jar

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_TOOL_OPTIONS -jar /app/m-myapp-15.jar"]
