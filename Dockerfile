# Use offical tomcat runtime as a parent image
FROM openjdk:17-jdk-alpine

#Expose port 8080 for container
EXPOSE 8080

# COPY env.properties env.properties
COPY target/finalJar.jar finalJar.jar
ENTRYPOINT ["java","-jar","/finalJar.jar"]