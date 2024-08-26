package com.example.learningplatform.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Admin extends User{

    @OneToOne
    private User user;
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


}
