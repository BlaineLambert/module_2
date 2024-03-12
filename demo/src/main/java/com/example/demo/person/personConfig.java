package com.example.demo.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class personConfig {
    @Bean
    CommandLineRunner PersonCommandLineRunner(PersonRepository pr) {
        return args -> {

            Person blaine = new Person(
                    1L,
                    "Blaine Lambert",
                    "male"
            );
            Person AJ = new Person(
                    2L,
                    " AJ Gilliland",
                    "male"

            );
            pr.saveAll(
                    List.of(blaine, AJ)
            );
        };
    }
}
