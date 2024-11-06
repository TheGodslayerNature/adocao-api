# Define a imagem base
FROM openjdk:11

# Copia o arquivo JAR do seu projeto para dentro do container
COPY . .

# Define o diretório de trabalho
WORKDIR /app

# Instala o MySQL
RUN apt-get update && apt-get install -y mvn
RUN mvn package

# Expõe a porta do seu projeto
EXPOSE 8080
COPY --from=build /target/adocao-api-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de inicialização do seu projeto
CMD ["java", "-jar", "app.jar"]