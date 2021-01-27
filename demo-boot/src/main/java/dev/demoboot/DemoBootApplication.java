package dev.demoboot;

import dev.demoboot.service.PlatSrv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoBootApplication.class, args);
        DataSource ds = context.getBean(DataSource.class);
        System.out.println(ds);

        PlatSrv platSrv = context.getBean(PlatSrv.class);

        platSrv.lister().forEach(System.out::println);
    }

}
