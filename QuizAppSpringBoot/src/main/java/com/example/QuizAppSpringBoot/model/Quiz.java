package com.example.QuizAppSpringBoot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    //As we have quiz with mutiple question that why do mapping
    @ManyToMany
    private List<Question> question;
}
