# Livraria 

**Descrição**: Uma API desenvolvida em Java com Spring Boot, focada em um CRUD de livros.

## 🚀 Funcionalidades
- Cadastro
- Leitura
- Atualizar
- Deletar

## 🛠️ Tecnologias Utilizadas
- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [SQLite](https://sqlite.org/)
- [Docker](https://www.docker.com/)
- [JUnit](https://junit.org/) e [Mockito](https://site.mockito.org/)


## 🔧 Pré-requisitos
Certifique-se de ter instalado:
- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) >= 17
- [Docker](https://docs.docker.com/get-docker/) e [Docker Compose](https://docs.docker.com/compose/)

## 📦 Como Instalar e Executar o Projeto

### Sem Docker:
1. Clone o repositório:
   ```bash
   git clone https://github.com/mariaoliveira27/livrarias
2. Navegue até a pasta do projeto:
   ```bash
   git clone https://github.com/mariaoliveira27/livrarias
3. Configure o banco de dados:
   - Certifique-se de que o banco SQLite está configurado corretamente.
   - Caso necessário, crie o banco de dados utilizando o arquivo `schema.sql`:
     ```bash
     sqlite3 database.db < schema.sql
     ```
4. Compile o projeto:
   ```bash
   ./mvnw clean install
5. Inicie a aplicação:
   ```bash
   ./mvnw spring-boot:run
6. Acesse a API:
   URL base: http://localhost:8181

### Com Docker:
1. Clone o repositório:
   
2. Construa e inicie o serviço utilizando o Docker Compose:
   ```bash
   docker-compose up --build

3. Acesse a API:
   URL base: http://localhost:8181
   
## 🧪 Testes
### Executar os testes unitários:
1. Sem Docker:
   ```bash
   ./mvnw test
2. Com Docker:
   ```bash
   docker run nome-da-imagem mvn test
   
## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🙌 Contribuições
Sinta-se à vontade para contribuir com este projeto. Para isso:

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature:
   ```bash
   git checkout -b minha-feature
3. Crie uma branch para a sua feature:
   ```bash
   git commit -m 'Minha nova feature'
4. Faça um push para a branch:
   ```bash
   git push origin minha-feature
5. Abra um Pull Request.

Feito por Maria Oliveira.
















   
 



