FROM eclipse-temurin:17-jdk-alpine
COPY ./target/admin-console-0.0.2.jar app.jar
ENV CONFIG_SERVER_HOST=config-server
ENTRYPOINT [ "java", "-jar", "app.jar" ]