package dev.repository;

import dev.dto.IngredientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {
    @Autowired
    IngredientRepository ingredientRepository;

    @Test
    void testFindByNom() {
        IngredientDto ingredients = ingredientRepository.findByNom("Poivre").orElseThrow(() -> new RuntimeException("Ingrédient non trouvé"));

        assertThat(ingredients.getId()).isEqualTo(13);

    }


}
