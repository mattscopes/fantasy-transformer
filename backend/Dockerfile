FROM eclipse-temurin:21-jre-jammy

LABEL authors="mattscopes"

ARG JAR_FILE=target/*.jar

COPY ./target/dashboard-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]