package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TodoRepository {

    private final String KEY = "users";

    private final ReactiveRedisTemplate<String, Todo> reactiveRedisTemplate;

    private ReactiveHashOperations<String, String, Todo> reactiveHashOperations() {
        return reactiveRedisTemplate.opsForHash();
    }

    public Mono<Todo> save(Todo todo) {
        return reactiveHashOperations().put(KEY, todo.getTitle(), todo).thenReturn(todo);
    }
}
