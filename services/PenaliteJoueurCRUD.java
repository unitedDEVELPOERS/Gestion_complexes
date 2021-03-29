/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.PenaliteJoueur;
import entities.equipe;
import entities.matche;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import tools.MyConnection;

/**
 *
 * @author bezin
 */
public class PenaliteJoueurCRUD {
    private   Connection con=MyConnection.getInstance().getConnection();
    private Statement ste;
  
    EquipeCRUD a=new EquipeCRUD();
    equipe e=null;
    EquipeCRUD b=new EquipeCRUD();
    equipe e1=null;
   
    public void AjouterMatch(matche m ) {
//      UserCRUD uc = new UserCRUD();
//        try {
//            String requete = "INSERT INTO Matche (terrain,date_creation,equipe1,equipe2,resultat_eq1,resultat_eq2) "
//                    + "VALUES (?,?,?,?,?,?)";
//            PreparedStatement pst
//                    = new MyConnection().cn.prepareStatement(requete);
//
//            pst.setInt(1, m.getTerrain());
//            pst.setInt(2, m.getEquipe1());
//            pst.setInt(3, m.getEquipe2());
//            pst.setDate(4, m.getDate_match());
//            pst.setInt(5, m.getResultat_eq1());
//            pst.setInt(6, m.getResultat_eq2());
//           
//            pst.executeUpdate();
//            System.out.println("Resultat ajoutee !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());        }
//    }


//        public ObservableList<matche> AfficherMatche(){
//       
//        ObservableList<matche> list = FXCollections.observableArrayList();
//        String requete = "select * from matche";
//
//        try {
//            PreparedStatement pst
//                    = new MyConnection().cn.prepareStatement(requete);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                list.add(new matche(rs.getInt("id"), rs.getObject("equipe1"), rs.getInt("terrain"),  rs.getString("date_match"),  rs.getInt("resultat_eq1"),rs.getInt("resultat_eq2")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    }
    public void modifierResultat(PenaliteJoueur j) {
try {
            
             String requet="update  penalite_joueur set  id=?, joueur=?,penalite=? where id=? ";
             PreparedStatement pst=new MyConnection().cn.prepareStatement(requet);

            pst.setInt(1, j.getId());     
           
              pst.setInt(2, j.getJoueur1());

            pst.setInt(3, j.getPenalite1());
           
           

              
            
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resultat match Update succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    public void supprimerResultat(int id){
                        try {
            String requete = "delete from match where id = ?";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);

            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("Resultat Supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    public  ObservableList<PenaliteJoueur> AfficherMatche(){
        
        ObservableList<PenaliteJoueur> list = FXCollections.observableArrayList();
        try {
            String requet="select  * from penalite_joueur ";
            PreparedStatement ps =new MyConnection().cn.prepareStatement(requet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
             e=a.find(rs.getInt(5));
              e1=b.find(rs.getInt(3)); 
               
               
               list.add(new PenaliteJoueur(rs.getInt(1),e,e1));               
          
                     }
        } catch (Exception e) {
        }
        return list;
    }
    
    
}
