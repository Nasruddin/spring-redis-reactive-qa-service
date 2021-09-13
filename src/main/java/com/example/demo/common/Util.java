package com.example.demo.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Util {

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
