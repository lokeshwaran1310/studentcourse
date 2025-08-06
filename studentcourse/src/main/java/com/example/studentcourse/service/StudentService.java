package com.example.studentcourse.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.studentcourse.domain.Student;

public interface StudentService {
    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);
    Student updateStudent(Long id, Student student);
    Student findByName(String name);
    Student findByEmail(String email);
    List<Student> getStudentsWithMoreThanThreeEnrollments();
 
}
