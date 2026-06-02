# 📝 Todo CRUD Application

A full-stack Todo Management Application built using Spring Boot, Spring Security, MySQL, HTML, CSS, and JavaScript.

## 🚀 Features

- User Registration (Signup)
- User Login Authentication
- Secure Password Encryption using BCrypt
- Create Todo
- View Todos
- Update Todo
- Delete Todo
- User-specific Todo Management
- Responsive UI
- REST API Integration

## 🛠️ Technologies Used

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Frontend
- HTML
- CSS
- JavaScript

### Database
- MySQL

## 📂 Project Structure

```text
src
├── controller
│   ├── AuthController
│   └── TodoController
├── entity
│   ├── AppUser
│   └── Todo
├── repo
│   ├── UserRepository
│   └── TodoRepository
├── service
│   ├── CustomUserDetailsService
│   └── TodoService
├── securityConfig
│   └── SecurityConfig
└── CrudOperationApplication
```

## 🔐 Authentication Flow

1. User signs up with username and password.
2. Password is encrypted using BCrypt.
3. User logs in through Spring Security.
4. Authenticated users can manage only their own todos.

## 📋 CRUD Operations

### Create Todo
- Add a new task.

### Read Todo
- View all personal tasks.

### Update Todo
- Modify an existing task.

### Delete Todo
- Remove a task permanently.

## 🗄️ Database Tables

### users

| Column | Type |
|----------|----------|
| id | BIGINT |
| username | VARCHAR |
| password | VARCHAR |

### todo

| Column | Type |
|----------|----------|
| id | INT |
| content | VARCHAR |
| user_id | BIGINT |

## ⚙️ How to Run

### 1. Clone Repository

```bash
git clone https://github.com/AnshuJariya/employee-leave-management-system.git
```

### 2. Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crudOperation
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run Application

```bash
mvn spring-boot:run
```

### 4. Open Browser

```text
http://localhost:8080
```

## 📸 Screenshots

Add screenshots here after uploading images.

```md
![Login Page](screenshots/login.png)
![Todo Dashboard](screenshots/dashboard.png)
```

## 🎯 Learning Outcomes

Through this project I learned:

- Spring Boot fundamentals
- REST API development
- Spring Security authentication
- BCrypt password encryption
- MySQL integration with JPA
- Frontend and backend integration
- CRUD operations implementation
- User-specific data handling

## 👨‍💻 Author

Anshu Jariya

GitHub: https://github.com/AnshuJariya
