# MEMO - Agenda Digital

### Apresentação

Memo é uma aplicação web que emula uma agenda digital. Através de sua interface gráfica é possível criar contatos, salvando nome, e-mail, telefone e escolhendo um avatar para representá-lo. Também existe a possibilidade de atualizar e deletar esses contatos a qualquer momento. O projeto foi criado em Java e Spring Boot no Back-End e VueJs no Front-end.

Para utilizar, clone o repositório do projeto, instale o JDK (17 ou maior), rode npm install na pasta e rode o back-end. A interface gráfica poderá ser acessado no http://localhost:3333.

### Tecnologias utilizadas

No Front-End, além da trinca tradicional de desenvolvimento web (Html, Css e JavaScript), utilizei o VueJs como framework, tendo o apoio das bibliotecas do Prime Vue e do Prime Icon. O Vite ajudou na criação do template e organização do projeto;

No back-end, a linguagem utilizada foi Java e o Spring Boot foi o framework escolhido, tendo bibliotecas como Lombok, Spring Data JPA e Spring Web auxiliando na criação da API Rest;

O Banco de Dados foi feito no MYSQL e está alocado em nuvem através do Railway, podendo ser acessado de qualquer lugar;

Através da dependência Open API, foi criada a documentação Swagger, onde é descrita a documentação da API. Também utilizei o Postman para fazer requisições e testes;

### Estrutura de Pastas e Padrões de projeto


Na pasta models foi criada a Entidade Contacts, setando os parâmetros que seriam utilizados na tabela e em todo o projeto, sendo eles: contactName, contactEmail. contactPhone, contactAvatar, além de um Id e um egistrationDate gerados automaticamente;

Na Interface ContactRepository é feita a gerência do repositório da aplicação, possibilitando as transações com o banco de dados;

Já a ContactService é a camada responsável pelas regras de negócio do projeto, completando a camada de dados;

No Controller que é feita toda a gerência de fluxo da aplicação, estabelecendo os métodos que serão utilizados no front-end e criando todas as validações dos métodos de CRUD;

MemoApplication é a classe que roda a aplicação e SwaggerConfig ajuda na configuração da documentação Swagger.

###
