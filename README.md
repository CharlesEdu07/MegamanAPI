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

# Robot Master API

## Get All Robot Masters

### `GET /robotmasters`

Retrieve all Robot Masters.

**Response:**
- 200 OK: Returns the list of all Robot Masters.

## Get Robot Masters by Series

### `GET /robotmasters/series/{series}`

Retrieve Robot Masters by series.

**Parameters:**
- `series` (String): Series name.

**Response:**
- 200 OK: Returns the list of Robot Masters in the specified series.

## Get All Robot Masters Sorted

### `GET /robotmasters/sorted`

Retrieve all Robot Masters sorted.

**Response:**
- 200 OK: Returns the list of all Robot Masters sorted.

## Get Robot Master by ID

### `GET /robotmasters/{id}`

Retrieve a specific Robot Master by ID.

**Parameters:**
- `id` (UUID): Robot Master ID.

**Response:**
- 200 OK: Returns the Robot Master details.
- 404 Not Found: If Robot Master not found.

## Get Defeated Robots and Scores for a Robot Master

### `GET /robotmasters/score/{id}`

Retrieve the top 10 scores (defeated robots) for a specific Robot Master.

**Parameters:**
- `id` (UUID): Robot Master ID.

**Response:**
- 200 OK: Returns the list of scores.

---

# User API

## Create User

### `POST /users/`

Create a new user.

**Request:**
- Body:
  - `UserModel` (JSON): User details.

**Response:**
- 201 Created: Returns the created user.
- 400 Bad Request: If the username already exists.

## Get All Users

### `GET /users/`

Retrieve the list of all users.

**Response:**
- 200 OK: Returns the list of all users.
