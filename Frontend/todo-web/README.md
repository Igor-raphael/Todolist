# Todo Web (Frontend)

Aplicação frontend de **Todo List** construída com **Angular 19**.  
Consome a API do backend (Spring Boot) para listar, criar, editar, deletar e marcar tarefas como concluídas.

---

## ✨ Funcionalidades

- Listagem de tarefas
- Criação de nova tarefa (modal)
- Edição de tarefa (modal preenchido com dados atuais)
- Exclusão por `id`
- Marcar/desmarcar como concluída (`realizado`)
- Indicador visual de **prioridade** (Baixa / Média / Alta)
- Loading com **Skeleton** quando a API estiver lenta

---

## 🧱 Tecnologias

- **Angular 19**
- **TypeScript**
- **RxJS**
- **Template-driven Forms** (`NgForm`)
- **HTTP Client**
- **SCSS**

---

## ✅ Pré-requisitos

- Node.js (recomendado LTS)
- Angular CLI
- Backend rodando localmente em `http://localhost:8080`

---

## ▶️ Como rodar o projeto

### 1) Instalar dependências

```bash
npm install
``` 

### 2) Rodar em desenvolvimento

```bash
ng serve -o
``` 

## 🔌 Integração com Backend (Proxy)

Para evitar problemas de CORS em desenvolvimento, use proxy.

### 1) **Crie o arquivo** proxy.config.json **(na raiz do projeto)**

```json
{
  "/todos": {
    "target": "http://localhost:8080",
    "secure": false,
    "changeOrigin": true,
    "logLevel": "debug"
  }
}

``` 

### 2) Suba o Angular com o proxy 

```bash
ng serve -o --proxy-config proxy.config.json
```

A partir disso, requisições como:

- GET /todos

- POST /todos/create

- PUT /todos/{id}

- PATCH /todos/{id}/realizado

- DELETE /todos/{id}

serão redirecionadas para o backend em ``` localhost:8080. ```

### 📡 Endpoints esperados (Backend)

- GET /todos → lista tarefas

- POST /todos/create → cria tarefa 

- PUT /todos/{id} → atualiza dados (nome/descrição/prioridade)

- PUT /todos/{id}/realizado → atualiza status { "realizado": true/false }

- DELETE /todos/{id} → remove tarefa

## 🗂️ Estrutura (resumo)

- ```src/app/services/``` → serviços HTTP (list/create/update/delete)

- ```src/app/model/``` → interfaces/DTOs (ex.: Todo, TodoCreateDTO)

- ```src/app/components/``` → componentes (Home, Modal, etc.)

- ```src/environments/``` → configuração de URLs e comportamentos por ambiente.


## 📌 Observações

- O ```id``` é gerado pelo backend/banco.

- O frontend envia DTOs sem ```id``` para criação.

- Para update parcial, o status ```realizado``` é tratado em rota separada.

## 📷 Preview

### Tela principal
  ![Home] (public/assets/previews/Home.png)

### Criar tarefas
  ![Modal-Create] (public/assets/previews/create.png)

### Lista de tarefas
  ![Lista] (public/assets/previews/list.png)

  ### Alterar tarefas
  ![Modal-Update] (public/assets/previews/update.png)

  ### Expansão de conteúdo
  ![Lista-Expandida] (public/assets/previews/list02.png)

## 👤 Autor

 **Igor Rafael**
