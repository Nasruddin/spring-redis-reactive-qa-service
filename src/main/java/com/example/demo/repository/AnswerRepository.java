package com.example.demo.repository;

import com.example.demo.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveSetOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.example.demo.common.Constants.ANSWER_KEY;

@Component
@RequiredArgsConstructor
public class AnswerRepository {

    private final ReactiveRedisTemplate<String, Answer> reactiveAnswerRedisTemplate;
    private final ReactiveRedisTemplate<String, String> reactiveStringRedisTemplate;

    private ReactiveHashOperations<String, String, Answer> reactiveHashOperations() {
        return reactiveAnswerRedisTemplate.opsForHash();
    }

    private ReactiveSetOperations<String, String> reactiveSetOperations() {
        return reactiveStringRedisTemplate.opsForSet();
    }

    public Mono<Answer> save(Answer answer) {
        return reactiveHashOperations().put(ANSWER_KEY +":"+ answer.getId(), answer.getId(), answer).thenReturn(answer);
    }

    public Mono<Answer> getAnswer(String id) {
        return reactiveHashOperations().get(ANSWER_KEY +":"+ id, id);
    }
}
