package fr.eni.dal;

import fr.eni.bo.Aliment;
import fr.eni.bo.Repas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepasDAOimpl implements RepasDAO {

    @Override
    public void insert(Repas repas) {
        String INSERT_REPAS = "INSERT INTO REPAS (date_repas, heure_repas) VALUES (?, ?);";
        String INSERT_ALIMENT = "INSERT INTO ALIMENTS (nom, id_repas) VALUES (?, ?);";
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement psmt = connection.prepareStatement(INSERT_REPAS,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement psmt2 = connection.prepareStatement(INSERT_ALIMENT,
                        PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            // J'insere le repas en base de données
            psmt.setDate(1, java.sql.Date.valueOf(repas.getDate()));
            psmt.setTime(2, java.sql.Time.valueOf(repas.getHeure()));
            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                repas.setId(rs.getInt(1));
            }
            // J'insère les aliments en base de données
            for (Aliment aliment : repas.getAliments()) {
                psmt2.setString(1, aliment.getNom());
                psmt2.setInt(2, repas.getId());
                psmt2.executeUpdate();
                ResultSet rs2 = psmt.getGeneratedKeys();
                if (rs.next()) {
                    aliment.setId(rs2.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Repas> selectAll() {
        List<Repas> listeRepas = new ArrayList<>();
        ;
        String SELECT_ALL = "SELECT r.id, r.date_repas, r.heure_repas, a.id, a.nom " +
                "FROM REPAS r " +
                "INNER JOIN ALIMENTS a " +
                "ON r.id=a.id_repas " +
                "ORDER BY r.date_repas DESC, r.heure_repas DESC";
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement psmt = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = psmt.executeQuery();
            Repas repasEncours = new Repas();
            while (rs.next()) {
                if (rs.getInt(1) != repasEncours.getId()) {
                    repasEncours = new Repas();
                    repasEncours.setId(rs.getInt(1));
                    repasEncours.setDate(rs.getDate(2).toLocalDate());
                    repasEncours.setHeure(rs.getTime(3).toLocalTime());
                    listeRepas.add(repasEncours);
                }
                Aliment aliment = new Aliment(
                        rs.getInt(4),
                        rs.getString(5));
                repasEncours.getAliments().add(aliment);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(listeRepas);
        return listeRepas;
    }
}
