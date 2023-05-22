FROM openjdk:8
ADD build/libs/*.jar dockerimage.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/dockerimage.jar"]