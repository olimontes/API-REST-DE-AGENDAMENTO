# API de Agendamentos com Spring Boot

![Java](https://img.shields.io/badge/Java-21-blue.svg?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-brightgreen.svg?logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-darkblue.svg?logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-red.svg?logo=apache-maven)

Este projeto é uma API RESTful para um sistema de agendamentos, desenvolvida como um estudo prático do ecossistema Spring. A API permite o cadastro de usuários e a criação de agendamentos vinculados a eles, persistindo os dados em um banco PostgreSQL.

## 🚀 Funcionalidades

* **Gerenciamento de Usuários:**
    * Criar novos usuários.
    * Listar todos os usuários cadastrados.
    * Buscar um usuário específico por ID.
* **Gerenciamento de Agendamentos:**
    * Criar novos agendamentos vinculados a um usuário existente.
    * Listar todos os agendamentos de um usuário específico.

## 🛠️ Tecnologias Utilizadas

* **Backend:**
    * Java 21
    * Spring Boot 3 (incluindo Spring Web e Spring Boot DevTools)
    * Spring Data JPA (com Hibernate)
* **Banco de Dados:**
    * PostgreSQL
* **Build:**
    * Maven

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
* [JDK 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows) ou superior.
* [Apache Maven](https://maven.apache.org/download.cgi) 3.8 ou superior.
* Uma instância do [PostgreSQL](https://www.postgresql.org/download/) rodando.
* Um cliente de API, como [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download).

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://[URL-DO-SEU-REPOSITORIO-NO-GITHUB].git
    cd agendamento-api
    ```

2.  **Configure o Banco de Dados:**
    * Abra seu cliente PostgreSQL (como o pgAdmin).
    * Crie um novo banco de dados. Ex: `CREATE DATABASE agendamentodb;`
    * Abra o arquivo `src/main/resources/application.properties`.
    * **Atualize as propriedades** com suas credenciais do PostgreSQL (o projeto está pré-configurado com os dados que você me passou):

    ```properties
    # Endereço e nome do seu banco
    spring.datasource.url=jdbc:postgresql://localhost:5432/agendamentodb
    
    # Seu usuário e senha do PostgreSQL
    spring.datasource.username=frank
    spring.datasource.password=root

    # Configurações do Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    
    # Porta da aplicação (configuramos para 8081)
    server.port=8081
    ```

3.  **Execute a Aplicação:**
    * **Pela sua IDE:** Abra o projeto na sua IDE (IntelliJ, VS Code, etc.) e execute a classe principal `AgendamentoApiApplication.java`.
    * **Pelo terminal (via Maven):**
    ```bash
    mvn spring-boot:run
    ```

A API estará no ar e pronta para receber requisições em `http://localhost:8081`.


### 👤 Usuários

#### 1. Criar Novo Usuário
* **Método:** `POST`
* **URL:** `http://localhost:8081/usuarios`
* **Body (JSON):**

```json
{
    "nome": "Seu Nome Completo",
    "cpf": "11122233344",
    "email": "seu.email@exemplo.com",
    "senha": "suaSenha123",
    "telefone": "38999998888",
    "endereco": "Rua das Flores, 123",
    "cidade": "Montes Claros",
    "estado": "MG",
    "cep": "39400-000"
}

## 📁 Estrutura do Projeto

O projeto segue a arquitetura padrão em camadas (Model-Repository-Service-Controller):
