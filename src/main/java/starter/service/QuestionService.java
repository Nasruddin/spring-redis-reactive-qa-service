package starter.service;

import starter.domain.Question;

import java.util.List;

/**
 * Created by nasruddin on 5/6/16.
 */
public interface QuestionService {

    Question saveQuestion(Question question);
    List<String> getAllQuestion();
}
