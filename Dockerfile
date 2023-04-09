FROM openjdk:8-jdk-alpine
MAINTAINER java-edu-web
COPY java-edu-web/target/java-edu-web-1.0.1-SNAPSHOT.jar java-edu-web.jar
ENTRYPOINT ["java","-jar","/java-edu-web.jar"]