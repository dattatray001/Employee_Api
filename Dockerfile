# Use the OpenJDK 21 base image
FROM openjdk:21-jdk

# Copy the JAR file from the target directory to the container and name it employeeapi.jar
COPY target/*.jar employeeapi.jar

# Expose port 8080 for the application
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/employeeapi.jar"]
