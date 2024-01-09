FROM openjdk:17
WORKDIR /app
COPY build/libs/gft-interview-0.0.1-SNAPSHOT.jar gtf-interview.jar
CMD ["java", "-jar", "gtf-interview.jar"]
EXPOSE 8080
