package starter.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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


    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {

        Question savedQuestion = service.saveQuestion(question);

        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "get-all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<String>> getAllQuestions() {

        //List<String> lQuestion = stringRedisTemplate.opsForList().range("Questions",0,-1);

        List<String> allQuestion = service.getAllQuestion();

        return new ResponseEntity<>(allQuestion, HttpStatus.OK);

    }
}
