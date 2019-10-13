package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.cache.model.Timeline;
import starter.cache.service.TimelineService;
import starter.domain.Answer;
import starter.domain.Question;
import starter.repository.AnswerRepository;
import starter.repository.QuestionRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

/**
 * Created by nasir on 18/11/17.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final TimelineService timelineService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository, TimelineService timelineService) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.timelineService = timelineService;
    }


    @Override
    public Optional<Answer> saveAnswer(Answer answer, Long questionId) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    Answer savedAnswer = answerRepository.save(answer);
                    if (null != savedAnswer.getId()) {
                        cacheAnswer(savedAnswer, questionId, question);
                    }
                    return savedAnswer;
                });
    }

    private void cacheAnswer(Answer answer, Long questionId, Question question) {
        Set<Answer> answers = answerRepository.findAnswerByQuestionId(questionId);
        answers.add(answer);
        Timeline timeline = Timeline.builder().id(questionId).question(question).answers(answers).build();
        timelineService.save(timeline);
    }

    @Override
    public Timeline getAllAnswers(Long questionId) {
       return timelineService.getTimeline(questionId).orElse(new Timeline());
    }

}
