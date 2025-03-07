package org.example.greetingapp.service;

import org.example.greetingapp.DTO.GreetingDTO;
import org.example.greetingapp.DTO.UserDTO;
import java.util.List;


public interface IGreetingService {
    GreetingDTO addGreeting(UserDTO user);
    GreetingDTO getGreetingById(long id);
    List<GreetingDTO> getAllGreetings();
    GreetingDTO editGreeting(long id, UserDTO user);
    void deleteGreeting(long id);
}
