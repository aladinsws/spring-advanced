package dev.config;

import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Scanner;


@Configuration // déco
@Import({Menu.class, PlatDaoMemoire.class, PlatServiceVersion1.class})
public class AppConfigV3 {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
