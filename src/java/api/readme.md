# API RESTful em Java Spring utilizando banco de dados H2

## Introdução

Este projeto demonstra a criação de uma API RESTful utilizando o framework Spring Boot e banco de dados H2. O projeto aborda os conceitos básicos de desenvolvimento de APIs RESTful, incluindo mapeamento de entidades, criação de endpoints, validação de dados e configuração de segurança.

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3.2
* Spring Data JPA 2.7
* H2 Database 2.1
* Lombok 1.8.24
* Hibernate Validator 6.2.1

## Configuração do Projeto

### Maven

O projeto é gerenciado por Maven, um sistema de gerenciamento de builds. Para configurar o Maven, utilize sua IDE favorita ou o comando `mvn install` no diretório raiz do projeto.

### Propriedades do Spring Boot

As propriedades do Spring Boot são definidas no arquivo `application.properties`. Este arquivo especifica configurações importantes, como a porta do servidor, o nome do banco de dados e as credenciais de acesso ao banco de dados.

### Banco de Dados H2

O H2 Database é um banco de dados em memória, leve e fácil de utilizar. O projeto configura o H2 como banco de dados in-memory, eliminando a necessidade de instalação de um banco de dados externo.

## Desenvolvimento da API

### Entidades

As entidades representam os modelos de dados da aplicação. Cada entidade é mapeada para uma tabela no banco de dados. O Lombok é utilizado para simplificar a criação de getters, setters, construtores e outros métodos padrão das entidades.

### Repositórios

Os repositórios são interfaces que abstraem o acesso ao banco de dados. O Spring Data JPA fornece implementações padrão para os repositórios, simplificando as operações de CRUD (create, read, update, delete).

### Endpoints

Os endpoints são URLs que permitem o acesso às funcionalidades da API. Os endpoints são definidos utilizando anotações do Spring MVC. Cada endpoint recebe uma requisição HTTP e retorna uma resposta.

### Validação de Dados

A validação de dados é realizada utilizando o Hibernate Validator. As anotações do Hibernate Validator são aplicadas às propriedades das entidades para definir regras de validação.

## Segurança

A segurança da API é configurada utilizando o Spring Security. O Spring Security fornece mecanismos para autenticação e autorização de usuários.

## Execução da API

Para executar a API, utilize um servidor de aplicações Java, como o Tomcat ou o Jetty. A API estará disponível na porta especificada no arquivo `application.properties`.

## Testes

O projeto inclui testes unitários e de integração para garantir o funcionamento correto da API. Os testes utilizam o JUnit 5 e o Spring Boot Test.

## Documentação

A API é documentada utilizando o Spring HATEOAS. O Spring HATEOAS fornece links de navegação entre os recursos da API, facilitando sua utilização.

## Considerações Finais

Este projeto fornece uma base sólida para o desenvolvimento de APIs RESTful em Java Spring utilizando o banco de dados H2. Os conceitos apresentados neste projeto podem ser facilmente aplicados a projetos mais complexos.