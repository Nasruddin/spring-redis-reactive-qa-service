package starter.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.domain.Question;
import starter.service.QuestionService;

import java.util.List;
import java.util.Map;

/**
 * Created by nasruddin on 5/6/16.
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {

        Question savedQuestion = service.saveQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }


    @GetMapping("/get-all")
    public ResponseEntity<Map<Object, Object>> getAllQuestions() {

        Map<Object, Object> allQuestion = service.getAllQuestion();
        return new ResponseEntity<>(allQuestion, HttpStatus.OK);

    }
}
