package dev.hotel.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
        //@Sql("data-1.sql")
    void test() {
        System.out.println(clientRepository.count());
    }

}
