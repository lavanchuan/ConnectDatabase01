FROM maven:3.8.5-openjdk-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18.0.1-jdk-slim
COPY --from=build /target/ConnectDatabase01-0.0.1-SNAPSHOT.jar app/ConnectDatabase01.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app/ConnectDatabase01.jar" ]