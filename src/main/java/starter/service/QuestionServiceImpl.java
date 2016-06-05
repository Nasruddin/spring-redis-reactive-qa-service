package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starter.domain.Question;
import starter.domain.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by nasruddin on 5/6/16.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final StringRedisTemplate redisTemplate;

    private static final String KEY = "Question";

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, StringRedisTemplate redisTemplate) {
        this.repository = questionRepository;
        this.redisTemplate = redisTemplate;
    }


    public Question saveQuestion(Question question) {

        Question savedQuestion = repository.save(question);

        redisTemplate.opsForList().leftPush("Questions", question.getQuestion());
        return savedQuestion;
    }

    @Override
    public List<String> getAllQuestion() {

        repository.findAll();
        return redisTemplate.opsForList().range("Questions", 0, -1);
    }
}
