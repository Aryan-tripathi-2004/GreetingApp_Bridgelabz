package org.example.greetingapp.service;

import org.example.greetingapp.DTO.GreetingDTO;
import org.example.greetingapp.DTO.UserDTO;
import org.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public GreetingDTO addGreeting(UserDTO user) {
        String message = String.format(template, (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) ? "World" : user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(new GreetingDTO(counter.incrementAndGet(), message));
    }

    @Override
    public GreetingDTO getGreetingById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }

    @Override
    public List<GreetingDTO> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public GreetingDTO editGreeting(long id, UserDTO user) {
        GreetingDTO greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
        greeting.setMessage(String.format(template, (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) ? "World" : user.getFirstName() + " " + user.getLastName()));
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }
}
