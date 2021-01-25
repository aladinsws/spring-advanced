package dev.metier;

import dev.persistance.IPersistance;
import dev.persistance.Persistance1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan("dev")
public class TestConfig {

    @Bean
    public IPersistance persistance1() {
        return mock(Persistance1.class);
    }
}
