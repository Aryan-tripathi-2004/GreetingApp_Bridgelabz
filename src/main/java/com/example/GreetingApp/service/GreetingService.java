package com.example.GreetingApp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private String greet() {
        return "Hello, World!";
    }
}
