package com.example.learningplatform.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Instructor extends User{
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    @OneToMany(mappedBy = "instructor")
    private List<PendingCourse> pendingCourses;

    @ManyToMany
    private List<Admin> admins;

}
