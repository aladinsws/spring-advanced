package dev;

import dev.config.AppConfig;
import dev.ihm.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringJava {


    public static void main(String[] args) {

        // Création du contexte Spring à partir d'une configuration Java
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Menu menu2 = context.getBean(Menu.class);
            menu2.afficher();
        }

//        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
//            context.getEnvironment().setActiveProfiles("fichier");
//            context.register(AppConfig.class);
//            context.refresh();
//
//            Menu menu2 = context.getBean(Menu.class);
//            menu2.afficher();
//        }


    }
}
