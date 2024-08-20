package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {
}
