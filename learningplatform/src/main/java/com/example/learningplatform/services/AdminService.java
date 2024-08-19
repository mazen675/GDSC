package com.example.learningplatform.services;

import com.example.learningplatform.entities.Admin;
import com.example.learningplatform.entities.Course;
import com.example.learningplatform.entities.PendingCourse;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.learningplatform.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private PendingCourseService pendingCourseService;
    @Autowired
    private CourseService courseService;

    public List<Admin> getAdmins(){
        return adminRepo.findAll();
    }
    public Optional<Admin> getAdminById(int id){
        return adminRepo.findById(id);
    }
    public Admin getAdminByEmail(String email){
        for(Admin a:getAdmins())
            if(a.getEmail().equals(email))
                return a;
        return null;
    }
    public void addOrUpdateAdmin(Admin admin){
        adminRepo.save(admin);
    }
    public void deleteAdmin(int id){
        adminRepo.deleteById(id);
    }
    public void acceptCourseRequest(int pendingCourseId){
        PendingCourse pendingCourse=pendingCourseService.getPendingCourseById(pendingCourseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + pendingCourseId));

        Course course = new Course();
        course.setTitle(pendingCourse.getTitle());
        course.setDescription(pendingCourse.getDescription());
        course.setCategory(pendingCourse.getCategory());
        course.setPaid(pendingCourse.getPaid());
        course.setTags(pendingCourse.getTags());
        course.setInstructor(pendingCourse.getInstructor());
        course.setAdmins(pendingCourse.getAdmins());

        courseService.addOrUpdateCourse(course);
        pendingCourseService.deletePendingCourseById(pendingCourseId);
    }

}
