FROM maven:3.9-sapmachine-21 as build

WORKDIR /app

COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN mvn -f pom.xml clean package

FROM sapmachine:21-jdk-ubuntu

WORKDIR /app

COPY --from=build /app/target/*.jar sim.jar

EXPOSE 8080
CMD java -jar sim.jar
