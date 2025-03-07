package org.example.greetingapp.repository;

import org.example.greetingapp.DTO.GreetingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingDTO, Long> {
}
