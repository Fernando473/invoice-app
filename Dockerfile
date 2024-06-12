FROM gradle:7.6.0-jdk17 AS builder
WORKDIR /home/gradle/project
COPY . .
RUN gradle build --no-daemon

FROM openjdk:17
EXPOSE 8080
RUN mkdir -p /app
COPY --from=builder /home/gradle/project/build/libs/altioracorp-evaluation-0.0.1-SNAPSHOT.jar /app/altioracorp-evaluation-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/altioracorp-evaluation-0.0.1-SNAPSHOT.jar"]
