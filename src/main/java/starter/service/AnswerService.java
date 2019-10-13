package starter.service;

import starter.cache.model.Timeline;
import starter.domain.Answer;

import java.util.Map;
import java.util.Optional;

/**
 * Created by nasir on 18/11/17.
 */
public interface AnswerService {
    Optional<Answer> saveAnswer(Answer answer, Long questionId);
    Timeline getAllAnswers(Long questionId);
}
