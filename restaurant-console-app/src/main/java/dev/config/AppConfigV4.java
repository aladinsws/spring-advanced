package dev.config;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.IPlatService;
import dev.service.PlatServiceVersion1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


@Configuration // déco
public class AppConfigV4 {

    @Bean
    public IPlatDao dao() {
        return new PlatDaoMemoire();
    }

    @Bean
    public IPlatService service(IPlatDao dao) {
        return new PlatServiceVersion1(dao);
    }

    @Bean
    public Menu menu(Scanner scanner, IPlatService service) {
        return new Menu(scanner, service);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
