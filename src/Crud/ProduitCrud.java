/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import entites.Produit ;
import tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ProduitCrud {
    
    
    
   
    
     public void add (Produit p) {    
 
          try {
            String requete="INSERT INTO produit(reference,designation,quantite,prix_uni) "
                    + "VALUES(?,?,?,?)";
                        PreparedStatement pst=
                                new MyConnection().cn.prepareStatement(requete);

  
     
                pst.setInt(1, p.getReference());
                   pst.setString(2, p.getDesignation());
                  
                       pst.setInt(3, p.getQuantite());
                       pst.setInt(4, p.getPrix_uni());
                  
                         
                       pst.executeUpdate();

           
            System.out.println("Produit ajoutée!");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     public void update (Produit p){   

        try {
             String requete="update  produit set  reference=?,designation=?,prix_unit=?, quantite=? where designation=? ";
             PreparedStatement pst=new MyConnection().cn.prepareStatement(requete);

                 
          pst.setInt(1, p.getReference());
            pst.setString(2, p.getDesignation());
         
            pst.setInt(3, p.getPrix_uni());
            pst.setInt(4, p.getQuantite());
            

            pst.execute();
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produit Update succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }  
     
public void Delete(Produit p){

    try {
            String requete="delete from produit where reference = ?";
            PreparedStatement pst=new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, p.getReference());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produit Delete succes");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }   
    
}
 
    

 

