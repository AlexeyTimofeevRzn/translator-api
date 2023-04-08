FROM openjdk:17

ADD /target/translator-api-0.0.1-SNAPSHOT.jar tranlator-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "tranlator-api.jar"]