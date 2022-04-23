# 📝 Sobre

Este é um projeto que tem como objetivo demonstrar a utilização do [Swagger](https://swagger.io/) através da biblioteca [Springfox](https://springfox.github.io/springfox/) para documentar uma API REST utilizando o framework [Spring Boot](https://spring.io/projects/spring-boot).

Para a demonstração dos recursos de documentação, foi criado uma API de um CRUD, onde será possível realizar as operações corriqueiras do CRUD (cadastrar, atualizar, deletar e listar), além de uma URL para atualizar apenas a senha do usuário/pessoa. 

<br/>

# 🎥 Vídeos

<div align="center">
    <div>
        <p style="font-size: 15px;">Navegação pela página da documentação</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/pagina-swagger.gif?raw=true" alt="Página Swagger">
    </div>
    <br/>
    <div>
        <p style="font-size: 15px;">Cadastrando pela documentação</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/cadastro-pessoa-swagger.gif?raw=true" alt="Cadastro Swagger">
    </div>
    <br/>
    <div>
        <p style="font-size: 15px;">Requisição de busca por ID</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/busca-pessoa-por-id-swagger.gif?raw=true" alt="Busca ID Swagger">
    </div>
    <br/>
</div>

<br/>

# 🎨 Imagens

<div align="center">
    <div>
        <p style="font-size: 15px;">Informações da API</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/informacao-api.png?raw=true" alt="Informações API">
    </div>
    <div>
        <p style="font-size: 15px;">Gerenciador de pessoa</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/gerenciador-pessoa.png?raw=true" alt="Gerenciador Pessoa">
    </div>
    <div>
        <p style="font-size: 15px;">Requisição para cadastro</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/requisicao-cadastro.png?raw=true" alt="Requisição Cadastro">
    </div>
    <div>
        <p style="font-size: 15px;">Resposta de atualização</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/resposta-atualiza.png?raw=true" alt="Resposta Atualização">
    </div>
    <div>
        <p style="font-size: 15px;">Modelos</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/modelos.png?raw=true" alt="Modelos">
    </div>
    <div>
        <p style="font-size: 15px;">Modelo cadastro</p>
        <img src="https://github.com/Edvan-Oliveira/imagens/blob/main/documentacao-swagger/modelo-cadastro.png?raw=true" alt="Modelo Cadastro">
    </div>
</div>


# 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 2.6.7
- Banco de dados H2
- Spring Data JPA
- Lombok
- Maven
- Springfox
- Swagger

<br/>

# 🔗 Link para acessar a API remotamente

Para acessar a API que está hospedada na plataforma [Heroku](https://id.heroku.com/login) e poder testar as rotas, basta clicar aqui: https://edvan-documentacao-swagger.herokuapp.com/swagger-ui/

Vale lembrar que o Swagger permite realizar requisições dentro da própria documentação, então sinta-se livre para testar a API sem dificuldades.

<br/>

# 👓 Instruções de como rodar o projeto localmente em sua máquina

Para executar localmente, apenas será necessário ter instalados em sua máquina os seguintes programas: [Java](https://www.java.com/pt-BR/), [Git](https://git-scm.com/) e [Maven](https://maven.apache.org/).

Com todos os programas devidamente instalados, agora é só executar em um terminal os comandos abaixo:

```bash
$ git clone https://github.com/Edvan-Oliveira/documentacao-swagger.git

$ cd documentacao-swagger

$ mvn clean install

$ mvn spring-boot:run

# Se seu maven falhar, tente rodar '.jar'

$ cd target

$ java -jar documentacao-swagger-0.0.1-SNAPSHOT.jar

```

#

## Contatos

<div>
    <a href="https://www.linkedin.com/in/edvan-oliveira-0822b2227/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href = "mailto:edvan.oliveiract@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href = "https://t.me/Edvan_Oliveira"><img src="https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" target="_blank"></a>

</div>

#
