# API dos Chefes (Robot Masters) do Megaman

Um servidor Nodesimples listando os chefes da franquia Megaman.

## Rodando localmente

Veja como configurar e executar esta API localmente em sua máquina. Certifique-se de seguir cada etapa cuidadosamente para garantir uma configuração adequada.

## Pré-requisitos

Antes de começar, verifique se você possui as seguintes ferramentas e recursos instalados em sua máquina:

- **Java Development Kit (JDK)**: É necessário ter o JDK instalado em sua máquina. A API Spring Boot é baseada em Java. Você pode baixar o JDK mais recente em [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) ou [OpenJDK](https://adoptopenjdk.net/).

- **Maven (Opcional)**: O Maven é uma ferramenta de automação de compilação e gerenciamento de dependências amplamente usada para projetos Spring Boot. Você pode baixá-lo em [Apache Maven](https://maven.apache.org/download.cgi).

- **IDE (Ambiente de Desenvolvimento Integrado)**: Embora seja possível usar qualquer IDE de sua escolha, recomendamos o uso do [Spring Tool Suite (STS)](https://spring.io/tools) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/), pois eles oferecem suporte aprimorado para desenvolvimento Spring Boot.

## Configuração do Projeto

1. Clone ou baixe o repositório do seu projeto Spring Boot para o seu computador.

2. Abra o projeto em sua IDE preferida.

## Configuração do Banco de Dados

1. Certifique-se de que as dependências do banco de dados estejam no arquivo `pom.xml` (se estiver usando Maven) ou `build.gradle` (se estiver usando Gradle).

## Execução da API

Agora, você está pronto para executar sua API Spring Boot localmente:

1. Na sua IDE, localize a classe principal do aplicativo Spring Boot (geralmente possui a anotação `@SpringBootApplication`).

2. Clique com o botão direito do mouse na classe principal e escolha a opção para executar o aplicativo. Isso iniciará o servidor embutido Tomcat e implantará a API.

3. Assim que o aplicativo estiver em execução, você poderá acessá-lo no navegador ou em um cliente de API, dependendo da sua configuração.

## Testando a API

Depois de iniciar a API, você pode testá-la usando uma ferramenta como [Postman](https://www.postman.com/) ou [curl](https://curl.se/).

## Encerrando a Execução

Para encerrar a execução da API, você pode parar o processo na sua IDE ou usar o comando `Ctrl+C` no terminal em que a API está sendo executada.

# Megaman API Documentation

## Overview

The Megaman API provides endpoints to manage and retrieve information about Robot Masters defeated in battles. It includes operations to get a list of all Robot Masters, find Robot Masters by series, retrieve Robot Masters sorted by name, get details of a specific Robot Master, and fetch scores of defeated robots for a particular Robot Master.

## Base URL

The base URL for accessing the Megaman API is `http://your-api-base-url/robotmasters`.

## Endpoints

### 1. Get All Robot Masters

- **Endpoint:** `/`
- **Method:** `GET`
- **Description:** Retrieve a list of all Robot Masters.
- **Response:**
  - Status Code: 200 OK
  - Body: List of RobotMaster objects.

### 2. Find Robot Masters by Series

- **Endpoint:** `/series/{series}`
- **Method:** `GET`
- **Description:** Retrieve a list of Robot Masters based on the specified series.
- **Parameters:**
  - `series` (Path Variable): The series to filter Robot Masters.
- **Response:**
  - Status Code: 200 OK
  - Body: List of RobotMaster objects.

### 3. Get Sorted Robot Masters

- **Endpoint:** `/sorted`
- **Method:** `GET`
- **Description:** Retrieve a list of Robot Masters sorted by name.
- **Response:**
  - Status Code: 200 OK
  - Body: List of RobotMaster objects.

### 4. Get Robot Master by ID

- **Endpoint:** `/{id}`
- **Method:** `GET`
- **Description:** Retrieve details of a specific Robot Master by its ID.
- **Parameters:**
  - `id` (Path Variable): The ID of the Robot Master.
- **Response:**
  - Status Code: 200 OK
  - Body: RobotMaster object.

### 5. Get Scores of Defeated Robots for a Robot Master

- **Endpoint:** `/score/{id}`
- **Method:** `GET`
- **Description:** Retrieve scores of defeated robots for a specific Robot Master.
- **Parameters:**
  - `id` (Path Variable): The ID of the Robot Master.
- **Response:**
  - Status Code: 200 OK
  - Body: List of Score objects.
- **Error Handling:**
  - Status Code: 404 Not Found
  - Body: ResourceNotFoundException if the Robot Master with the specified ID is not found.

### 6. Create a New Robot Master

- **Endpoint:** `/`
- **Method:** `POST`
- **Description:** Create a new Robot Master.
- **Request Body:**
  - RobotMaster object.
- **Response:**
  - Status Code: 201 Created
  - Body: RobotMaster object with the generated ID.
- **Error Handling:**
  - Status Code: 400 Bad Request
  - Body: If the request body is invalid.

### 7. Update a Robot Master

- **Endpoint:** `/{id}`
- **Method:** `PUT`
- **Description:** Update details of a specific Robot Master.
- **Parameters:**
  - `id` (Path Variable): The ID of the Robot Master.
- **Request Body:**
  - RobotMaster object with updated details.
- **Response:**
  - Status Code: 200 OK
  - Body: Updated RobotMaster object.
- **Error Handling:**
  - Status Code: 404 Not Found
  - Body: ResourceNotFoundException if the Robot Master with the specified ID is not found.
  - Status Code: 400 Bad Request
  - Body: If the request body is invalid.

### 8. Delete a Robot Master

- **Endpoint:** `/{id}`
- **Method:** `DELETE`
- **Description:** Delete a specific Robot Master.
- **Parameters:**
  - `id` (Path Variable): The ID of the Robot Master.
- **Response:**
  - Status Code: 204 No Content
- **Error Handling:**
  - Status Code: 404 Not Found
  - Body: ResourceNotFoundException if the Robot Master with the specified ID is not found.
  - Status Code: 500 Internal Server Error
  - Body: DatabaseException if an error occurs during the deletion process.

## Data Models

### RobotMaster

- `id` (UUID): Unique identifier for the Robot Master.
- `series` (String): The series to which the Robot Master belongs.
- `robotNumber` (int): The number assigned to the Robot Master.
- `name` (String): The name of the Robot Master.
- `weapon` (String): The primary weapon of the Robot Master.
- `avatar` (String): URL or path to the Robot Master's avatar image.
- `sprite` (String): URL or path to the Robot Master's sprite image.
- `weakness` (String): The weakness of the Robot Master.

### Score

- `user` (String): The username of the user who defeated the Robot Master.
- `robotMaster` (RobotMaster): The details of the defeated Robot Master.
- `damageTaken` (int): The amount of damage taken by the user during the battle.
- `time` (Timestamp): The timestamp of when the battle took place.

## Error Handling

The API handles errors with appropriate HTTP status codes and provides detailed error messages in the response body. Common error responses include:

- 400 Bad Request: I

