FROM openjdk:11
EXPOSE 8081
ADD target/food-blog-docker.jar food-blog-docker.jar
ENTRYPOINT ["java","-jar","/food-blog-docker.jar"]