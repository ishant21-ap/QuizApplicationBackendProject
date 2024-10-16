package com.example.QuizAppSpringBoot.Controller;

import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;



//    @GetMapping("allQuestions")
//    public List<Question> getAllQuestions() {
//        return service.getAllQuestions();
//    }
    //We are not returning HTTP status code, in below code we are returning HTTP status code

//    @GetMapping("allQuestions")
//    public ResponseEntity<List<Question>> getAllQuestions() {
//        return new ResponseEntity<>(service.getAllQuestions(), HttpStatus.OK);
//    }

    //In a response Entity contructor we are returning object and HTTP status code
    //Now Instead of using it here are will use it service class because it makes more sense as we have
    //to handle exception also in serivce class thats why.
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return service.getAllQuestions();
    }



    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category) {
        return service.getAllQuestionsByCategory(category);
    }



    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id) {
        return service.deleteQuestion(id);
    }



    // Updated PUT Mapping to include ID in the URL
    @PutMapping("update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") Integer id, @RequestBody Question question) {
        return service.updateQuestion(id, question);
    }
}


