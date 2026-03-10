# 🦸 ZG Hero Todo List

**Autor:** Nathan Teixeira de Oliveira

Aplicação desenvolvida em **Java** para gerenciamento de tarefas, permitindo organizar, listar, atualizar e remover tarefas de forma simples e intuitiva.

O projeto possui:

* 🖥️ **Backend em Java (CLI)**
* 🌐 **Frontend simples em HTML, CSS e JavaScript**

---

# 📋 Funcionalidades

* Adicionar novas tarefas com:

    * Nome
    * Descrição
    * Prazo (em dias)
    * Prioridade (1 a 5)
    * Categoria
    * Status (TODO, DOING, DONE)

* Listar tarefas:

    * Por prioridade
    * Por categoria
    * Por status
    * Listagem geral de todas as tarefas

* Remover tarefas pelo índice

* Atualizar status de tarefas

---

# ⚙️ Tecnologias Utilizadas

### Backend

* Java 8+
* Estruturas de dados (`List`)

### Frontend

* HTML5
* CSS3
* JavaScript

### Bibliotecas Java

* `java.time.LocalDate` → controle de datas
* `java.util.Scanner` → entrada de dados do usuário
* `java.util.Locale` → suporte a internacionalização

---

# 🖥️ Interface (CLI)

Ao iniciar o programa, o usuário verá um menu interativo no terminal:

```
--- ZG HERO TODO LIST ---

1. Adicionar Tarefa
2. Listar por Prioridade
3. Listar por Categoria
4. Listar por Status
5. Listagem geral
6. Remover Tarefa
7. Atualizar Status
0. Sair
```

---

# 🧩 Estrutura do Projeto

```
project_k1-t1/
│
├── frontend/
│   ├── css/
│   │   └── style.css
│   │
│   ├── js/
│   │   └── app.js
│   │
│   └── index.html
│
├── src/
│   ├── aplication/
│   │   └── Main.java
│   │
│   ├── entity/
│   │   └── Task.java
│   │
│   └── service/
│       └── ServiceTasks.java
│
├── out/
│   └── production/
│       └── project_k1-t3/
│           ├── aplication/
│           ├── entity/
│           └── service/
│
├── .gitignore
├── project_k1-t3.iml
└── README.md
```

---

# ▶️ Como Executar o Projeto

### 1️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2️⃣ Abrir no IntelliJ IDEA

Abra a pasta do projeto no IntelliJ.

### 3️⃣ Executar o programa

Execute a classe:

```
src/aplication/Main.java
```

### 4️⃣ Utilizar o menu interativo

O sistema será exibido no terminal permitindo gerenciar as tarefas.

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para praticar conceitos fundamentais de desenvolvimento de software:

* Programação Orientada a Objetos (POO)
* Organização de projetos em camadas
* Manipulação de listas
* Entrada e saída de dados no terminal
* Integração com uma interface web simples

---

# 🚀 Possíveis Melhorias Futuras

* Persistência de dados (arquivo ou banco de dados)
* API REST com Spring Boot
* Integração completa entre backend e frontend
* Interface gráfica mais avançada
* Sistema de autenticação de usuários

---

# 📄 Licença

Projeto desenvolvido para fins educacionais.
