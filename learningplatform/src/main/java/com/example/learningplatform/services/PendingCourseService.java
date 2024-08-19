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


    List<PendingCourse> getPendingCourses(){
        return pendingCourseRepo.findAll();
    }

    Optional<PendingCourse> getPendingCourseById(int Id){
        return pendingCourseRepo.findById(Id);
    }

    void addPendingCourse(PendingCourse pendingCourse){
        pendingCourseRepo.save(pendingCourse);
    }

    void deletePendingCourseById(int Id){
        pendingCourseRepo.deleteById(Id);
    }

}
