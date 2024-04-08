package skypro.Coursework2.exam.services;

import org.springframework.context.annotation.Bean;

import java.util.Random;
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Random random() {
        return new Random();
    }
}
