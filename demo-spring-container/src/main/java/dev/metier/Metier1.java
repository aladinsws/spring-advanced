package dev.metier;

import dev.persistance.IPersistance;

public class Metier1 implements IMetier {

    private IPersistance persitance;

    public Metier1(IPersistance persitance) {
        this.persitance = persitance;
    }

    public String get() {
        return "metier 1 - " + persitance.get();
    }


}
