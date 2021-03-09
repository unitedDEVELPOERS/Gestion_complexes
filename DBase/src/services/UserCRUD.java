/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class UserCRUD {
     public void ajouterUser(Utilisateurs user) {
        try {
            String requete = "INSERT INTO Utilisateur (email,password,role) "
                    + "VALUES (?,?,?)";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRole());
            pst.executeUpdate();
            System.out.println("Utilisateur ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<Utilisateurs> afficherUtilisateurs() {
        ObservableList<Utilisateurs> list = FXCollections.observableArrayList();
        String requete = "select * from Utilisateurs";

        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Utilisateurs(Integer.parseInt(rs.getString("id")), rs.getString("email"),  rs.getString("role")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void modifier(Utilisateurs user) {
                try {
            String requete = "update Utilisateur set email = ?,password = ?, role = ? where id=?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRole());
            pst.setInt(4, user.getId());
            
            

            pst.executeUpdate();
            System.out.println("Utilisateur Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    public void supprimer(Utilisateurs u){
                        try {
            String requete = "delete from Utilisateur where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setInt(1, u.getId());

            pst.executeUpdate();
            System.out.println("Utilisateurs Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

