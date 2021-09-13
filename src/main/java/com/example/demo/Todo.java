package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Todo implements Serializable {

    @Id
    private Long id;

    private String title;
}
