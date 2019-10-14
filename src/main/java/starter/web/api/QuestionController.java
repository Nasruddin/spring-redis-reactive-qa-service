package starter.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.domain.Answer;
import starter.domain.Question;
import starter.service.AnswerService;
import starter.service.QuestionService;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by nasruddin on 5/6/16.
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @Autowired
    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody @Valid Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @PostMapping("/{questionId}/answer")
    public ResponseEntity<Answer> saveAnswer(@RequestBody @Valid Answer answer,
                                             @PathVariable("questionId") Long questionId){
        return new ResponseEntity<>(answerService.saveAnswer(answer, questionId)
                .orElse(new Answer()), HttpStatus.OK);
    }

}
