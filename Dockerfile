FROM openjdk:11
EXPOSE 8081
ADD target/food-blog.jar food-blog.jar
ENTRYPOINT ["java","-jar","/food-blog.jar"]