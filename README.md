# 📚 Bookstore REST API

A secure, RESTful Bookstore API built with **Spring Boot** and **MongoDB**, implementing **JWT authentication**, full **CRUD operations**, **filtering**, **search**, and **pagination**.

---

## 🚀 Features

### 🔐 User Authentication (JWT-based)
- Signup with email & password
- Login to receive JWT token
- Protected endpoints using JWT

### 📘 Books API
- Create a new book
- Get all books (with pagination & sorting)
- Get book by ID
- Update book by ID
- Delete book by ID

### 🔍 Filtering & Search
- Filter books by author, category, rating
- Search books by partial title match



### 🛡️ Error Handling
- Clean error responses with HTTP status codes
- Input validation for required fields

---

## 🛠️ Tech Stack

| Layer         | Technology        |
|--------------|-------------------|
| Backend       | Spring Boot       |
| Database      | MongoDB (NoSQL)   |
| Security      | Spring Security + JWT |
| Build Tool    | Maven             |

---

## 📦 API Endpoints

### 🧑 Auth Endpoints

| Method | Endpoint         | Description       |
|--------|------------------|-------------------|
| POST   | `/api/auth/signup` | Register new user |
| POST   | `/api/auth/login`  | Login user & get JWT |

### 📚 Book Endpoints (Protected)

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/api/books`       | Get all books (with pagination/sorting) |
| GET    | `/api/books/{id}`  | Get book by ID           |
| POST   | `/api/books`       | Create new book          |
| PUT    | `/api/books/{id}`  | Update book by ID        |
| DELETE | `/api/books/{id}`  | Delete book by ID        |

> 📌 Requires `Authorization: Bearer <token>` header for all book endpoints

---

## 🧪 Example Usage

### 📝 Register User
```http
POST /api/auth/signup
Content-Type: application/json

{
"email": "user@example.com",
"password": "password123"
}

```
LOGIN AND GET TOKEN
```

POST /api/auth/login
Content-Type: application/json

{
  "name": "user"
  "email": "user@example.com",
  "password": "password123"
}

```
Create Book (Requires JWT)
````
POST /api/books
Authorization: Bearer <JWT>
Content-Type: application/json

{
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "category": "Fiction",
  "price": 15.99,
  "rating": 4.5,
  "publishedDate": "1988-05-01"
}

````
📁 Project Structure
````
src/
├── controller/
├── model/
├── repository/
├── security/
├── service/
└── BookstoreApplication.java

````
🧰 Setup Instructions
1. Clone the project:

````
git clone https://github.com/yourusername/bookstore-api.git
cd bookstore-api

````
2. Configure MongoDB:

- Make sure MongoDB is running locally (default port 27017)

- Configure connection in application.properties

3. Run the App:
````
mvn spring-boot:run
````
Test endpoints with Postman
````

````
📌 Environment Variables

You can define these in application.properties:
````
spring.data.mongodb.uri=mongodb://localhost:27017/bookstore
server.port=8080

````
✍️ Author

SHREYASH KASHYAP

Java Backend Developer | Spring Boot Enthusiast
````
