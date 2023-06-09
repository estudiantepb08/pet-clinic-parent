FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17
EXPOSE 8762
COPY --from=buid /target/ app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]