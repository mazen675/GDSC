package com.example.learningplatform.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpDTO {
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotEmpty(message = "First Name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;

    public Admin toAdmin(){
        Admin admin=new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        return admin;
    }
    public Instructor toInstructor(){
        Instructor instructor=new Instructor();
        instructor.setEmail(email);
        instructor.setPassword(password);
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        return instructor;
    }
    public Student toStudent(){
        Student student=new Student();
        student.setEmail(email);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }
}
