FROM openjdk:17-jdk

WORKDIR /app

COPY target/user-service-3.4.3.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]