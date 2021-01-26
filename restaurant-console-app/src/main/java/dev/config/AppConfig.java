package dev.config;

import org.springframework.context.annotation.*;

import java.util.Scanner;

@Configuration
@ComponentScan({"dev.ihm", "dev.service", "dev.dao", "dev.aspect"})
@PropertySource("classpath:app.properties")
// activer la prise en compte des aspects
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DataSourceConfig.class, JpaConfig.class})
public class AppConfig {

    // <bean id="scanner" class="java.util.Scanner"/>
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
