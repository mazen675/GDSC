package com.example.learningplatform.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Student extends User{
    @OneToOne
    private User user;
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

}
