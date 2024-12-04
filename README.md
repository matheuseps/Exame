Cadastro de Séries de TV
Este projeto é uma aplicação de cadastro de séries de TV desenvolvida com Spring Boot e utilizando H2 como banco de dados em memória. O objetivo do sistema é permitir o cadastro, visualização e manipulação de informações sobre séries de TV.

Tecnologias Utilizadas
Spring Boot: Framework para construção da aplicação web.
H2 Database: Banco de dados em memória para desenvolvimento e testes.
Spring Data JPA: Para integração com o banco de dados e persistência de dados.
Hibernate: Framework ORM para facilitar a interação entre Java e o banco de dados.
Thymeleaf: Motor de templates para renderizar páginas HTML.
Spring DevTools: Para facilitar o desenvolvimento e reinicialização automática da aplicação.
Pré-requisitos
Antes de começar, certifique-se de ter o seguinte instalado:

Java 17 ou superior - O Spring Boot 3.x requer Java 17 ou versão superior.
Maven - Para compilar e executar a aplicação.
IDE (opcional) - Como IntelliJ IDEA, Eclipse ou VS Code para facilitar o desenvolvimento.
Como Executar a Aplicação
1. Clone o Repositório
bash
Copiar código
git clone https://github.com/seu-usuario/cadastro-de-series-tv.git
2. Navegue até o Diretório do Projeto
bash
Copiar código
cd cadastro-de-series-tv
3. Compile e Execute a Aplicação com Maven
Se você tem o Maven instalado, execute o seguinte comando para compilar e rodar a aplicação:

bash
Copiar código
mvn spring-boot:run
Ou, se preferir, pode usar o Maven Package para criar um arquivo .jar executável:

bash
Copiar código
mvn clean package
E então, execute o arquivo .jar gerado na pasta target:

bash
Copiar código
java -jar target/cadastro-de-series-tv-0.0.1-SNAPSHOT.jar
4. Acesse o Aplicativo
A aplicação estará rodando localmente na URL:

arduino
Copiar código
http://localhost:8080
Para acessar o console do banco de dados H2, que permite visualizar e manipular o banco de dados em memória, acesse:

bash
Copiar código
http://localhost:8080/h2-console
Credenciais do Banco H2:

URL: jdbc:h2:mem:testdb
Username: sa
Password: password
5. Alterações na Configuração
A configuração de banco de dados e do Hibernate está definida no arquivo src/main/resources/application.properties. Caso queira modificar algum parâmetro, edite o arquivo conforme necessário.

Aqui está um exemplo das configurações do banco H2:

properties
Copiar código
# Nome da aplicação
spring.application.name=cadastro-de-series-tv

# Porta do servidor
server.port=8080

# Banco de dados H2 (em memória)
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

# Configuração do Hibernate (JPA)
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update  # Define como o banco de dados será gerido (pode ser 'create', 'update', 'none' etc.)

# Exibe as SQLs no log
spring.jpa.show-sql=true

# Formatação das SQLs no log
spring.jpa.properties.hibernate.format_sql=true

# Console H2 para depuração (acessível pelo navegador)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
Funcionalidades
Cadastro de Séries: Adicione informações sobre as séries de TV, como título, gênero e ano de lançamento.
Listagem de Séries: Visualize a lista de todas as séries cadastradas no banco de dados.
Edição e Exclusão: Possibilidade de editar ou excluir séries da lista.
Estrutura do Projeto
src/main/java: Código Java da aplicação.
com/cadastroseriestv: Pacote principal com as classes de controle, modelos e repositórios.
src/main/resources: Arquivos de configuração, templates e arquivos estáticos.
application.properties: Arquivo de configuração do Spring Boot.
templates/: Contém os templates Thymeleaf.
static/: Contém arquivos estáticos como CSS, JavaScript, imagens, etc.
src/test/java: Contém os testes da aplicação.
Endpoints da API
GET /series: Retorna a lista de todas as séries cadastradas.
POST /series: Adiciona uma nova série ao banco de dados.
PUT /series/{id}: Atualiza as informações de uma série existente.
DELETE /series/{id}: Remove uma série do banco de dados.
Exemplo de Uso da API
Adicionar uma Nova Série (POST)
bash
Copiar código
POST /series
{
  "titulo": "Breaking Bad",
  "genero": "Crime",
  "ano": 2008
}
Listar as Séries (GET)
bash
Copiar código
GET /series
Atualizar uma Série (PUT)
bash
Copiar código
PUT /series/{id}
{
  "titulo": "Breaking Bad",
  "genero": "Crime, Drama",
  "ano": 2008
}
Excluir uma Série (DELETE)
bash
Copiar código
DELETE /series/{id}
Contribuição
Se você quiser contribuir para este projeto, por favor, siga os passos abaixo:

Fork este repositório.
Crie uma branch para sua feature (git checkout -b feature/nome-da-feature).
Faça suas alterações e faça o commit (git commit -am 'Add new feature').
Push para a branch (git push origin feature/nome-da-feature).
Abra um Pull Request.
Licença
Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.
