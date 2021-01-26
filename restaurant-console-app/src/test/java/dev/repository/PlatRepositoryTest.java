package dev.repository;

import dev.config.DataSourceH2Config;
import dev.config.JpaConfig;
import dev.entite.Plat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig({DataSourceH2Config.class, JpaConfig.class})
@ActiveProfiles("datajpa")
class PlatRepositoryTest {

    @Autowired
    PlatRepository platRepository;

    @Test
    @Sql("classpath:data.sql")
    void findAll() {
        List<Plat> resultat = platRepository.findAll();
        Assertions.assertThat(resultat).isNotEmpty();
    }
}
