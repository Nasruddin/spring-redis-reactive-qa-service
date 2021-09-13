package com.example.demo.controller;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public Mono<AnswerDTO> addQuestion(@RequestBody AnswerDTO answerDTO) {
        return answerService.addQuestion(answerDTO);
    }

    @GetMapping("/{id}")
    public Mono<QuestionDTO> getQuestion(@PathVariable("id") String id) {
        return answerService.getAnswer(id);
    }
}
