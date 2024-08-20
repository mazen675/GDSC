package com.example.learningplatform.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(nullable = false ,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

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
    @ManyToMany
    @JoinTable(
            name="student_courses",
            joinColumns=@JoinColumn(name="studentId"),
            inverseJoinColumns=@JoinColumn(name = "courseId")
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Enrollment> enrollments;

    @ManyToMany
    private List<Admin> admins;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Enrollment> getEnrollments() {

        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public UserDTO studentToDTO(){
        UserDTO dto=new UserDTO();
        dto.setUserId(studentId);
        dto.setEmail(email);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        return dto;
    }
}
