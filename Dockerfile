#Build Stage
FROM maven:3-jdk-8-slim AS maven
COPY . .
RUN mvn clean
RUN mvn install
RUN mvn package

#Run Stage
FROM openjdk:8-jre-slim
COPY --from=maven rest-app-jpa/target/rest-app-jpa.jar .
CMD [ "java", "-jar", "rest-app-jpa.jar" ]