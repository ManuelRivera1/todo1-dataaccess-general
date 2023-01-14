FROM openjdk:17-jdk-slim
ADD target/dataaccess-federacion-0.0.1-SNAPSHOT.jar dataaccess-federacion.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dataaccess-federacion.jar"]
EXPOSE 8192