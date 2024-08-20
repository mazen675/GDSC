package com.example.learningplatform.services;

import com.example.learningplatform.repositories.PendingCourseRepository;
import com.example.learningplatform.entities.PendingCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PendingCourseService {
    @Autowired
    private PendingCourseRepository pendingCourseRepo;


    public List<PendingCourse> getPendingCourses(){
        return pendingCourseRepo.findAll();
    }

    public Optional<PendingCourse> getPendingCourseById(int Id){
        return pendingCourseRepo.findById(Id);
    }

    public void addPendingCourse(PendingCourse pendingCourse){
        pendingCourseRepo.save(pendingCourse);
    }

    public void deletePendingCourseById(int Id){
        pendingCourseRepo.deleteById(Id);
    }

}
