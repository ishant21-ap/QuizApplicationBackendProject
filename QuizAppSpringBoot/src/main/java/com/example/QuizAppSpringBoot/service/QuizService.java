package com.example.QuizAppSpringBoot.service;

import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.model.QuestionWrapper;
import com.example.QuizAppSpringBoot.model.Quiz;
import com.example.QuizAppSpringBoot.model.Response;
import com.example.QuizAppSpringBoot.repo.QuestionRepository;
import com.example.QuizAppSpringBoot.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepository questionRepo;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        //Getting allthe question
        List<Question> questionList = questionRepo.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questionList);

        quizRepo.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);    //We use optionaly because we are not sure about id might not be null

        //Now we have our quiz question in quiz object, we want to convert them in our Quesition as they are of QuestionWrapper currently
        //We are using Optional thats why we need to get the data that why we use get()
        //So in the following for loop we are filling question of quiz we get from database for user

        List<Question> questionFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }



    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();   //Instead of using Optional we can use this line also(Line 42)
        List<Question> questions = quiz.getQuestion();
        int right = 0;
        int i = 0;

        for(Response r : responses) {
            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;

        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
