FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/m-myapp-9.jar app.jar
#COPY ../certificate/microservice9 /certs
ENTRYPOINT ["sh", "-c", "java $JAVA_TOOL_OPTIONS -jar app.jar"]
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]