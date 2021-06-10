package fr.eni.bo;

import lombok.Getter;

public class Aliment {
    @Getter
    private int id;
    private String nom;

    public Aliment(String nom) {
        this.nom = nom;
    }
}
