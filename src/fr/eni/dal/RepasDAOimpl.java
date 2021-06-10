package fr.eni.dal;

import fr.eni.bo.Aliment;
import fr.eni.bo.Repas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
