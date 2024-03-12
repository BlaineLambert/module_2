package com.example.demo.job;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class jobConfig {
    @Bean
    CommandLineRunner JobCommandLineRunner(JobRepository jr) {
        return args -> {
            Job bcca = new Job(
                    1L,
                    "BCCA"
            );
            Job btc = new Job(
                    2L,
                    "BTC"
            );
            jr.saveAll(
                    List.of(bcca, btc)
            );
        };
    }
}
