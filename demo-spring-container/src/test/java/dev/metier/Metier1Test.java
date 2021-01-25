package dev.metier;


import dev.persistance.Persistance1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
// JUnit 4 => @RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {Metier1.class, Persistance1.class})
//@ContextConfiguration(classes = TestConfig.class)
@SpringJUnitConfig({TestConfig.class})
class Metier1Test {

    @Autowired
    Metier1 metier1; // Metier1 + Persistance1

    @Autowired
    Persistance1 persistance1;


    @Test
    void get() {
        when(persistance1.get()).thenReturn("p1");
        
        String resultat = metier1.get();
        assertThat(resultat).isNotBlank();
        assertThat(resultat).isEqualTo("metier 1 - p1");
    }
}
