FROM maven:3.6.0-jdk-11-slim AS build
COPY src ../crud-banco-springboot-postgresql-hibernate/src
COPY pom.xml ../crud-banco-springboot-postgresql-hibernate/
RUN mvn clean install -DskipTests
RUN mvn -f ../crud-banco-springboot-postgresql-hibernate/pom.xml clean package

FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
COPY src/main/resources/application.properties /app/src/main/resources/application.properties
ADD target/crud-banco-springboot-postgresql-hibernate-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]