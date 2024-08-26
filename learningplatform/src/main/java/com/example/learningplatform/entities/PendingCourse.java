package com.example.learningplatform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PendingCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pendingCourseId;

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
    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToMany
    private List<Admin> admins;
    public CourseDTO pendingCourseToDTO(){
        CourseDTO dto=new CourseDTO();
        dto.setCourseId(pendingCourseId);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setCategory(category);
        dto.setPaid(paid);
        dto.setTags(tags);
        return dto;
    }
}