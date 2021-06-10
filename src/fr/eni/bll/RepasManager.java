package fr.eni.bll;

import fr.eni.bo.Aliment;
import fr.eni.bo.Repas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RepasManager {
    /**
     * Construit puis donne le repas à la DAL
     *
     * @param date     récupérée par la Servlet
     * @param heure    récupérée par la Servlet
     * @param aliments chaine de caractères récupérée par la Servlet
     */
    public void ajouter(LocalDate date, LocalTime heure, String aliments) {
        // Transformons la chaine de caractère aliments en List<Aliment>
        String[] tabAliments = aliments.split(",");
        List<Aliment> listeAliments = new ArrayList<>();
        for (String nomAliment : tabAliments) {
            Aliment a = new Aliment(nomAliment.trim());
            listeAliments.add(a);
        }
        Repas r = new Repas(date, heure, listeAliments);
        RepasDAO rDAO = DAOFactory.getRepasDAO();
        rDAO.insert(r);
    }
}
