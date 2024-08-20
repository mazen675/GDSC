package com.example.learningplatform.services;

import com.example.learningplatform.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.learningplatform.repositories.InstructorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepo;

    @Autowired
    private CourseService courseService;
    @Autowired
    private PendingCourseService pendingCourseService;

    public void addOrUpdateInstructor(Instructor instructor){
        instructorRepo.save(instructor);
    }
    public List<Instructor> getInstructors(){
        return instructorRepo.findAll();
    }
    public Instructor getInstructorByEmail(String email){
        for(Instructor i:getInstructors())
            if(i.getEmail().equals(email))
                return i;
        return null;
    }
    public Optional<Instructor> getInstructorById(int Id){
        return instructorRepo.findById(Id);
    }
    public void deleteInstructorById(int Id){
        instructorRepo.deleteById(Id);
    }
    public void sendCourseRequest(PendingCourse pendingCourse,int instructorId){
        Instructor instructor = getInstructorById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id " + instructorId));
        pendingCourse.setInstructor(instructor);
        instructor.getPendingCourses().add(pendingCourse);
        pendingCourseService.addPendingCourse(pendingCourse);
    }

    public void deleteCourse(int instructorId,int courseId){
        Instructor instructor=getInstructorById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id " + instructorId));
        Course course=courseService.getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        if(course.getInstructor().getInstructorId()==instructorId)
            courseService.deleteCourseById(courseId);
    }
    public List<Course> getCourses(int instructorId){
        Instructor instructor = getInstructorById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id " + instructorId));
        return instructor.getCourses();
    }

    public List<String> getReviews(int courseId){
        List<String> reviews=new ArrayList<>();
        Course course = courseService.getCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        for(Enrollment i : course.getEnrollments())
            reviews.add(i.getReview());
        return reviews;
    }

}
