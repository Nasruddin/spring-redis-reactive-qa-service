package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starter.domain.Question;
import starter.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by nasruddin on 5/6/16.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    //private final StringRedisTemplate redisTemplate;
    private RedisTemplate<String, Question> redisTemplate;
    private HashOperations hashOperations;

    private static final String KEY = "Question";

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, RedisTemplate redisTemplate) {
        this.repository = questionRepository;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Question saveQuestion(Question question) {

        Question savedQuestion = repository.save(question);
        hashOperations.put(KEY, savedQuestion.getId(), savedQuestion);
        return savedQuestion;
    }

    @Override
    public Map<Object, Object> getAllQuestion() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void deleteQuestion(Long id) {
        repository.delete(id);
        hashOperations.delete(KEY, id);
    }
}
