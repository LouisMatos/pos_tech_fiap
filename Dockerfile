FROM eclipse-temurin:20-jdk AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw \
    && sed -i 's/\r$//' mvnw \
    && ./mvnw package -DskipTests dependency:resolve

FROM eclipse-temurin:20-jre AS runtime

WORKDIR /app

RUN groupadd --system --gid 1000 appuser \
    && useradd --system --uid 1000 --gid appuser appuser

COPY --from=build /app/target/jlapp-0.0.1-SNAPSHOT.jar app.jar

USER 1000:1000

ENTRYPOINT ["java", "-jar", "app.jar"]
