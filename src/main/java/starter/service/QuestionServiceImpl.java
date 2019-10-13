package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starter.domain.Question;
import starter.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nasruddin on 5/6/16.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.repository = questionRepository;
    }


    @Override
    public Question saveQuestion(Question question) {
        Question savedQuestion = repository.save(question);
        return savedQuestion;
    }

}
