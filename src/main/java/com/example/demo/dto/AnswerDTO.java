package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private String id;
    private String questionId;
    private String answer;
    private Long votes;
}
