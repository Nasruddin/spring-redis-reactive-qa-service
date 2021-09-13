package com.example.demo.repository;

import com.example.demo.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveSetOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.example.demo.common.Constants.QUESTION_KEY;

@Component
@RequiredArgsConstructor
public class QuestionRepository {

    private final ReactiveRedisTemplate<String, Question> reactiveQuestionRedisTemplate;
    private final ReactiveRedisTemplate<String, String> reactiveStringRedisTemplate;

    private ReactiveHashOperations<String, String, Question> reactiveHashOperations() {
        return reactiveQuestionRedisTemplate.opsForHash();
    }

    private ReactiveSetOperations<String, String> reactiveSetOperations() {
        return reactiveStringRedisTemplate.opsForSet();
    }

    public Mono<Question> save(Question question) {
        question.getTags().forEach(tag -> {
            reactiveSetOperations().add(QUESTION_KEY + ":" + question.getId() + ":" + "tags", question.getId());
        });
        return reactiveHashOperations().put(QUESTION_KEY +":"+ question.getId(), question.getId(), question).thenReturn(question);
    }

    public Mono<Question> getQuestions(String id) {
        return reactiveHashOperations().get(QUESTION_KEY +":"+ id, id);
    }
}
