package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import starter.domain.Answer;
import starter.repository.AnswerRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by nasir on 18/11/17.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    //private final StringRedisTemplate redisTemplate;
    private RedisTemplate<String, Answer> redisTemplate;
    private HashOperations hashOperations;

    private static final String KEY = "Answer";

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, RedisTemplate redisTemplate) {
        this.answerRepository = answerRepository;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Answer saveAnswer(Answer answer) {

        Answer savedAnswer = answerRepository.save(answer);
        hashOperations.put(KEY, savedAnswer.getId(), savedAnswer);
        return savedAnswer;
    }

    @Override
    public Map<Object, Object> getAllAnswers() {
        return hashOperations.entries(KEY);
    }

}
