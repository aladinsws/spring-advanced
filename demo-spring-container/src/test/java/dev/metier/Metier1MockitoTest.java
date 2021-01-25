package dev.metier;


import dev.persistance.Persistance1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Metier1MockitoTest {

    @InjectMocks
    Metier1 metier1; // Metier1 + Persistance1

    @Mock
    Persistance1 persistance1;
    
    @Test
    void get() {
        when(persistance1.get()).thenReturn("p1");

        String resultat = metier1.get();
        assertThat(resultat).isNotBlank();
        assertThat(resultat).isEqualTo("metier 1 - p1");
    }
}
