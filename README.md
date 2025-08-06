# Student Course Enrollment System

This is a Spring Boot application for managing Students, Courses, and Enrollments in a simple educational system. It provides a RESTful API to perform CRUD operations and custom queries for each entity.

---

## 🚀 Features

- Student CRUD (Create, Read, Update, Delete)
- Course CRUD
- Enrollment CRUD
- Search by:
  - Student email
  - Course title
- Additional queries:
  - Enrollments on a specific date
  - Students or courses with more than 3 enrollments
  - Count enrollments for a course
  - Get enrollments by student or course

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL (or any JPA-compatible DB)
- Maven
- Jackson

---

## 📁 Project Structure

```
src/main/java
└── com.example.studentcourse
    ├── controller
    │   ├── StudentController.java
    │   ├── CourseController.java
    │   └── EnrollmentController.java
    ├── domain
    │   ├── Student.java
    │   ├── Course.java
    │   └── Enrollment.java
    ├── repository
    │   ├── StudentRepository.java
    │   ├── CourseRepository.java
    │   └── EnrollmentRepository.java
    └── service
        ├── StudentService.java / Impl
        ├── CourseService.java / Impl
        └── EnrollmentService.java / Impl
```

---

## ⚙️ Configuration

Set your `application.properties` like:

```properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=

# JPA and Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Port
server.port=8085
```

---

## 🔗 API Endpoints

### 👨‍🎓 Student
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/students` | Get all students |
| GET    | `/api/students/{id}` | Get student by ID |
| GET    | `/api/students/search/email?email=` | Search student by email |
| POST   | `/api/students` | Create new student |
| PUT    | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

---

### 📘 Course
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/courses` | Get all courses |
| GET    | `/api/courses/{id}` | Get course by ID |
| GET    | `/api/courses/search/title?title=` | Search course by title |
| GET    | `/api/courses/more-than-three-enrollments` | Courses with > 3 enrollments |
| POST   | `/api/courses` | Create new course |
| PUT    | `/api/courses/{id}` | Update course |
| DELETE | `/api/courses/{id}` | Delete course |

---

### 📝 Enrollment
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/enrollments` | Get all enrollments |
| GET    | `/api/enrollments/{id}` | Get enrollment by ID |
| GET    | `/api/enrollments/student/{studentId}` | Enrollments for a student |
| GET    | `/api/enrollments/course/{courseId}` | Enrollments for a course |
| GET    | `/api/enrollments/same-date?date=yyyy-MM-dd` | Enrollments on given date |
| GET    | `/api/enrollments/count/course/{courseId}` | Count enrollments per course |
| POST   | `/api/enrollments` | Create new enrollment |
| PUT    | `/api/enrollments/{id}` | Update enrollment |
| DELETE | `/api/enrollments/{id}` | Delete enrollment |

---

## ✅ Validation Logic

- Null/empty check for all required fields
- Proper ID validations
- Returns status codes: 200 OK, 400 Bad Request, 404 Not Found, 204 No Content

---

## 📦 Run the App

1. Clone the project:
   ```bash
   git clone https://github.com/your-username/student-course-system.git
   ```
2. Open in your IDE (IntelliJ, Eclipse)
3. Set up PostgreSQL database
4. Run the Spring Boot app from `StudentCourseApplication.java`
5. Use Postman or Swagger UI to test the APIs

---

## 👤 Author

**Lokeshwaran M**

---

## 📜 License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).
