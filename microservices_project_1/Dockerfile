FROM openjdk:17-jdk-slim
WORKDIR /app
# Create directories for config & logs
RUN mkdir /config /logs
COPY target/m-myapp.jar app.jar
# Create non-root user
RUN addgroup --system spring \
    && adduser --system --ingroup spring --home /home/spring spring \
    && chown spring:spring /app/app.jar \
    && chown -R spring:spring /config /logs \
    && chmod 500 /app/app.jar \
    && chmod -R 777 /config /logs
	
#here above we creat one group called spring and user spring allow to access app.jar mean
#jar run by spring user so that hacker not access root user if he can access it can access server also
# and also here we create two folder config where application properties reside mean when
# spring application start it load from here it just given externalize the properties
# and logs folder use to extrenalize console log so that we can access outside docker

# Switch to non-root user
USER spring
ENTRYPOINT ["java", "-jar", "/app/app.jar", \
            "--spring.config.additional-location=/config/", \
            "--logging.file.path=/logs"]