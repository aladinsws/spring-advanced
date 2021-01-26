package dev.repository;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig({JdbcTestConfig.class, JpaConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("datajpa")
@Transactional
public abstract class BaseRepositoryIntegrationTest {
}
