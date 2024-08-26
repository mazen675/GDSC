package com.example.learningplatform.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class CourseDTO {
    private int courseId;
    @NotEmpty(message = "title cannot be empty")
    private String title;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    @NotEmpty(message = "Category cannot be empty")
    private String category;
    @NotEmpty(message = "Payment Status cannot be empty")
    private boolean paid;
    private List<String> tags;
    public PendingCourse toCourse(){
        PendingCourse course =new PendingCourse();
        course.setTitle(title);
        course.setDescription(description);
        course.setCategory(category);
        course.setPaid(paid);
        course.setTags((ArrayList<String>) tags);
        return course;
    }
}