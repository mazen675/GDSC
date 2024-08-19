package com.example.learningplatform.services;

import com.example.learningplatform.entities.Enrollment;
import com.example.learningplatform.repositories.CourseRepository;
import com.example.learningplatform.repositories.StudentRepository;
import com.example.learningplatform.entities.Course;
import com.example.learningplatform.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }
    public Optional<Student> getStudentById(int id){
        return studentRepo.findById(id);
    }

    public Student getStudentByEmail(String email){
        for(Student s:getStudents())
            if(s.getEmail().equals(email))
                return s;
        return null;
    }

    public void addOrUpdateStudent(Student student){
        studentRepo.save(student);
    }
    public void deleteStudentById(int id){
        studentRepo.deleteById(id);
    }



    @Transactional
    public void enrollInCourse(int studentId, int courseId){
        Student student = getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));

        if (student.getCourses() == null) {
            student.setCourses(new ArrayList<>());
        }
        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
        }

        if (course.getStudents() == null) {
            course.setStudents(new ArrayList<>());
        }

        if (!course.getStudents().contains(student)) {
            course.getStudents().add(student);
        }

            studentRepo.save(student);
            courseRepo.save(course);
    }
    @Transactional
    public List<Course> getCoursesForStudent(int studentId){
        Student student = getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        return student.getCourses();
    }
    @Transactional
    public Double getProgressForCourse(int studentId, int courseId){
        Student student = getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        for(Enrollment i : student.getEnrollments())
            if(i.getCourse().getCourseId()==courseId)
                return i.getProgress();
        return null;
    }
    @Transactional
    public void updateProgressForCourse(int studentId, int courseId, double progress){
        Student student = getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));

        for(Enrollment i : student.getEnrollments())
            if(i.getCourse().getCourseId()==courseId){
                i.setProgress(progress);
                break;
            }
        studentRepo.save(student);
        courseRepo.save(course);
    }
    @Transactional
    public void addReviewForCourse(int studentId, int courseId, String review){
        Student student = getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));

        for(Enrollment i : student.getEnrollments())
            if(i.getCourse().getCourseId()==courseId){
                i.setReview(review);
                break;
            }
        studentRepo.save(student);
        courseRepo.save(course);
    }

}
