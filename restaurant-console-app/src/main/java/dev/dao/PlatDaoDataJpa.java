package dev.dao;

import dev.entite.Plat;
import dev.repository.PlatRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Profile("datajpa")
public class PlatDaoDataJpa implements IPlatDao {
    private PlatRepository platRepository;

    public PlatDaoDataJpa(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    @Override
    public List<Plat> listerPlats() {
        return platRepository.findAll();
    }

    @Override
    @Transactional
    public void ajouterPlat(String nomPlat, Integer prixPlat) {
        platRepository.save(new Plat(nomPlat, prixPlat)); // t1
//        platRepository.save(new Plat(nomPlat, prixPlat)); // t2
//        platRepository.save(new Plat(nomPlat, prixPlat)); // t3
    }
}
