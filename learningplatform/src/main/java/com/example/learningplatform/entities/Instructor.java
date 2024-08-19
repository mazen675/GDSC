package com.example.learningplatform.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorId;

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
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    @OneToMany(mappedBy = "instructor")
    private List<PendingCourse> pendingCourses;

    @ManyToMany
    private List<Admin> admins;

    public Instructor(){}

    public Instructor(int instructorId, List<Course> courses, List<PendingCourse> pendingCourses, List<Admin> admins) {
        this.instructorId = instructorId;
        this.courses = courses;
        this.pendingCourses = pendingCourses;
        this.admins = admins;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<PendingCourse> getPendingCourses() {
        return pendingCourses;
    }

    public void setPendingCourses(List<PendingCourse> pendingCourses) {
        this.pendingCourses = pendingCourses;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", courses=" + courses +
                ", pendingCourses=" + pendingCourses +
                ", admins=" + admins +
                "} " + super.toString();
    }
}
