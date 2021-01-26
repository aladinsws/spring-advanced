package dev.dao;

import dev.config.DataSourceH2Config;
import dev.entite.Plat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig({DataSourceH2Config.class, PlatDaoJdbc.class})
@ActiveProfiles("jdbc")
@Transactional
class PlatDaoJdbcTest {

    @Autowired
    PlatDaoJdbc platDaoJdbc;

    @Test
    @Sql("classpath:data-1.sql")
    void listerPlats() {
        List<Plat> resultat = platDaoJdbc.listerPlats();
        assertThat(resultat).isNotEmpty();
    }

    @Test
    @Sql("classpath:data-2.sql")
    void ajouterPlat() {
        List<Plat> resultat = platDaoJdbc.listerPlats();
        assertThat(resultat).isNotEmpty();
    }
}
