# Define a imagem base
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get update
RUN apt-get install maven -y
RUN apt mvn package

FROM openjdk:21
# Expõe a porta do seu projeto
EXPOSE 8080
COPY --from=build /target/adocao-api-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de inicialização do seu projeto
CMD ["java", "-jar", "app.jar"]