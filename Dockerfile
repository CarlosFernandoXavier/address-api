FROM alpine:3.14

RUN  apk update && apk upgrade #Atualização do sistema operacional linux alpine
RUN  apk add openjdk11         #Instalação do Java 11
RUN apk add maven              #Instalação do maven
RUN echo copiando a pasta src do projeto, para a pasta /home/app/src do alpine
COPY adapter /home/app/adapter
COPY application /home/app/application
RUN echo copiando o arquivo pom.xml do projeto, para a pasta /home/app do alpine
COPY pom.xml /home/app
COPY mvnw /home/app
COPY mvnw.cmd /home/app/
WORKDIR /home/app/
RUN mvn package
#RUN mvn -f /home/app/pom.xml clean package   # executando o comando para gerar .jar dentro do alpine
#RUN mvn clean -f /home/app/pom.xml install
#RUN mvn /home/app/pom.xml clean package
