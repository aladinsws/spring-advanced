package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Primary => qui gagne en cas d'ambiguïté
public class PlatServiceVersion1 implements IPlatService {

    // 2. Injection par champs
    // PlatServiceVersion1 p = new PlatServiceVersion1();
    // p.dao = context.getBean(IPlatDao.class)
    // @Autowired
    private IPlatDao dao;

    // 1. Injection par constructeur
    // @Autowired plus nécessaire
    public PlatServiceVersion1(IPlatDao dao) {
        this.dao = dao;
    }

    // 3. Injection par setter
//    @Autowired
//    public void setDao(IPlatDao dao) {
//        this.dao = dao;
//    }

    @Override
    public List<Plat> listerPlats() {
        return dao.listerPlats();
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // règle métier

        if (nomPlat.length() <= 3) {
            throw new PlatException("un plat doit avoir un nom de plus de 3 caractères");
        }

        if (prixPlat <= 500) {
            throw new PlatException("le prix d'un plat doit être supérieur à 5 €");
        }

        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlat, prixPlat);
    }
}
