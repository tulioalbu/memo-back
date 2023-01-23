# MEMO - Agenda Digital

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image1.png" width = "540">

### Apresentação

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image2.png" width = "540">

Memo é uma aplicação web que emula uma agenda digital. Através de sua interface gráfica é possível criar contatos, salvando nome, e-mail, telefone e escolhendo um avatar para representá-lo. Também existe a possibilidade de atualizar e deletar esses contatos a qualquer momento. O projeto foi criado em Java e Spring Boot no Back-End e VueJs no Front-end. 

Para utilizar, clone o repositório do projeto, instale o JDK (17 ou maior), rode npm install na pasta do front-end e rode o back-end através de sua IDE. A interface gráfica poderá ser acessada no http://localhost:3333 e o back-end responde no http://localhost:8080. Há dockerfiles tanto no back como no front pra facilitar a utilização do app.

Acesse os repositórios do projeto no Github:
Back-end: https://github.com/tulioalbu/memo-back
Front-end: https://github.com/tulioalbu/memo-front

### Tecnologias utilizadas
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image3.png" width = "540">

No Front-End, além da trinca tradicional de desenvolvimento web (Html, Css e JavaScript), utilizei o VueJs como framework, tendo o apoio das bibliotecas do Prime Vue e do Prime Icon. O Vite ajudou na criação do template e organização do projeto e o axios para as requisições http;

No back-end, a linguagem utilizada foi Java e o Spring Boot foi o framework escolhido, tendo bibliotecas como Lombok, Spring Data JPA, Spring Remote e Spring Web auxiliando na criação da API Rest;

O Banco de Dados foi feito no MYSQL e está alocado em nuvem através do Railway, podendo ser acessado de qualquer lugar;

Através da dependência Open API, foi criada a documentação Swagger, onde é descrita a documentação da API. Também utilizei o Postman para fazer requisições e testes durante a construção do back-end;

Utilizei o VsCode como IDE para fazer front-end e o Intellij no back-end pela maior facilidade de escrever em Java neste ambiente.

### Estrutura de Pastas e Padrões de projeto
 
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image4.png" width = "540">

Na pasta models foi criada a Entidade Contacts, setando os parâmetros que seriam utilizados na tabela e em todo o projeto, sendo eles: contactName, contactEmail. contactPhone, contactAvatar, além de um Id e um registrationDate gerados automaticamente;

Na Interface ContactRepository é feita a gerência do repositório da aplicação, possibilitando as transações com o banco de dados;

Já a ContactService é a camada responsável pelas regras de negócio do projeto, completando a camada de dados;

No Controller que é feita toda a gerência de fluxo da aplicação, estabelecendo os métodos que serão utilizados no front-end e criando todas as validações dos métodos de CRUD;

MemoApplication é a classe que roda a aplicação e SwaggerConfig ajuda na configuração da documentação Swagger.

### CRUD e Validações

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image5.png" width = "540">

No Controller, além de todo o mapeamento que será utilizado nas requisições (GET, GET by ID, POST, PUT e DELETE), são feitas todas as validações do projeto. Não é possível cadastrar o mesmo e-mail ou telefone duas vezes, por exemplo. Também são criadas mensagens de erro para contatos não encontrados, deletados e outras situações recorrentes. 

### Swagger e Endereçamento
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image6.png" width = "540">

Uma das formas de entender os endereçamentos e testar a aplicação é o Swagger. Neste projeto, é possível acessar através do endereço: http://localhost:8080/swagger-ui/index.html

Para listar todos os contatos ou inserir um novo utilizando GET e POST: http://localhost:8080/contacts

Para buscar um usuário específico, deletar ou atualizar pelo id utilizando GET, DELETE E PUT: http://localhost:8080/contacts/{id}

### Rotas e estrutura do JSON
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image7.png" width = "540">

No Postman, é possível testar todos as rotas da API utilizando a estrutura de JSON ilustrada na imagem;
Ao salvar no banco de dados, a aplicação retorna um ID gerado automaticamente e uma data de registro.

### Railway e MySQL
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image8.png" width = "540">

O banco de dados MySQL está hospedado no Railway, um serviço de nuvem equivalente ao Heroku. Lá é possível acompanhar toda a movimentação feita na aplicação através da tabela tb_contact. Independente de onde a API seja bootada, o banco de dados persistirá as informações, fazendo update sempre houver nova inserção. Também fiz deploy de uma build utilizando o dockerfile para testes. 

### Ideação e Prototipação visual:

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image9.png" width = "540">
  
Assim que tive acesso às orientações do desafio, desenhei um esboço de seu conceito visual utilizando o Canva e bibliotecas como Flat Icon e Adobe Stock. Por se tratar de um projeto não comercial, pude escolher as imagens que melhor se encaixavam com o conceito de uma agenda digital com temática divertida. Os avatares, por exemplo, servem como alternativa para a ilustração dos contatos de maneira simples, intuititiva e lúdica; 

Pensando em sua estrutura, o site foi projetado inicialmente com três componentes: Header, um formulário para cadastro e uma lista de contatos salvos, com cards e funções de delete e edit; Posteriormente foi necessário criar uma view também para atualização do contato; 

### Estrutura de pastas
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image10.png" width = "540">

O projeto foi criado a partir de um template do Vite, facilitando a estruturação do ambiente em VueJs e sua documentação;

O App.vue divide o site em duas colunas, setando do lado A os componentes Header e FormUser. Também há aqui a criação dos principais scripts da aplicação;

No lado B é feita requisição HTTP de GET utilizando a extensão Axios, possibilitando a listagem dos componentes de Card;

Ao clicar em um Card, é aberta um componente de UpdateUser onde é feita a requisição PUT;

No FormUser é feita a requisição POST;

A pasta Assets contém todas as imagens em PNG com os avatares, ícones, logo, etc.;

O main.js e style.css contém apenas configurações básicas do projeto.

### Estrutura Visual do Site

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image11.png" width = "540">

Aqui é possível entender melhor como funciona visualmente o site e seus elementos;

O Elemento 1 é o Header, com função apenas estética;

O Elemento 2 (FormUser) tem os inputTexts de Nome, Telefone e Email, um dropdown que permite escolher entre 14 avatares distintos, além do button de adicionar. Todo esse layout foi feito com módulos do PrimeVue;

O Elemento 3 é uma lista infinita com barra de rolagem que recebe inúmeros cards. Neles há os botões de edit e delete e as informações salvas a partir do POST, incluindo o avatar;

Todos os ícones são da biblioteca PrimeIcon.

### Página de Edit

<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image12.png" width = "540">

Ao clicar no botão de edit presente no card, é aberto um form de update. O contato escolhido fica em destaque com a cor cinza e o formulário traz todas as informações salvas com a possibilidade de editar por completo. Ao fim, basta apertar o botão "Modificar" que a atualização é feita.

### Mensagens de sucesso, confirmação e erro
  
<p float="left">
<img src="https://tulioalbu.github.io/memo-back/images/image13.png" width = "540">

Determinadas ações do usuário geram toasts na tela. São três mensagens de sucesso: uma de contato adicionado, outra de contato modificado e outra de contato deletado. Também há um toast de confirmação quando o usuário quiser deletar um contato e mais quatro mensagens de conflito registradas na API, não permitindo que o usuário salve contatos com informações iguais.






