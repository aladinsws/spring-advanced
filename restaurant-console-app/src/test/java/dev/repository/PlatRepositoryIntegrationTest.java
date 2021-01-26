package dev.repository;

import dev.entite.Plat;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlatRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    PlatRepository platRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void testFindAll() {
        List<Plat> platList = platRepository.findAll();
        assertThat(platList).isNotEmpty();
    }


    @Test
    void testFindAllSortDesc() {
        List<Plat> plats = platRepository.findAll(
                Sort.sort(Plat.class)
                        .by(Plat::getPrixEnCentimesEuros)
                        .descending()
        );
//        List<Plat> plats = platRepository.findAll(Sort.by(Sort.Direction.DESC, "prixEnCentimesEuros"));
        assertThat(plats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros).reversed());
    }

    @Test
    void testFindAllPageable() {
        Page<Plat> plats = platRepository.findAll(PageRequest.of(0, 2, Sort.Direction.ASC, "nom"));
        assertThat(plats).extracting(Plat::getNom).contains("Blanquette de veau", "Couscous");
    }

    @Test
    void testFindById() {
        Plat plat = platRepository.findById(1).orElseThrow(() -> new RuntimeException("plat id=1 devrait exister"));
        assertThat(plat).hasFieldOrPropertyWithValue("nom", "Magret de canard");
    }

    @Test
    void testGetOne() {
        //EntityManager em;
        //em.getReference(Plat.class, 1);

        Plat plat = platRepository.getOne(1);
        assertThat(plat).hasFieldOrPropertyWithValue("nom", "Magret de canard");
    }


    @Test
    void testCount() {
        long count = platRepository.count();
        assertThat(count).isGreaterThanOrEqualTo(6);
    }

    @Test
    void testFindByPrix() {
        List<Plat> plats = platRepository.findByPrixEnCentimesEuros(1300);

        assertThat(plats).extracting(Plat::getNom).doesNotContain("Blanquette de veau", "Gigot d'agneau");
        assertThat(plats).extracting(Plat::getNom).contains("Magret de canard", "Moules-frites");
    }

    @Test
    void testAvgPrix() {
        Double avg = platRepository.findAvgByPrixEnCentimesEuros(1500);

        assertThat(avg).isGreaterThan(2000);
    }

    @Test
        //@Transactional
    void testFindByNomWithIngredients() {
        Plat plat = platRepository.findByNom("Moules-frites").orElseThrow(() -> new RuntimeException("Plat avec le nom Moules-frites non trouvé"));
        assertThat(plat.getIngredients()).hasSize(6);
    }

    @Test
    void testChangerNom() {
        String ancienNom = "Moules-frites";
        String nouveauNom = "Moules Frites";

        int nbLignesModifiees = platRepository.changerNom(ancienNom, "Moules Frites");

        assertThat(nbLignesModifiees).isEqualTo(1);
        String nomPlatBdd = jdbcTemplate.queryForObject("select nom from plat where plat.nom=?", String.class, nouveauNom);
        assertThat(nomPlatBdd).isEqualTo(nouveauNom);
    }


    @Test
    void testSave() {
        String nomPlat = RandomString.make();
        Plat nouveauPlat = new Plat(nomPlat, 1500);
        platRepository.save(nouveauPlat);
        String nomPlatBdd = jdbcTemplate.queryForObject("select nom from plat where plat.id=?", String.class, nouveauPlat.getId());
        assertThat(nomPlatBdd).isEqualTo(nomPlat);
    }

}
