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

## Get all Robot Masters

- **URL:** `/robotmasters/`
- **Method:** `GET`
- **Response:** List of all Robot Masters

## Get Robot Masters by Series

- **URL:** `/robotmasters/series/{series}`
- **Method:** `GET`
- **Response:** List of Robot Masters belonging to the specified series

## Get all Robot Masters sorted

- **URL:** `/robotmasters/sorted`
- **Method:** `GET`
- **Response:** List of all Robot Masters sorted

## Get Robot Master by ID

- **URL:** `/robotmasters/{id}`
- **Method:** `GET`
- **Response:** Details of the Robot Master with the specified ID

## Get scores of defeated robots by Robot Master ID

- **URL:** `/robotmasters/score/{id}`
- **Method:** `GET`
- **Response:** List of scores (user, damage taken, time) for the defeated robots of the specified Robot Master ID

# UserController

## Create a new user

- **URL:** `/users/create`
- **Method:** `POST`
- **Request Body:** User model information (username, name, password)
- **Response:** Created user details or error message if the username already exists

## Login

- **URL:** `/users/login`
- **Method:** `POST`
- **Request Body:** User model information (username, password)
- **Response:** User details or error message if the username or password is incorrect

# RobotListController

## Register a defeated Robot Master

- **URL:** `/robotlist/save`
- **Method:** `POST`
- **Request Body:** Robot Master ID, damage taken, time (LocalDateTime format)
- **Response:** Updated Robot List or error message if Robot Master is not found or already defeated

## Get Robot List for the current user

- **URL:** `/robotlist/`
- **Method:** `GET`
- **Response:** Robot List for the current user

## Delete a defeated Robot Master from the Robot List

- **URL:** `/robotlist/delete/{id}`
- **Method:** `DELETE`
- **Request Parameters:** Robot Master ID
- **Response:** Updated Robot List or error message if Robot List or Robot Master is not found
