# PART 1 - BUILD PROCESS
FROM ubuntu:latest AS build

# Update all packages
RUN apt-get update
# Install JDK version 17
RUN apt-get install openjdk-17-jdk -y
# Copy all files from local machine to the image
COPY . .

# Install Maven
RUN apt-get install maven -y
# Generate .jar from application
RUN mvn clean install

# PART 2 - RUNS APPLICATION
FROM openjdk:17-jdk-slim
# Spring Boot runs on port 8080 (default)
EXPOSE 8080

# Copy generated jar to a file (app.jar)
COPY --from=build /target/job_management-0.0.1.jar app.jar

# Execute file (app.jar) = Java file, with extension .jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
