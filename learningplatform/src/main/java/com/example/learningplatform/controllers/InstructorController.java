package com.example.learningplatform.controllers;

import com.example.learningplatform.entities.*;
import com.example.learningplatform.services.CourseService;
import com.example.learningplatform.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;
    @GetMapping("/details")
    public ResponseEntity<UserDTO> getInstructorDetails(@RequestParam int id) {
        Optional<Instructor> instructorOptional = instructorService.getInstructorById(id);
        if (instructorOptional.isPresent()) {
            Instructor instructor = instructorOptional.get();
            UserDTO userDTO = instructor.userToDTO();
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add-course")
    public ResponseEntity<Void> addCourse(@Valid @RequestBody CourseDTO courseDTO, @RequestParam int instructorId) {
        PendingCourse pendingCourse=courseDTO.toCourse();
        instructorService.sendCourseRequest(pendingCourse,instructorId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete-course")
    public ResponseEntity<Void> deleteCourse(@RequestParam int instructorId,@RequestParam int courseId) {
        instructorService.deleteCourse(instructorId,courseId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/show-courses")
    public ResponseEntity<List<CourseDTO>> showCourses(@RequestParam int instructorId) {
        List<CourseDTO> courses =new ArrayList<>();
        for(Course i : instructorService.getCourses(instructorId))
            courses.add(i.courseToDTO());
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/show-enrollments")  // returns list of students enrolled in the course
    public ResponseEntity<List<UserDTO>> showEnrollmentsForCourse(@RequestParam int courseId) {
        List<UserDTO> enrollments =new ArrayList<>();
        for(Student i :courseService.getCourseStudents(courseId)){
            enrollments.add(i.userToDTO());
        }
        return ResponseEntity.ok(enrollments);
    }
    @GetMapping("/show-reviews")
    public ResponseEntity<List<String>> showReviewsForCourse(@RequestParam int courseId) {
        return ResponseEntity.ok(instructorService.getReviews(courseId));
    }
}
