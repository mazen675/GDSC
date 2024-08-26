package com.example.learningplatform.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseId;
    @Column(unique = true,nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private Boolean paid;
    @Column(nullable = false)
    private ArrayList<String> tags=new ArrayList<String>();
    @ManyToMany
    private List<Student> Students;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Enrollment> enrollments;
    @ManyToMany
    private List<Admin> admins;
    public CourseDTO courseToDTO(){
        CourseDTO dto=new CourseDTO();
        dto.setCourseId(courseId);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setCategory(category);
        dto.setPaid(paid);
        dto.setTags(tags);
        return dto;
    }

}