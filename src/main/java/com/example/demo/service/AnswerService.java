package com.example.demo.service;

import com.example.demo.common.Util;
import com.example.demo.domain.Answer;
import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final Util util;

    public Mono<AnswerDTO> addQuestion(AnswerDTO answerDTO) {
        Mono<Answer> answerMono = answerRepository.save(Answer.builder().id(util.generateId()).answer(answerDTO.getAnswer()).build());
        return answerMono.map(answer -> AnswerDTO.builder().id(answer.getId()).answer(answer.getAnswer()).build());
    }

    public Mono<QuestionDTO> getAnswer(String id) {
        return answerRepository.getAnswer(id).map(answer -> QuestionDTO.builder().id(answer.getId()).question(answer.getAnswer()).build());
    }

}
