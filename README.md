# Sobre o projeto
O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir APIs utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html), [H2 Database](https://www.h2database.com/html/tutorial.html), [OAuth 2.0](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html), [Lombok](https://projectlombok.org/), [swagger](https://swagger.io/) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

A aplicação consiste em desenvolver uma solução para o desafio abaixo: 

# Desafio.
Crie uma aplicação utilizando Java e Spring Boot que forneça uma API REST para manter o cadastro
de beneficiários de um plano de saúde.
Devem ser expostos endpoints para executar as seguintes operações:
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.
Opcional:
- Implementar autenticação/autorização para acesso aos endpoints;

# Tecnologias utilizadas
## Back end
- Java 17
- Spring Boot
- JPA / Hibernate
- Maven
- H2 Database
- Swagger
- OAuth 2.0
 
## Instalação da aplicação

Pré-requisitos: Java 17

Primeiramente, faça o clone do repositório:
```
https://github.com/emmanuelneri/productivity-with-spring.git
```
Feito isso, acesse o projeto:
```
cd productivity-with-spring
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8091 e a documentação estara disponivel em http://localhost:8091/swagger-ui/index.html#/
```
Tomcat started on port(s): 8091 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```
# Criação de um usuário

Método Post http://localhost:8091/usuario/post

Json de Exempo:
```
{
 "login":"alan",
 "password": "123"
}
```
Retorno: Usuario Registrado com sucesso.

![image](https://github.com/alancandidoborges/desafio-ekan/assets/105753591/6cec7b26-a4b9-4ea1-924e-996b16c7b773)

# Autenticação de um usuário

Método Post [http://localhost:8091/usuario/post

```
Json de Exempo:
{
 "login": "alan",
 "password":"123"
}
```

Retorno
```
{
	"token": "numero do token"
}
``````
![image](https://github.com/alancandidoborges/desafio-ekan/assets/105753591/64dd2082-c2ed-43d3-834a-bcd7134d9447)

# Ultilize o tokem gerado nas requisições

![image](https://github.com/alancandidoborges/desafio-ekan/assets/105753591/7ed06203-001d-41da-ab3f-f0df0e33f892)

# End-points disponivel na aplicação
![image](https://github.com/alancandidoborges/desafio-ekan/assets/105753591/ed2f0c69-df44-4e6e-9c23-c288fe90daae)

# Autor

Alan Candido Borges Barreto

[https://www.linkedin.com/in/alan-candido-borges-barreto-303240176/]

