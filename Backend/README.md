<h1 align="center">
  TODO List API
</h1>

API REST para gerenciamento de tarefas (CRUD), permitindo criar, listar, atualizar, marcar como concluída e remover tarefas.

---

## 📌 Visão Geral

Esta API foi desenvolvida com foco em boas práticas de arquitetura, código limpo e padronização REST.  
Ela serve como backend para aplicações de gerenciamento de tarefas, podendo ser facilmente integrada a um frontend (Angular, React, etc).

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3 (Swagger)
- PostgreSQL
- Maven

---

## 📐 Práticas Adotadas

- SOLID
- DRY, YAGNI, KISS
- API RESTful
- Injeção de Dependências
- Validação de dados
- Tratamento global de exceções
- Documentação automática com Swagger (OpenAPI 3)
- Camadas bem definidas (Controller, Service, Repository)

---

## ▶️ Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL

### Passos

1. Clonar o repositório
```bash
git clone <url-do-repositorio>
```

2. Configurar o banco de dados no ```application.properties``` ou ```application.yml```

3. Construir o projeto
```bash
./mvnw clean package
```

4. Executar a aplicação
```bash
java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

## 🌐 Acesso à Aplicação

- API:
👉 http://localhost:8080

- Swagger (Documentação):
👉 http://localhost:8080/swagger-ui.html


## 📡 Endpoints da API

Base URL:
```bash
http://localhost:8080/todos
```


🔹 **Listar todas as tarefas**
```bash
  GET /todos
```

**Resposta**
```json
[
  {
    "id": 1,
    "nome": "Estudar Spring",
    "descricao": "Estudar JPA e Hibernate",
    "prioridade": 1,
    "realizado": false
  }
]
```


🔹 **Criar tarefas**
```bash
 POST /todos/create
```
**Body(json)**
```json
{
  "nome": "Estudar Java",
  "descricao": "Revisar Streams API",
  "prioridade": 1
}
```

🔹 **Atualizar uma tarefa**
```bash
PUT /todos/{id}
```
**Exemplo**

```bash
PUT /todos/1
```

**Body (json)**
```json
{
  "nome": "Estudar Java Avançado",
  "descricao": "Streams, Lambdas e Optional",
  "prioridade": 2
}
```

🔹 **Marcar tarefa como realizada ou não**
```bash
 PATH /todos/{id}/{realizado}
```

**Exemplos**

```bash
PATCH /todos/1/true
```

```bash
PATCH /todos/1/false
```


🔹 **Remover uma tarefa**
```bash
DELETE /todos/{id}
```

**Exemplo**
```bash
DELETE /todos/1
```
