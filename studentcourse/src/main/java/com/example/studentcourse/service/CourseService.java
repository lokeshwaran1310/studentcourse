package com.example.studentcourse.service;

import java.util.List;

import com.example.studentcourse.domain.Course;

public interface CourseService {
    Course findById(Long id);
    List<Course> findAll();
    Course save(Course course);
    void deleteById(Long id);
    Course updateCourse(Long id, Course course);
    List<Course> findCoursesWithMoreThanThreeEnrollments();
    Course findByTitle(String title);
    
}
