FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/Spring_Boot_REST-0.0.1-SNAPSHOT.jar MySBRApp.jar
CMD ["java", "-jar", "MySBRApp.jar"]
