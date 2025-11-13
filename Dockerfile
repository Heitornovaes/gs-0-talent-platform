# Etapa de build
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

RUN chmod +x mvnw
RUN ./mvnw -B clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/target/gs-0-talent-platform-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
