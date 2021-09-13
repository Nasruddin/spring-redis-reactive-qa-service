package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class QuestionDTO {

    private String id;
    private String question;
    private Set<String> tags;
    private Long votes;
}
