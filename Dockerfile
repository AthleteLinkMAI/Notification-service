FROM maven:3.9.13-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml ./
COPY src/main ./src/main
RUN mvn -B -ntp -DskipTests package

FROM eclipse-temurin:25-jre
WORKDIR /app
RUN mkdir -p /logs/athletelink && chown -R 10001:10001 /logs
COPY --from=build /app/target/athelete-link-notification-service-0.0.1.jar /app.jar
USER 10001:10001
ENTRYPOINT ["java", "-jar", "/app.jar"]
