package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
