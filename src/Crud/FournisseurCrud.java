/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import entites.Fournisseur;
import entites.Produit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tools.MyConnection;

/**
 *
 * @author Jawher
 */
public class FournisseurCrud {
         public void add_four (Fournisseur f) {    
 
          try {
            String requete="INSERT INTO fournisseur(nom,prenom,nom_entreprise,email,num_tel) "
                    + "VALUES(?,?,?,?,?)";
                        PreparedStatement pst=
                                new MyConnection().cn.prepareStatement(requete);

  
     
                pst.setString(1, f.getNom());
                   pst.setString(2, f.getPrenom());
                  
                       pst.setString(3, f.getEntreprise());
                       pst.setString(4, f.getEmail());
                       
                       pst.setInt(5, f.getNum_tel());
                  
                         
                       pst.executeUpdate();

           
            System.out.println("Fournisseur ajoutée!");
        } catch (SQLException ex) {
            Logger.getLogger(Crud.FournisseurCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
             public void update_four (Fournisseur f){   

        try {
             String requete="update  fournisseur set  nom=?,prenom=?,entreprise=?, email=? ,num_tel where nom=? ";
             PreparedStatement pst=new MyConnection().cn.prepareStatement(requete);

                 
       
     
                pst.setString(1, f.getNom());
                   pst.setString(2, f.getPrenom());
                  
                       pst.setString(3, f.getEntreprise());
                       pst.setString(4, f.getEmail());
                       
                       pst.setInt(5, f.getNum_tel());
                  
                         
                       pst.executeUpdate();
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fournisseur Update succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
             }
             public void Delete(Fournisseur f){

    try {
            String requete="delete from fournisseur where nom = ?";
            PreparedStatement pst=new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, f.getNom());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fourniseur Delete succes");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }  
             
             
             
}
