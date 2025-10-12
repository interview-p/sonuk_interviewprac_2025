FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/service-Discovery-Test-App.jar app.jar
#COPY ../certificate/eureka /certs
ENTRYPOINT ["sh", "-c", "java $JAVA_TOOL_OPTIONS -jar app.jar"]
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]