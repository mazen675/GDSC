package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.PendingCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingCourseRepository extends JpaRepository<PendingCourse,Integer> {
}
