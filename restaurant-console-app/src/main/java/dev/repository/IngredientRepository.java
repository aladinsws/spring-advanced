package dev.repository;

import dev.dto.IngredientDto;
import dev.entite.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    Optional<IngredientDto> findByNom(String nom);

}

