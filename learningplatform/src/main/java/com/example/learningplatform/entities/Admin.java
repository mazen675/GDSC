package com.example.learningplatform.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
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
            name="admin_courses",
            joinColumns=@JoinColumn(name="adminId"),
            inverseJoinColumns=@JoinColumn(name = "courseId")
    )
    private List<Course> courses;

    @ManyToMany
    @JoinTable(
            name="admin_instructors",
            joinColumns=@JoinColumn(name="adminId"),
            inverseJoinColumns=@JoinColumn(name = "instructorId")
    )
    private List<Instructor> instructors;

    @ManyToMany
    @JoinTable(
            name="admin_students",
            joinColumns=@JoinColumn(name="adminId"),
            inverseJoinColumns=@JoinColumn(name = "studentId")
    )
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name="admin_pendingCourses",
            joinColumns=@JoinColumn(name="adminId"),
            inverseJoinColumns=@JoinColumn(name = "pendingCourseId")
    )
    private List<PendingCourse> pendingCourses;


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public UserDTO adminToDTO(){
        UserDTO dto=new UserDTO();
        dto.setUserId(adminId);
        dto.setEmail(email);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        return dto;
    }
}
