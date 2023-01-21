# MEMO - Agenda Digital

### Apresentação

Memo é uma aplicação web que emula uma agenda digital. Através de sua interface gráfica é possível criar contatos, salvando nome, e-mail, telefone e escolhendo um avatar para representá-lo. Também existe a possibilidade de atualizar e deletar esses contatos a qualquer momento. O projeto foi criado em Java e Spring Boot no Back-End e VueJs no Front-end.


Para utilizar, clone o repositório do projeto, instale o JDK (17 ou maior), rode npm install na pasta do front-end e rode o back-end através de sua IDE. A interface gráfica poderá ser acessado no http://localhost:3333.

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

### CRUD e Validações

No Controller, além de todo o mapeamento que será utilizado nas requisições (GET, GET by ID, POST, PUT e DELETE), são feitas todas as validações do projeto. Não é possível cadastrar o mesmo e-mail ou telefone duas vezes, por exemplo. Também são criadas mensagens de erro para contatos não encontrados, deletados e outras situações recorrentes. 

### Swagger e Endereçamento

Uma das formas de entender os endereçamentos e testar a aplicação é o Swagger. Neste projeto, é possível acessar através do endereço: http://localhost:8080/swagger-ui/index.html

Para listar todos os contatos ou inserir um novo utilizado GET e POST: http://localhost:8080/contacts

Para buscar um usuário específico, deletar ou atualizar pelo id utilizando GET, DELETE E PUT: http://localhost:8080/contacts/{id}

### Rotas e estrutura do JSON

No Postman, é possível testar todos as rotas da API utilizando a estrutura de JSON ilustrada na imagem;
Ao salvar no banco de dados, a aplicação retorna um ID gerado automaticamente e uma data de registro.

### Railway e MySQL

O banco de dados MySQL está hospedado no Railway, um serviço de nuvem. Lá é possível acompanhar toda a movimentação feita na aplicação através da tabela tb_contact. Independente de onde a API seja bootada, o banco de dados persistirá as informações, fazendo update sempre houver nova inserção.

### Ideação e Prototipação visual:

Assim que tive acesso às orientações do desafio, desenhei um esboço de seu conceito visual utilizando o Canva e bibliotecas como Flat Icon e Adobe Stock. Por se tratar de um projeto não comercial, pude escolher as imagens que melhor se encaixavam com o conceito de uma agenda digital com temática divertida. Os avatares, por exemplo, servem como alternativa para a ilustração dos contatos de maneira simples, intuititiva e lúdica; 

Pensando em sua estrutura, o site foi projetado inicialmente com três componentes: Header, um formulário para cadastro e uma lista de contatos salvos, com cards e funções de delete e edit; Posteriormente foi necessário criar uma view também para atualização do contato; 
