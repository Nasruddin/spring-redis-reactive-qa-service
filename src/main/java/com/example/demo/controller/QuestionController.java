package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public Mono<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionService.addQuestion(questionDTO);
    }

    @GetMapping("/{id}")
    public Mono<QuestionDTO> getQuestion(@PathVariable("id") String id) {
        return questionService.getQuestion(id);
    }

}
