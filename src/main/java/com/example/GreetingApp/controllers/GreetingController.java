package com.example.GreetingApp.controllers;

import com.example.GreetingApp.DTO.GreetingDTO;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public GreetingDTO getGreeting(@RequestParam(value = "firstName", defaultValue = "") String firstName, @RequestParam(value = "lastName", defaultValue = "" , required = false) String lastName) {
        return new GreetingDTO("Hello, World!"+firstName+" "+lastName);
    }

    @PostMapping
    public GreetingDTO createGreeting(@RequestBody GreetingDTO greeting) {
        return new GreetingDTO("Created: " + greeting.getMessage());
    }

    @PutMapping
    public GreetingDTO updateGreeting(@RequestBody GreetingDTO greeting) {
        return new GreetingDTO("Updated: " + greeting.getMessage());
    }

    @DeleteMapping
    public GreetingDTO deleteGreeting() {
        return new GreetingDTO("Deleted");
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello, World!";
    }

}