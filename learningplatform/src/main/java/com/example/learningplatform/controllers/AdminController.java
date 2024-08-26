package com.example.learningplatform.controllers;

import com.example.learningplatform.entities.*;
import com.example.learningplatform.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private PendingCourseService pendingCourseService;
    @GetMapping("/details")
    public ResponseEntity<UserDTO> getAdminDetails(@RequestParam int id) {
        Optional<Admin> adminOptional = adminService.getAdminById(id);
            Admin admin = adminOptional.get();
            UserDTO userDTO = admin.userToDTO(); // Convert Admin to UserDTO
            return ResponseEntity.ok(userDTO);
        }
    @GetMapping("/show-students")
    public ResponseEntity<List<UserDTO>> getStudents() {
        List<UserDTO> students=new ArrayList<>();
        for(Student i :studentService.getStudents() )
               students.add(i.userToDTO());
        return ResponseEntity.ok(students);
    }
    @GetMapping("/show-instructors")
    public ResponseEntity<List<UserDTO>> getInstructors() {
        List<UserDTO> instructors=new ArrayList<>();
        for(Instructor i :instructorService.getInstructors() )
            instructors.add(i.userToDTO());
        return ResponseEntity.ok(instructors);
    }
    @GetMapping("/show-courses")
    public ResponseEntity<List<CourseDTO>> getCourses() {
        List<CourseDTO> courses=new ArrayList<>();
        for(Course i :courseService.getCourses())
            courses.add(i.courseToDTO());
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/show-pending-courses")
    public ResponseEntity<List<CourseDTO>> getPendingCourses() {
        List<CourseDTO> courses=new ArrayList<>();
        for(PendingCourse i :pendingCourseService.getPendingCourses())
            courses.add(i.pendingCourseToDTO());
        return ResponseEntity.ok(courses);
    }
    @GetMapping("/show-reviews")
    public ResponseEntity<List<String>> showReviewsForCourse(@RequestParam int courseId) {
        return ResponseEntity.ok(instructorService.getReviews(courseId));
    }

    @GetMapping("/show-admins")
    public ResponseEntity<List<UserDTO>> getAdmins() {
        List<UserDTO> admins=new ArrayList<>();
        for(Admin i :adminService.getAdmins() )
            admins.add(i.userToDTO());
        return ResponseEntity.ok(admins);
    }

    @DeleteMapping("/delete-instructor/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable("id") int id) {
        instructorService.deleteInstructorById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/reject-course/{id}")
    public ResponseEntity<Void> rejectPendingCourse(@PathVariable("id") int id) {
        pendingCourseService.deletePendingCourseById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-review/{studentId}/{courseId}")
    public ResponseEntity<Void> deleteReview(@PathVariable("studentId") int studentId,
                                             @PathVariable("courseId") int courseId) {
        adminService.deleteReview(studentId,courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/approve-course")
    public ResponseEntity<Void> approvePendingCourse(@RequestParam int pendingCourseId){
        adminService.acceptCourseRequest(pendingCourseId);
        return ResponseEntity.ok().build();
    }






}
