package com.example.studentcourse.controller;

import com.example.studentcourse.domain.Course;
import com.example.studentcourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Course course = courseService.findById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        if (course == null ||
            course.getTitle() == null || course.getTitle().trim().isEmpty() ||
            course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Title and description must not be empty.");
        }

        return ResponseEntity.ok(courseService.save(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        if (id == null || id <= 0 ||
            course == null ||
            course.getTitle() == null || course.getTitle().trim().isEmpty() ||
            course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid ID or missing fields.");
        }

        Course updated = courseService.updateCourse(id, course);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public ResponseEntity<Course> getByTitle(@RequestParam String title) {
        if (title == null || title.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Course course = courseService.findByTitle(title);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @GetMapping("/more-than-three-enrollments")
    public List<Course> getCoursesWithMoreThanThreeEnrollments() {
        return courseService.findCoursesWithMoreThanThreeEnrollments();
    }
}
