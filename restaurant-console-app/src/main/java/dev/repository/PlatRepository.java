package dev.repository;

import dev.entite.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Integer> {

    // select p from Plat p where p.nom=? and p.prix = ?
    List<Plat> findByNomAndPrixEnCentimesEuros(String nom, Integer prix);
    

}
