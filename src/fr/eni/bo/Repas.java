package fr.eni.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Repas {
    @Getter
    @Setter
    private int id;
    @Getter
    private LocalDate date;
    @Getter
    private LocalTime heure;
    @Getter
    private List<Aliment> aliments;

    public Repas(LocalDate date, LocalTime heure, List<Aliment> aliments) {
        this.date = date;
        this.heure = heure;
        this.aliments = aliments;
    }
}
