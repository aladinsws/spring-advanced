package dev;

import dev.entite.Plat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoJpa {

    public static void main(String[] args) {

        // SessionFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-pu");
        // ??
        // gestionnaire d'entités
        // => outil de communication avec la base
        // Session
        // Cache de niveau 1
        EntityManager em = emf.createEntityManager();

        Plat platId1 = em.find(Plat.class, 1);

        Plat nouveauPlat = new Plat("JPA 1", 100);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // insert
        em.persist(nouveauPlat);

        tx.commit();
        System.out.println(platId1);

        // fin des échanges dans un contexte donné (traitement d'une requête http)
        em.close();


        // à la fin de l'app (fermeture de la boutique)
        emf.close();
    }
}
