package com.example.learningplatform.controllers;

import com.example.learningplatform.entities.Course;
import com.example.learningplatform.entities.CourseDTO;
import com.example.learningplatform.entities.Student;
import com.example.learningplatform.entities.UserDTO;
import com.example.learningplatform.services.CourseService;
import com.example.learningplatform.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/details")
    public ResponseEntity<UserDTO> getStudentDetails(@RequestParam int id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            UserDTO userDTO = student.studentToDTO(); // Ensure `studentToDTO` is a method that converts Student to UserDTO
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/enrolled-courses")
    public ResponseEntity<List<CourseDTO>> getEnrolledCourses(@RequestParam int studentId) {
        List<CourseDTO> courses =new ArrayList<>();
        for(Course i : studentService.getCoursesForStudent(studentId))
            courses.add(i.courseToDTO());
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/browse")
    public ResponseEntity<List<CourseDTO>> browseCourses() {
        List<CourseDTO> courses =new ArrayList<>();
        for(Course i : courseService.getCourses())
            courses.add(i.courseToDTO());

        return ResponseEntity.ok(courses);
    }

    @PostMapping("/enroll")
    public ResponseEntity<Void> enrollInCourse(@RequestParam int studentId, @RequestParam int courseId) {
        studentService.enrollInCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/progress")
    public ResponseEntity<Double> getProgress(@RequestParam int studentId, @RequestParam int courseId) {
        double progress = studentService.getProgressForCourse(studentId, courseId);
        return ResponseEntity.ok(progress);
    }

    @PostMapping("/update-progress")
    public ResponseEntity<Void> updateProgress(@RequestParam int studentId, @RequestParam int courseId, @RequestParam double progress) {
        studentService.updateProgressForCourse(studentId, courseId, progress);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-review")
    public ResponseEntity<Void> addReview(@RequestParam int studentId, @RequestParam int courseId, @RequestParam String review) {
        studentService.addReviewForCourse(studentId, courseId, review);
        return ResponseEntity.ok().build();
    }
}
