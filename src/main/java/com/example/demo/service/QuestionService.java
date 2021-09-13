package com.example.demo.service;

import com.example.demo.common.Util;
import com.example.demo.domain.Question;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Util util;

    public Mono<QuestionDTO> addQuestion(QuestionDTO questionDTO) {
        Mono<Question> questionMono = questionRepository.save(Question.builder().id(util.generateId()).question(questionDTO.getQuestion()).tags(questionDTO.getTags()).build());
        return questionMono.map(question -> QuestionDTO.builder().id(question.getId()).question(question.getQuestion()).build());
    }

    public Mono<QuestionDTO> getQuestion(String id) {
        return questionRepository.getQuestions(id).map(question -> QuestionDTO.builder().id(question.getId()).question(question.getQuestion()).build());
    }
}
