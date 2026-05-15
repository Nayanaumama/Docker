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


Kubernates

Problems with hosting app direclt in containers

1.Multiple host
2.Manual healing (no Auto healing )
3.No autoscaling .Manually scaling
Docker is very simple it cannot support enterprise level means like loadbalancer ,firewall,autoscaling,autohealing,API gateway all of them cannot supported using this 

So solution is K8s(Kubernetes)
Kubernetes work on cluster (that is group of nodes) in master-slave form 
always one master and n number of slaves 

It solves the issues with docker 

Suppose one node has 100 containers and one container is having memeory issue then kubernetes will 
shift that containers to next node

Autosacling is very easy here -We do replica setting (HPA).

I will heal the damaged machine by using API server . 


There are two things in Kubernetes 

One is Controlplane whiche has 

API server 
etcd
scheduler
controller manager
ccm
cloud controller manager 

Node=one machine that can be phsical server or cloud vm

cluster=If there are multiple machines

container is package of each app  that is isolated running application 

pod : kubernetes  does not directly run the containers it runs in pods 

kubernetes 

pull image 
create container from image
wrap it inside pod

If the containers belong together tightly then same pod 
If no : seperate pods

No of pods depends on how much traffic/load/fault tolerance do ineed ?
More traffice more pods

Commom production Pattern 
1 pod -1app container 

Many replicas of pods .

pod 1 -app container
pod 2 -db  container

If i want more pods i can define this in kubernetes deployment.yaml 








Containers are ephemeral


