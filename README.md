# 🏦 BankApp - Sistema Bancário em Spring Boot

Sistema simples de banco, desenvolvido em **Java** com **Spring Boot**, **H2 Database** e **Spring Data JPA**.  
Permite criar contas, realizar depósitos, saques e visualizar transações de forma prática e rápida.

---

## 💻 Tecnologias usadas
- Java 17
- Spring Boot 3.3
- Spring Data JPA
- H2 Database (em memória)
- Maven
- PowerShell / Postman para testes

---

## 🗂 Estrutura do projeto


- **Controller:** define os endpoints REST  
- **Service:** regras de negócio (deposito, saque, consultas)  
- **Model:** entidades Account e Transaction  
- **Repository:** interfaces JPA para persistência

---

## ⚡ Endpoints disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST   | /api/accounts | Criar nova conta |
| GET    | /api/accounts | Listar todas as contas |
| POST   | /api/accounts/{id}/deposit?amount=x | Depositar valor |
| POST   | /api/accounts/{id}/withdraw?amount=x | Sacar valor |
| GET    | /api/accounts/{id}/transactions | Listar transações |

---

## 📌 Exemplos de requisições no PowerShell

# Criar conta:

 - curl -Method Post -Uri http://localhost:8080/api/accounts -ContentType "application/json" -Body '{"owner":"Gabriel","balance":0}'


# Listar contas:

 - curl -Method Get -Uri http://localhost:8080/api/accounts


# Depositar 500:

 - curl -Method Post -Uri "http://localhost:8080/api/accounts/1/deposit?amount=500"


# Sacar 200:

 - curl -Method Post -Uri "http://localhost:8080/api/accounts/1/withdraw?amount=200"


# Ver transações:

 - curl -Method Get -Uri "http://localhost:8080/api/accounts/1/transactions"


## 💡 Substitua 1 pelo ID da conta que deseja manipular.


## 📌 Observações

Projeto simples, feito para fins de aprendizado.

Código limpo e comentado para facilitar entendimento.

Pode ser expandido para incluir autenticação, múltiplos usuários, histórico detalhado e frontend
