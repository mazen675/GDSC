package com.example.learningplatform.controllers;

import com.example.learningplatform.entities.*;
import com.example.learningplatform.services.AdminService;
import com.example.learningplatform.services.InstructorService;
import com.example.learningplatform.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String type = loginRequest.getType();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        if (type.equals("Instructor")) {
            Instructor instructor = instructorService.getInstructorByEmail(email);
            if (instructor != null && instructor.getPassword().equals(password)) {
                return ResponseEntity.ok("Instructor login successful");
            }
        } else if (type.equals("Student")) {
            Student student = studentService.getStudentByEmail(email);
            if (student != null && student.getPassword().equals(password)) {
                return ResponseEntity.ok("Student login successful");
            }
        } else if (type.equals("Admin")) {
            Admin admin = adminService.getAdminByEmail(email);
            if (admin != null && admin.getPassword().equals(password)) {
                return ResponseEntity.ok("Admin login successful");
            }
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO, @RequestParam String type) {
        if (type.equals("Admin")) {
            Admin admin=userDTO.toAdmin();
            adminService.addOrUpdateAdmin(admin);
        } else if (type.equals("Instructor")) {
            Instructor instructor=userDTO.toInstructor();
            instructorService.addOrUpdateInstructor(instructor);
        } else if (type.equals("Student")) {
            Student student=userDTO.toStudent();
            studentService.addOrUpdateStudent(student);
        }
        return ResponseEntity.ok("Signup successful");
    }
}
