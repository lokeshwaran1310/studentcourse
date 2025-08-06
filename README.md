# Student Course Enrollment System

A Spring Boot application that manages Students, Courses, and Enrollments with a fully RESTful API using JPA and Hibernate.

---

## 📚 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Configuration](#-configuration)
- [Table Schema](#-table-schema)
- [API Endpoints](#-api-endpoints)
  - [Student](#-student)
  - [Course](#-course)
  - [Enrollment](#-enrollment)
- [Validation Logic](#-validation-logic)
- [Run the App](#-run-the-app)
- [Author](#-author)
- [License](#-license)

---

## 🚀 Features

- CRUD for Students, Courses, and Enrollments  
- Search by student email or course title  
- Fetch enrollments by date, student, or course  
- Count enrollments per course  
- Filter students/courses with more than 3 enrollments  

---

## 🛠️ Tech Stack

- Java 17+  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- Maven  
- Jackson (for JSON serialization)  

---

## 📁 Project Structure

```
student-course-enrollment/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── studentcourse/
│   │   │               ├── StudentCourseApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── StudentController.java
│   │   │               │   ├── CourseController.java
│   │   │               │   └── EnrollmentController.java
│   │   │               ├── domain/
│   │   │               │   ├── Student.java
│   │   │               │   ├── Course.java
│   │   │               │   └── Enrollment.java
│   │   │               ├── repository/
│   │   │               │   ├── StudentRepository.java
│   │   │               │   ├── CourseRepository.java
│   │   │               │   └── EnrollmentRepository.java
│   │   │               └── service/
│   │   │                   ├── StudentService.java
│   │   │                   ├── CourseService.java
│   │   │                   └── EnrollmentService.java
│   ├── resources/
│   │   ├── application.properties
│   │   └── static/
│   │       └── index.html
├── test/
│   └── com/
│       └── example/
│           └── studentcourse/
│               ├── StudentControllerTest.java
│               ├── CourseControllerTest.java
│               └── EnrollmentControllerTest.java
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8085
```

---

## 🗃️ Table Schema

### `students`

| Column | Type    | Description     |
|--------|---------|-----------------|
| id     | Long    | Primary Key     |
| name   | String  | Student name    |
| email  | String  | Student email   |

---

### `courses`

| Column      | Type    | Description     |
|-------------|---------|-----------------|
| id          | Long    | Primary Key     |
| title       | String  | Course title    |
| description | String  | Course overview |

---

### `enrollments`

| Column         | Type      | Description                        |
|----------------|-----------|------------------------------------|
| id             | Long      | Primary Key                        |
| enrollmentdate | LocalDate | Date of enrollment                 |
| student_id     | Long      | Foreign key referencing `students` |
| course_id      | Long      | Foreign key referencing `courses`  |

---

## 🔗 API Endpoints

### 👨‍🎓 Student

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/students` | Get all students |
| GET    | `/api/students/{id}` | Get student by ID |
| GET    | `/api/students/search/email?email=` | Search by email |
| POST   | `/api/students` | Create new student |
| PUT    | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

---

### 📘 Course

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/courses` | Get all courses |
| GET    | `/api/courses/{id}` | Get course by ID |
| GET    | `/api/courses/search/title?title=` | Search by title |
| GET    | `/api/courses/more-than-three-enrollments` | Courses with > 3 enrollments |
| POST   | `/api/courses` | Create course |
| PUT    | `/api/courses/{id}` | Update course |
| DELETE | `/api/courses/{id}` | Delete course |

---

### 📝 Enrollment

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/enrollments` | Get all enrollments |
| GET    | `/api/enrollments/{id}` | Get enrollment by ID |
| GET    | `/api/enrollments/student/{studentId}` | Enrollments by student |
| GET    | `/api/enrollments/course/{courseId}` | Enrollments by course |
| GET    | `/api/enrollments/same-date?date=yyyy-MM-dd` | Enrollments by date |
| GET    | `/api/enrollments/count/course/{courseId}` | Count enrollments |
| POST   | `/api/enrollments` | Create enrollment |
| PUT    | `/api/enrollments/{id}` | Update enrollment |
| DELETE | `/api/enrollments/{id}` | Delete enrollment |

---

## ✅ Validation Logic

- Validates null and empty fields  
- Ensures positive IDs  
- Returns:  
  - `200 OK` on success  
  - `400 Bad Request` for invalid input  
  - `404 Not Found` when data is missing  
  - `204 No Content` for delete success  

---

## 📦 Run the App

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/student-course-system.git
   ```
2. Open in your IDE (IntelliJ/Eclipse)  
3. Configure DB connection in `application.properties`  
4. Run the app using `StudentCourseApplication.java`  
5. Test endpoints using Postman or Swagger UI  

---

## 👤 Author

**Lokeshwaran M**

---

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
