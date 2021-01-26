package dev.dao;

import dev.entite.Plat;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Profile("jpa")
public class PlatDaoJpa implements IPlatDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Plat> listerPlats() {
        return em.createQuery("select p from Plat p", Plat.class).getResultList();
    }

    @Override
    @Transactional
    public void ajouterPlat(String nomPlat, Integer prixPlat) {
        em.persist(new Plat(nomPlat, prixPlat));
    }
}
