package com.example.studentcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcourse.domain.Course;
import com.example.studentcourse.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = findById(id);
        if (existingCourse != null) {
            existingCourse.setTitle(course.getTitle());
            existingCourse.setEnrollments(course.getEnrollments());
            return courseRepository.save(existingCourse);
        }
        return null;
    }
    @Override
    public Course findByTitle(String title){
        return courseRepository.findByTitle(title);
    }
    @Override
    public List<Course> findCoursesWithMoreThanThreeEnrollments() {
        return courseRepository.findCoursesWithMoreThanThreeEnrollments();
    }




}
