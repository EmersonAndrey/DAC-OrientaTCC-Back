# 🎓 OrientaTCC Backend — Spring Boot + Java + PostgreSQL  

## 📝 Descrição do Projeto  

O **OrientaTCC Backend** é o microserviço responsável por toda a **lógica de negócio e persistência de dados** do sistema **OrientaTCC**, que auxilia alunos, orientadores e administradores na gestão de Trabalhos de Conclusão de Curso (TCC).  

Foi desenvolvido em **Spring Boot** seguindo arquitetura em camadas, expondo endpoints REST que são consumidos pelo **OrientaTCC Frontend**.  

---

## 📂 Estrutura do Projeto  

O projeto segue boas práticas de organização: 

```shell
OrientaTCC-Back/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/orientatcc/
│ │ │ ├── config/ # Configurações gerais (Segurança, CORS etc.)
│ │ │ ├── controller/ # Controladores REST (endpoints da API)
│ │ │ ├── dto/ # Data Transfer Objects (Request e Response)
│ │ │ ├── exception/ # Exceções customizadas e handlers globais
│ │ │ ├── model/ # Entidades do domínio (Usuario, TrabalhoAcademicoTCC, Atividade etc.)
│ │ │ ├── repository/ # Interfaces de persistência (Spring Data JPA)
│ │ │ ├── service/ # Camada de regra de negócio
│ │ │ ├── jwt/ # Implementação de autenticação/autorização (JWT, filtros, configs)
| | | ├── mapper/ # Classes de mapeamento
| | | ├── enums/ # Constantes Globais (roles, status ect.)
│ │ │ └── util/ # Classes utilitárias e helpers
│ │ └── resources/
│ │ ├── application.properties # Configurações da aplicação
│ │ └── application-dev.yml # Configurações específicas para ambiente de dev
│ └── test/
│ └── java/
│ └── com/orientatcc/ # Testes unitários e de integração
├── pom.xml # Configuração do Maven
└── README.md # Documentação do projeto
```

---

## ✨ Funcionalidades

- [x] Cadastro, autenticação e autorização de usuários (Aluno, Orientador, Coordenador)  
- [x] Criação, listagem, atualização e exclusão de **TCCs**  
- [x] Cadastro e gerenciamento de **atividades e PDFs**  
- [x] Relacionamento entre entidades:  
  - Orientador ↔ TCC  
  - TCC ↔ Aluno  
- [x] Persistência no banco de dados **MySQL**  
- [x] Segurança com **Spring Security + JWT**
      
---

## 🛠️ Tecnologias Utilizadas  

- **Linguagem:** Java 17  
- **Framework:** Spring Boot 3
- **Segurança:** Spring Security + JWT  
- **Banco de Dados:** MySQL  
- **Persistência:** Spring Data JPA / Hibernate  
- **Comunicação:** REST API  
- **Build:** Maven  

---
      
## 🚀 Como Rodar o Projeto  

### 🔧 Pré-requisitos  
- JDK 17+  
- Maven 3.9+  
- MySQL instalado e rodando
  
### ▶️ Passo a Passo  

```bash
# Clone o repositório
git clone https://github.com/EmersonAndrey/DAC-OrientaTCC-Back.git

# Acesse a pasta do backend
cd DAC-OrientaTCC-Back

# Configure o banco de dados no arquivo application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/orienta_tcc
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Rode a aplicação
mvn spring-boot:run
```
A aplicação ficará disponível em:
👉 http://localhost:8080

---

## 🔗 Endpoints Principais

| Método | Endpoint                        | Descrição                  |
|--------|---------------------------------|----------------------------|
| POST   | `/api/v1/auth`                  | Autenticação e geração de JWT    |
| GET    | `/api/v1/usuarios`              | Listar todos os usuários      |
| POST   | `/api/v1/tcc`                   | Criar novo Trabalho de Conclusão    |
| GET    | `/api/v1/tcc/{id}`              | Consultar TCC por ID  |
| POST   | `/api/v1/atividades`            | Registrar nova atividade  |
| GET    | `/api/v1/atividades/{id}/pdfs`  | Listar PDFs vinculados a uma atividade |

---

## 👨‍💻 Desenvolvedores
- [Ana Maria Alves Felix](https://github.com/anaMariaFelix)
- [Emerson Andrey Fausto dos Santos](https://github.com/EmersonAndrey)
- [Ismael Morais Ribeiro](https://github.com/IsmaelMoraisRibeiro20)
