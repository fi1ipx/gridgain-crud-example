FROM openjdk:12
COPY ./target/crud-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "crud-0.0.1-SNAPSHOT.jar"]
