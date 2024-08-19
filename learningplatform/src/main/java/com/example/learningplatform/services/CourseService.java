package com.example.learningplatform.services;

import com.example.learningplatform.repositories.CourseRepository;
import com.example.learningplatform.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int id){
        return courseRepo.findById(id);
    }
    public void addOrUpdateCourse(Course course){
        courseRepo.save(course);
    }

    public void deleteCourseById(int courseId){
        courseRepo.deleteById(courseId);
    }

}
