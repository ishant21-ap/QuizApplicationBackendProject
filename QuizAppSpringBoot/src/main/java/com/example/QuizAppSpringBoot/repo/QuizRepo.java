package com.example.QuizAppSpringBoot.repo;

import com.example.QuizAppSpringBoot.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
