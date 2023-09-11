FROM openjdk:latest
COPY target/JumpScareAPI-0.0.1-SNAPSHOT.jar JumpScareAPI.jar
ENTRYPOINT ["java", "-jar", "/JumpScareAPI.jar"]