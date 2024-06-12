FROM openjdk:17-jdk-alpine as builder
WORKDIR /app
COPY . .
RUN ./gradlew build -x test

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/altioracorp-evaluation-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
