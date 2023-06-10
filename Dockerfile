FROM eclipse-temurin:11-jdk-focal
WORKDIR /app
RUN echo copiando o .jar da pasta adapter/target do projeto, para pasta /app do container
COPY adapter/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

