/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Arbitre;
import entities.Utilisateurs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author bezin
 */
public class ArbitreCRUD {
    public void ajouterArbitre(Arbitre arb, int u) {
        UserCRUD uc = new UserCRUD();
        try {
            String requete = "INSERT INTO Arbitre (nom,prenom,categorie,complexe) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setString(1, arb.getNom());
            pst.setString(2, arb.getPrenom());
            pst.setInt(3, arb.getCategorie());
            pst.setInt(4, arb.getComplexe());
            pst.setInt(5, arb.getId_utilisateur());
            pst.executeUpdate();
            System.out.println("Arbitre ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

    public static ObservableList<Arbitre> afficherArbitre() {
        ObservableList<Arbitre> list = FXCollections.observableArrayList();
        String requete = "select * from arbitre";

        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Arbitre(rs.getInt("id"), rs.getString("nom"),  rs.getString("prenom"), rs.getInt("categorie")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void modifierArbitre(Arbitre arb) {
                try {
            String requete = "update Arbitre set nom = ?,prenom = ?, categorie = ?, complexe= ? where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setString(1, arb.getNom());
            pst.setString(2, arb.getPrenom());
            pst.setInt(3, arb.getCategorie());
            pst.setInt(4, arb.getComplexe());
            

            pst.executeUpdate();
            System.out.println("Arbitre Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    public void supprimerArbitre(int id){
                        try {
            String requete = "delete from arbitre where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("Arbitre Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}


