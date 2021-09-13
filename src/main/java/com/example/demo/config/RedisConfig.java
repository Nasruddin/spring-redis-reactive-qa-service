package com.example.demo.config;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    public <T> Jackson2JsonRedisSerializer<T> configureJackson2JsonRedisSerializer(Class<T> t) {
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Jackson2JsonRedisSerializer<T> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(t);
            jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
            return jackson2JsonRedisSerializer;
    }

    @Bean
    public ReactiveRedisTemplate<String, Answer> redisAnswerOperations(ReactiveRedisConnectionFactory connectionFactory) {
        RedisSerializationContext<String, Answer> serializationContext
                = RedisSerializationContext
                .<String, Answer>newSerializationContext(new StringRedisSerializer())
                .hashKey(new StringRedisSerializer())
                .hashValue(configureJackson2JsonRedisSerializer(Answer.class))
                .build();
        return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
    }
    @Bean
    public ReactiveRedisTemplate<String, Question> redisQuestionOperations(ReactiveRedisConnectionFactory connectionFactory) {
        RedisSerializationContext<String, Question> serializationContext
                = RedisSerializationContext
                .<String, Question>newSerializationContext(new StringRedisSerializer())
                .hashKey(new StringRedisSerializer())
                .hashValue(configureJackson2JsonRedisSerializer(Question.class))
                .build();
        return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
    }
}
