FROM openjdk:20
COPY target/JumpScareAPI-0.0.1-SNAPSHOT.jar JumpScareAPI.jar
ENTRYPOINT ["java", "-jar", "/JumpScareAPI.jar"]