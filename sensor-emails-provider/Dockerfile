FROM eclipse-temurin:17-jdk-alpine
COPY ./target/sensor-emails-provider-0.0.2.jar app.jar
ENV CONFIG_SERVER_HOST=config-server
ENTRYPOINT [ "java", "-jar", "app.jar" ]