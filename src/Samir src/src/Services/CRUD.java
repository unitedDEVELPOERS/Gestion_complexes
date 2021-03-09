/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Categorie;
import Entitee.Competition;
import Entitee.Equipe;
import Entitee.participation;
import MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CRUD {
    
    
      CategorieCrud cc = new CategorieCrud();
        Categorie c=null;
   
    
     public void Add_COMP (Competition c) throws SQLException{    
 
         try {
            String requet="INSERT INTO competition(designation,date_debut,nbre_equipes,categorie,complexe,prix_participation)"+ "VALUES(?,?,?,?,?,?)";
                        PreparedStatement pst=new MyConnection().cn.prepareStatement(requet);

            pst.setString(1, c.getDesignation());
            pst.setString(2, c.getDate_debut());
            pst.setString(3, c.getNbre_equipes());
            pst.setInt(4, c.getCategorie().getId());
            pst.setString(5, c.getComplexe());
            pst.setString(6, c.getPrix_participation());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Competition Add succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void Edit (Competition u){   // il faut dajouer id pour where de la MAJ

 try {
             String requet="update  Competition set  designation=?, date_debut=?, nbre_equipes=?, complexe=? , prix_participation=? where designation=?" ;
             PreparedStatement pst=new MyConnection().cn.prepareStatement(requet);

                 
            pst.setString(1, u.getDesignation());
            pst.setString(2, u.getDate_debut());
            pst.setString(3, u.getNbre_equipes());
            pst.setString(4, u.getComplexe());
            pst.setString(5, u.getPrix_participation());
           
            pst.setString(6, u.getDesignation());         //pour where user id

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Competition Update succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }  
     
public void Delete(Competition c){

    try {
            String requet="delete from Competition where designation = ?";  //id pour where suppression
            PreparedStatement pst=new MyConnection().cn.prepareStatement(requet);
            pst.setString(1, c.getDesignation());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Competition Delete succes");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }     
     
     
    
    public  ObservableList<Competition> getDatacompetition(){
        
        ObservableList<Competition> list = FXCollections.observableArrayList();
        try {
            String requet="select  * from Competition";
            PreparedStatement ps =new MyConnection().cn.prepareStatement(requet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){   
                 
                c=cc.find(rs.getInt(6));
                
               list.add(new Competition(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString("prix_participation")));               
          
                     }
        } catch (Exception e) {
        }
        return list;
    }
   
 public List<String> AfficherCategories(){
        //ObservableList<Categorie> categories = FXCollections.observableArrayList();
//categories = FXCollections.observableArrayList();
        //Categorie c;
        
        
        
     ObservableList<String> listacombo= FXCollections.observableArrayList();

        try {
            String requet = "select * from categorie";
            PreparedStatement pst =new MyConnection().cn.prepareStatement(requet);

            ResultSet res = pst.executeQuery(requet);
            while(res.next()){
                Categorie c = new Categorie();                
                c.setId(res.getInt("id"));
                c.setDesignation(res.getString("designation"));   
                
                
                listacombo.add(res.getString("designation"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return listacombo;
    }
 
 
 
 
}
