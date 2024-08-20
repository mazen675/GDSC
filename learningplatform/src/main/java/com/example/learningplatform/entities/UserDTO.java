package com.example.learningplatform.entities;

import jakarta.persistence.Column;

public class UserDTO {
    private int userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Admin toAdmin(){
        Admin admin=new Admin();
        admin.setAdminId(userId);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        return admin;
    }
    public Instructor toInstructor(){
        Instructor instructor=new Instructor();
        instructor.setInstructorId(userId);
        instructor.setEmail(email);
        instructor.setPassword(password);
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        return instructor;
    }
    public Student toStudent(){
        Student student=new Student();
        student.setStudentId(userId);
        student.setEmail(email);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }



}
