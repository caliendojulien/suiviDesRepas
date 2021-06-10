package fr.eni.bo;

import lombok.Getter;
import lombok.Setter;

public class Aliment {
    @Getter
    @Setter
    private int id;
    @Getter
    private String nom;

    public Aliment(String nom) {
        this.nom = nom;
    }
}
