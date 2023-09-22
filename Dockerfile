FROM openjdk:20-jdk-slim as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

#RUN ./mvnw clean install -DskipTests
RUN ./mvnw install
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

WORKDIR /app/target

ENTRYPOINT java -jar jlapp-0.0.1-SNAPSHOT.jar