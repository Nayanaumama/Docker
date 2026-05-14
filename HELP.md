| **Dockerfile** | Defines **how to build one Docker image** |
| --- | --- |
| **docker-compose.yml** | Defines **how to run one or more containers together** |


Dockerfile  is used to create an **image** for our application. 
For example, for a Spring Boot app, the Dockerfile says:
- Use Java as the base image
- Copy the `.jar` file into the image
- Run the app using `java -jar`

FROM openjdk:22-jdk
ADD target/docker-demo.jar docker-demo.jar
ENTRYPOINT ["java","-jar","/docker-demo.jar"]

This creates an image for **only for  Spring Boot application**.

docker build -t docker-demo .

docker run -p 8090:8090 docker-demo


A file is used to run **multiple containers together**. `docker-compose.yml`
For example,  project needs:
1. Spring Boot app container
2. PostgreSQL database container

Instead of running many `docker run` commands manually,  define everything in `docker-compose.yml`

then run these command in terminal 

docker compose up --build


Docker-compose.yml answers which containers should run together 

Run Spring Boot app
Run PostgreSQL
Connect them in same Docker network
Create volume for database data
Expose ports

We use Dockerfile a so that our application can run the same way everywhere. `Dockerfile`
Some of the docker commands for image and containler 

dockers images 
docker ps
docker --version
docker build -t <IMAGE_NAME> .
docker run <IMAGE_NAME>

docker run -p <HOST_PORT>:<CONTAINER_PORT> <IMAGE_NAME>
docker ps -a
docker stop <CONTAINER_ID>
docker start <CONTAINER_ID_OR_NAME>
docker rm <CONTAINER_ID_OR_NAME>
docker rmi <IMAGE_ID_OR_NAME>
docker logs -f <CONTAINER_ID_OR_NAME>
docker network ls
docker volume ls


