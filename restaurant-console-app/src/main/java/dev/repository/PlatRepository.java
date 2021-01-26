package dev.repository;


import dev.entite.Plat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PlatRepository extends JpaRepository<Plat, Integer> {


    List<Plat> findByPrixEnCentimesEuros(Integer prix);

    @Query(value = "select avg(p.prixEnCentimesEuros) from Plat p where p.prixEnCentimesEuros > :prix")
    Double findAvgByPrixEnCentimesEuros(@Param("prix") Integer prix);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "ingredients"
            }
    )
    Optional<Plat> findByNom(String nom);

    @Transactional
    @Modifying
    @Query("update Plat p set p.nom=:nouveauNom where p.nom=:ancienNom")
    int changerNom(@Param("ancienNom") String ancienNom, @Param("nouveauNom") String nouveauNom);

}

