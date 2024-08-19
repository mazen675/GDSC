package com.example.learningplatform.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

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
    private List<Enrollment> enrollments;
    @ManyToMany
    private List<Admin> admins;

    public Course() {
    }

    public Course(int courseId, String title, String description,
                  String category, Boolean paid, ArrayList<String> tags,
                  List<Student> students, Instructor instructor,
                  List<Enrollment> enrollments, List<Admin> admins) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.paid = paid;
        this.tags = tags;
        Students = students;
        this.instructor = instructor;
        this.enrollments = enrollments;
        this.admins = admins;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public void setStudents(List<Student> students) {
        Students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", paid=" + paid +
                ", tags=" + tags +
                ", Students=" + Students +
                ", instructor=" + instructor +
                ", enrollments=" + enrollments +
                ", admins=" + admins +
                '}';
    }
}
