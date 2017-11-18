package starter.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.domain.Answer;
import starter.service.AnswerService;

import java.util.Map;

/**
 * Created by nasir on 18/11/17.
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        Answer savedAnswer = answerService.saveAnswer(answer);
        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Map<Object, Object>> getAllAnswers() {
        Map<Object, Object> allAnswers = answerService.getAllAnswers();
        return new ResponseEntity<>(allAnswers, HttpStatus.OK);
    }
}
