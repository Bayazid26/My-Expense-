# My-Expense-
Personal Expense Tracker

A simple Spring Boot project using Spring Data JPA.

---

## 🚀 Technologies Used

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 / MySQL (configure as needed)  
- Maven  

---


## ✨ Features

- Add, update, delete, and fetch expenses
- Category-wise expense summaries
- Clean code architecture using DTO, Service, and Repository layers
- Easily extendable structure

## 🔧 Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/My-Expense.git
   cd My-Expense


## 📂 Project Structure


My-Expense/
├── .idea/
├── .mvn/
├── src/
│ └── main/
│ ├── java/
│ │ └── com.example.My_Expense/
│ │ ├── controller/
│ │ │ └── ExpenseController.java
│ │ ├── dto/
│ │ │ └── CategorySummary.java
│ │ ├── model/
│ │ │ └── Expense.java
│ │ ├── repository/
│ │ │ └── ExpenseRepository.java
│ │ ├── service/
│ │ │ └── ExpenseService.java
│ │ └── MyExpenseApplication.java
│ └── resources/
│ ├── static/
│ ├── templates/
│ └── application.properties


   Endpoint for H2 Database: http://localhost:8080/h2-console/
   sample json data:
    [
  {
    "amount": 100,
    "category": "Food",
    "date": "2025-05-13",
    "description": "Snacks"
  },
  {
    "amount": 800,
    "category": "Travel",
    "date": "2025-05-12",
    "description": "Taxi fare"
  }
]
