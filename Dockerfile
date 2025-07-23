FROM openjdk:23
EXPOSE 8090

WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN chmod 755 /app/mvnw

RUN ./mvnw dependency:go-offline -B -Dmaven.artifact.threads=35

RUN ./mvnw package #-DskipTests
ENTRYPOINT ["java","-jar","target/pension-v2.jar"]