package dev.demoboot.entite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plat")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @Column(name = "prix")
    private Integer prixEnCentimesEuros;

    @Transient
    private Integer prix;

    public Integer getPrix() {
        return prixEnCentimesEuros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plat() {
    }

    public Plat(String nom, Integer prixEnCentimesEuros) {
        this.nom = nom;
        this.prixEnCentimesEuros = prixEnCentimesEuros;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrixEnCentimesEuros() {
        return prixEnCentimesEuros;
    }

    public void setPrixEnCentimesEuros(Integer prixEnCentimesEuros) {
        this.prixEnCentimesEuros = prixEnCentimesEuros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return nom.equals(plat.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Plat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prixEnCentimesEuros=" + prixEnCentimesEuros +
                '}';
    }
}
