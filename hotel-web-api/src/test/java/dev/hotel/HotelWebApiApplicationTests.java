package dev.hotel;

import dev.hotel.repository.ClientRepository;
import dev.hotel.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {ClientService.class})
class HotelWebApiApplicationTests {

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    @Test
    void contextLoads() {

    }

}
