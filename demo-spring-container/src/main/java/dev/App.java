package dev;

import dev.presentation.Presentation1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

//        IPersistance persitance = new Persistance1();
//        IMetier metier = new Metier1(persitance);
//        Scanner scanner = new Scanner(System.in);
//        Presentation1 presentation1 = new Presentation1(metier, scanner);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Presentation1 presentation1 = context.getBean(Presentation1.class);
//        Presentation1 presentation2 = context.getBean(Presentation1.class);
//        Presentation1 presentation3 = context.getBean(Presentation1.class);
//        Presentation1 presentation4 = context.getBean(Presentation1.class);
        presentation1.print();
        context.close();
    }
}
