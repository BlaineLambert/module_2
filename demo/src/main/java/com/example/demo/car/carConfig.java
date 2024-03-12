package com.example.demo.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class carConfig {
    @Bean
    CommandLineRunner CarCommandLineRunner(CarRepository cr) {
        return args -> {
            Car ford = new Car(

            );
            cr.saveAll(
                    List.of(ford)
            );
        };
    }
}
