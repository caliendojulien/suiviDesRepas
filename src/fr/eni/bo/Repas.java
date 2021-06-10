package fr.eni.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Repas {
    private int id;
    private LocalDate date;
    private LocalTime heure;
    private List<Aliment> aliments;

    public Repas(LocalDate date, LocalTime heure, List<Aliment> aliments) {
        this.date = date;
        this.heure = heure;
        this.aliments = aliments;
    }
}
