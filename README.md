## README.md — Agenda Médica 🩺📅

# 🩺 Agenda Médica

Sistema de agendamento médico desenvolvido em **Java 17** com **Spring Boot**, usando **PostgreSQL** como banco de dados, containerizado com **Docker** e orquestrado com **Docker Compose**.

---

## 🚀 Tecnologias Utilizadas

- ☕ Java 17 (OpenJDK)
- 🌱 Spring Boot
- 🐘 PostgreSQL 15
- 🐳 Docker & Docker Compose
- 📦 Maven

---

## 📂 Estrutura do Projeto
```
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── src/
├── main/
│ ├── java/
│ │ └── com/exemplo/agenda/
│ │ ├── AgendaMedicaApplication.java
│ │ ├── controller/
│ │ │ ├── ConsultaController.java
│ │ │ └── PacienteController.java
│ │ ├── model/
│ │ │ ├── Consulta.java
│ │ │ ├── Paciente.java
│ │ │ └── TipoServico.java
│ │ ├── repository/
│ │ │ ├── ConsultaRepository.java
│ │ │ ├── PacienteRepository.java
│ │ │ └── TipoServicoRepository.java
│ │ └── service/
│ │ ├── ConsultaService.java
│ │ └── PacienteService.java
│ └── resources/
│ ├── application.properties
│ └── data.sql
└── test/
└── java/
```
---

## 🧩 Descrição das Camadas

| Camada      | Responsabilidade                                      |
| ----------- | ---------------------------------------------------- |
| **Controller** | Endpoints REST para gerenciamento de consultas e pacientes |
| **Service**    | Lógica de negócio                                    |
| **Repository** | Acesso ao banco via Spring Data JPA                 |
| **Model**      | Entidades que representam tabelas no banco          |
| **Resources**  | Configurações e scripts SQL (ex: `data.sql`)         |

---

## 🗄️ Banco de Dados

- **Banco:** `agenda_db`  
- **Usuário:** `malobo`  
- **Senha:** `233234`  
- **Porta:** `5432` (mapeada no Docker Compose)

A conexão é configurada via variáveis de ambiente no `docker-compose.yaml` e utilizadas no `application.properties`:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```
▶️ Como Rodar o Projeto
Gerar o JAR (caso tenha feito mudanças no código):
```
./mvnw clean package -DskipTests
```
Subir os containers (aplicação + banco):

```bash
docker-compose up --build
```
Acessar a aplicação:

Abra no navegador:

```arduino
http://localhost:8080
```
🛠️ Comandos Úteis
Parar todos os containers:

```bash
docker-compose down
```
Ver logs da aplicação:

```bash
docker logs -f agenda_app
```
## 🎯 Próximos Passos
# Criar testes automatizados (unitários e integração)

- Implementar autenticação e autorização

- Publicar código no GitHub e imagens no Docker Hub

- Documentar endpoints com Swagger ou similar

👤 Autor
Marco Lobo

📄 Licença
MIT License