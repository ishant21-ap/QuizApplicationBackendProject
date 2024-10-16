package com.example.QuizAppSpringBoot.Controller;

import com.example.QuizAppSpringBoot.model.QuestionWrapper;
import com.example.QuizAppSpringBoot.model.Response;
import com.example.QuizAppSpringBoot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Now if suppose client wants to create a quiz, we have almost 16 question already added in database, so
//program should randomly choose number of question, and that particular category question tell by client
//If client want to make quiz of title JavaQuiz, Number of question should be 5 and category of question
//should be java, so we will accept this all data in url itself, thats why we have created createQuiz method,
//and in order to accept details of quiz from client we are using @RequestParam


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
//        return new ResponseEntity<>("I am here", HttpStatus.OK);    //In order to check everything working fine or not
        return quizService.createQuiz(category, numQ, title);

        //URL how to check
        //http://localhost:8080/quiz/create?cateogry=Java&numQ=5&title=JQuiz
    }



    //As if client want to take a quiz we only have to show him questions and options not right answer thats
    //why we have created an QuestionWrapper class
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
