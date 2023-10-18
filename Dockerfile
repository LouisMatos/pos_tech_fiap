FROM openjdk:20-jdk-slim as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw 
RUN chmod +x .mvn 

#RUN ./mvnw package -DskipTests

# clean up the file
RUN sed -i 's/\r$//' mvnw 
# run with the SH path
RUN /bin/sh mvnw package -DskipTests dependency:resolve

#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

WORKDIR /app/target

ENTRYPOINT java -jar jlapp-0.0.1-SNAPSHOT.jar

