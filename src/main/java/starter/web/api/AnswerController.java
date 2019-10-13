package starter.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.cache.model.Timeline;
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

    @GetMapping("/{questionId}")
    public Timeline getAllAnswers(@PathVariable("questionId") Long questionId) {

        return answerService.getAllAnswers(questionId);
    }
}
