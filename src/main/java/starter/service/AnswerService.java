package starter.service;

import starter.domain.Answer;

import java.util.Map;

/**
 * Created by nasir on 18/11/17.
 */
public interface AnswerService {
    Answer saveAnswer(Answer answer);
    Map<Object, Object> getAllAnswers();
}
