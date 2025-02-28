package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import models.personne;
import connexionDb.mydatabase;

public class peersonnemetier {
    // Liste statique pour stocker les personnes
    private static List<personne> list = new ArrayList<>();

    public static List<personne> Listpersonnes() {
        list.clear(); // Vider la liste pour éviter les doublons
        String query = "SELECT * FROM personne";

        try {
            Statement stm = mydatabase.getConnextion().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int age = rs.getInt("age");
                list.add(new personne(id, nom, age));
            }
            System.out.println("Nombre de personnes récupérées: " + list.size()); // 🛠 DEBUG
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void ajouterpersonne(personne personne) {
        String query = "INSERT INTO personne (nom, age) VALUES(?, ?)";

        try {
            PreparedStatement prs = mydatabase.getConnextion().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, personne.getNom());
            prs.setInt(2, personne.getAge());
            prs.executeUpdate();

            // Récupérer l'ID généré
            ResultSet rs = prs.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                personne.setId(id); // Assigner l'ID généré
            }

            // Ajouter la personne à la liste
            list.add(personne);
            System.out.println("Personne ajoutée : " + personne.getNom());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerpersonne(int id) {
        String query = "DELETE FROM personne WHERE id = ?";

        try {
            PreparedStatement prs = mydatabase.getConnextion().prepareStatement(query);
            prs.setInt(1, id);
            int rowsAffected = prs.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Personne supprimée avec succès !");
                // Supprimer de la liste statique
                list.removeIf(p -> p.getId() == id);
            } else {
                System.out.println("Aucune personne trouvée avec l'ID : " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
