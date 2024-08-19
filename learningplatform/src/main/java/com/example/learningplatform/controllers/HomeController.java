package com.example.learningplatform.controllers;

import com.example.learningplatform.entities.Admin;
import com.example.learningplatform.entities.Instructor;
import com.example.learningplatform.entities.Student;
import com.example.learningplatform.services.AdminService;
import com.example.learningplatform.services.InstructorService;
import com.example.learningplatform.services.StudentService;
import com.example.learningplatform.entities.LoginRequest;
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
    public ResponseEntity<String> signUp(@RequestBody Student student, @RequestParam String type) {
        if (type.equals("Admin")) {
            //Admin admin = new Admin();
            // Copy fields from student to admin or populate admin appropriately
            //adminService.addOrUpdateAdmin(admin);
        } else if (type.equals("Instructor")) {
            //Instructor instructor = new Instructor();
            // Copy fields from student to instructor or populate instructor appropriately
            //instructorService.addOrUpdateInstructor(instructor);
        } else if (type.equals("Student")) {
            studentService.addOrUpdateStudent(student);
        }
        return ResponseEntity.ok("Signup successful");
    }
}
