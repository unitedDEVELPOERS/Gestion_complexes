/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Match;
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
public class PlanningCRUD {
     public void ajouter(Match mt ) {
       
        try {
            String requete = "INSERT INTO Arbitre (nom,prenom,categorie,complexe) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setInt(1, mt.getId());
            pst.setDate(2, mt.getDate_match());
            pst.setInt(3, mt.getResultat_eq1());
            pst.setInt(4, mt.getResultat_eq2());
            
            pst.executeUpdate();
            System.out.println("Match ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

    public static ObservableList<Match> afficher=() {
        ObservableList<Match> list = FXCollections.observableArrayList();
        String requete = "select * from matche";

        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Match(rs.getInt("id"), rs.getDate("date_match"),  rs.getString("resultat_eq1"),rs.getString("resultat_eq2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanningCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void modifier(Match mt) {
                try {
            String requete = "update matche set id = ?, date_match = ?, resultat_eq1 = ?, resultat_eq2= ? where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setint(1, mt.getId());
            pst.setDate(2, mt.getDate_match());
            pst.setInt(3, mt.getResultat_eq1());
            pst.setInt(4, mt.getResultat_eq2());
            

            pst.executeUpdate();
            System.out.println("Planning Modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    public void supprimer(int id){
                        try {
            String requete = "delete from matche where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("Panning Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(PlanningCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
