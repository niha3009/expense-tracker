# Expense Tracker (Core Java)

A console-based Expense Tracker application developed using **Core Java**, **JDBC**, **MySQL**, and **Maven**.  
This project allows users to manage daily expenses with persistent database storage.

---

## Project Overview

The Expense Tracker helps users record and manage expenses such as food, travel, shopping, etc.  
All expense data is stored in a MySQL database using JDBC for connectivity.

This project is built **without any frameworks** (no Spring / Spring Boot) to demonstrate strong fundamentals in Core Java and SQL.

---

##  Features

- Add a new expense
- View all expenses
- Delete an expense by ID
- Menu-driven console interface
- Persistent storage using MySQL database
- Clean and modular project structure

---

## Technologies Used

- **Java (Core Java)**
- **JDBC**
- **MySQL**
- **SQL**
- **Maven**
- **Git & GitHub**

---

## Project Structure
expense-tracker
├── pom.xml
├── .gitignore
└── src
└── main
└── java
└── com
└── example
├── DBConnection.java
├── Expense.java
├── ExpenseDAO.java
└── Main.java

---

##  Database Setup
sql

CREATE DATABASE expense_tracker;
USE expense_tracker;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    amount DOUBLE,
    category VARCHAR(50),
    expense_date DATE
);

