package dev;

import dev.config.AppConfigV1;
import dev.ihm.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringJava {

    public static void main(String[] args) {

        // création du contexte Spring
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigV1.class)) {
            Menu menu = context.getBean(Menu.class);
            menu.afficher();
        } // context.close() appelé automatiquement même s'il y a une erreur

    }
}
