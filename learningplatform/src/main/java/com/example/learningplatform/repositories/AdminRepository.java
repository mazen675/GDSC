package com.example.learningplatform.repositories;

import com.example.learningplatform.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
