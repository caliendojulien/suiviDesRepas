package fr.eni.servlets;

import fr.eni.bll.RepasManager;
import fr.eni.bo.Repas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/historique")
public class Historique extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Repas> listeRepas = new ArrayList<>();
        // Je veux recupérer la liste des repas
        RepasManager repasManager = new RepasManager();
        listeRepas = repasManager.touslesrepas();
        req.setAttribute("listeDesRepas", listeRepas);
        req.getRequestDispatcher("WEB-INF/jsp/historique.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}