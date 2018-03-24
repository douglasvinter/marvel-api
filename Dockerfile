FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/marvel-api-0.0.1-SNAPSHOT.jar target/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=local", "-jar", "target/app.jar"]