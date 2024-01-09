# GFT Interview Challenge

![](https://img.shields.io/badge/build-success-brightgreen.svg)

## Authors
- [Agustin Varela](https://www.linkedin.com/in/agus-varela10)

## Stack

![](https://img.shields.io/badge/Java_17-✓-blue.svg)
![](https://img.shields.io/badge/Spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/H2-✓-blue.svg)
![](https://img.shields.io/badge/Gradle-✓-blue.svg)
![](https://img.shields.io/badge/Postman-✓-blue.svg)
![](https://img.shields.io/badge/OpenApi_3.0-✓-blue.svg)
![](https://img.shields.io/badge/Docker-✓-blue.svg)

-------------------

## H2 Database

This application uses H2 for data-base in memory.

-------------------

## How to run this API locally

1. Make sure [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Gradle](https://gradle.org/install/) and [Docker](https://docs.docker.com/get-docker/) are installed.

2. Fork and clone this repository

```
git clone https://github.com/agusvarela/gft-interview.git
```

3. Navigate to the project folder

```
cd gft-interview
```

4. Install Gradle dependencies

```
gradle build
```

5. In the project folder, run the project on docker containers using docker-compose. It will pull and run images required from dockerHub (Make sure that port 8080 and 9092 are not in use)

```
docker-compose up
```

----------

## Documentation
Once the application is running, you can find all the information to test the application via swagger:
http://localhost:8080/swagger-ui/index.html

Or you could see and import the Postman collection:
https://documenter.getpostman.com/view/10728290/2s9YsKfrhm