package com.example.learningplatform.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double progress;
    private String review;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "courseId")
    private Course course;
}
