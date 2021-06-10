package fr.eni.servlets;

import fr.eni.bll.RepasManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/ajout")
public class Ajout extends HttpServlet {

    private RepasManager repasManager;

    @Override
    public void init() throws ServletException {
        this.repasManager = new RepasManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/ajout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des paramètres utilisateur
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        LocalTime heure = LocalTime.parse(req.getParameter("heure"));
        String aliments = req.getParameter("aliments");
        // Appel du manager
        repasManager.ajouter(date, heure, aliments);
        req.setAttribute("ajout", "Article ajouté");
        this.doGet(req, resp);
    }
}
