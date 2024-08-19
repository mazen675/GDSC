package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
