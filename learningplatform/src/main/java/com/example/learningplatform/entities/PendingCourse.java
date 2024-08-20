package com.example.learningplatform.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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

    public PendingCourse(){

    }

    public PendingCourse(int pendingCourseId, String title, String description, String category, Boolean paid, ArrayList<String> tags, Instructor instructor, List<Admin> admins) {
        this.pendingCourseId = pendingCourseId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.paid = paid;
        this.tags = tags;
        this.instructor = instructor;
        this.admins = admins;
    }

    public int getPendingCourseId() {
        return pendingCourseId;
    }


    public void setPendingCourseId(int pendingCourseId) {
        this.pendingCourseId = pendingCourseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
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

    @Override
    public String toString() {
        return "PendingCourse{" +
                "pendingCourseId=" + pendingCourseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", paid=" + paid +
                ", tags=" + tags +
                ", instructor=" + instructor +
                ", admins=" + admins +
                '}';
    }
}
