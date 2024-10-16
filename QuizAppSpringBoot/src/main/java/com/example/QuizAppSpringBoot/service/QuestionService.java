package com.example.QuizAppSpringBoot.service;

import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository repo;


//    public List<Question> getAllQuestions() {
//        return repo.findAll();
//    }

//    public ResponseEntity<List<Question>> getAllQuestions() {
//        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
//    }

    //We are handling exceptions also
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);  //If something is wrong we will return empty list
    }




//    public List<Question> getAllQuestionsByCategory(String category) {
//        return repo.findByCategory(category);
//    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }




//    public String addQuestion(Question question) {
//        repo.save(question);
//        return "success";
//    }
public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }




//    public String deleteQuestion(Integer id) {
//        repo.deleteById(id);
//        return "success";
//    }
    public ResponseEntity<String> deleteQuestion(Integer id) {
        repo.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }



    public ResponseEntity<Question> updateQuestion(Integer id, Question question) {
        question.setId(id); // Ensure the ID is set for updating the correct record
        return new ResponseEntity<>(repo.save(question), HttpStatus.OK);
    }
}


