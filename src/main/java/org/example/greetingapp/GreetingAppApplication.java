package org.example.greetingapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {

    public static void main(String[] args) {
        Dotenv.configure().systemProperties().load();
        SpringApplication.run(GreetingAppApplication.class, args);
    }

}
