package dev.hotel.entite;

import com.fasterxml.jackson.annotation.JsonView;
import dev.hotel.views.View;

import javax.persistence.Entity;

@Entity
public class Client extends BaseEntite {

    @JsonView(View.Synthetique.class)
    private String nom;

    @JsonView(View.Complete.class)
    private String prenoms;

    public Client() {
    }

    public Client(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }
}
