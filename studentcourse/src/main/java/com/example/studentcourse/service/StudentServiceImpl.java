package com.example.studentcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.domain.Student;
import com.example.studentcourse.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentrepository;
    @Override
    public Student findById(Long id){
        return studentrepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll(){
        return studentrepository.findAll();

    }

    @Override
    public Student save(Student student){
        return studentrepository.save(student);
    }

    @Override
    public void deleteById(Long id){
        studentrepository.deleteById(id);
    }

    @Override
    public Student findByName(String name){
        return studentrepository.findByName(name);
    }

    @Override
    public Student updateStudent(Long id, Student student){
        Student existingStudent = findById(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setEnrollments(student.getEnrollments());
            return studentrepository.save(existingStudent);
        }
        return null;


    }

    @Override
    public Student findByEmail(String email){
        return studentrepository.findByEmail(email);

    }

    @Override
    public List<Student> getStudentsWithMoreThanThreeEnrollments() {
        return studentrepository.getStudentsWithMoreThanThreeEnrollments();
    }
    


    
}
