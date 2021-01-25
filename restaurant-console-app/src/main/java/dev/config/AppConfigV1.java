package dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/*

    // Choix du Dao
    PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();
    // PlatDaoFichier platDaoFichier = new PlatDaoFichier("A_COMPLETER/2020-03-formation-spring/restaurant.txt");

    // Choix du service
    // PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
    PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

    // Construction du menu avec le service choisi
    Scanner scanner = new Scanner(System.in)
    Menu menu = new Menu(scanner, platServiceVersion2);

 */
@Configuration // déco
@ComponentScan({"dev.ihm", "dev.service", "dev.dao"})
public class AppConfigV1 {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
