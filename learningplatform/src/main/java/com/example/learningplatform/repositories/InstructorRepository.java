package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
