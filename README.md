----ZG HERO TODO LIST----

Autor: Nathan Teixeira de Oliveira

Um aplicativo de linha de comando em Java para gerenciamento de tarefas, permitindo organizar, listar, atualizar e remover tarefas de forma simples e intuitiva.

📋 Funcionalidades

Adicionar novas tarefas com:

Nome

Descrição

Prazo (em dias)

Prioridade (1 a 5)

Categoria

Status (TODO, DOING, DONE)

Listar tarefas:

Por prioridade

Por categoria

Por status

Listagem geral de todas as tarefas

Remover tarefas pelo índice

Atualizar status de tarefas

⚙️ Tecnologias

Java 8+

Estruturas de dados simples (listas)

Pacotes:

java.time.LocalDate → para controle de datas

java.util.Scanner → para entrada do usuário

java.util.Locale → para suporte a internacionalização

🖥️ Interface

Ao iniciar, o usuário verá um menu interativo:

--- ZG HERO TODO LIST ---
Opção: 
1. Adicionar Tarefa
2. Listar por Prioridade
3. Listar por Categoria
4. Listar por Status
5. Listagem geral
6. Remover Tarefa
7. Atualizar Status
0. Sair



```text🧩 Estrutura do Projeto
ZGHeroTodoList/
│
├── src/
│   ├── aplication/
│   │   └── Main.java
│   ├── entity/
│   │   └── Task.java
│   └── service/
│       └── ServiceTasks.java
│
├── bin/  (compilação)
└── README.md

