/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Client;
import edu.esprit.entities.Proprietaire;
import edu.esprit.tools.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ghara
 */
public class ProprietaireCrud implements Service<Proprietaire>{

    private   Connection con=MyConnection.getInstance().getConnection();
    private Statement ste;
    //UserCrud cr=new UserCrud();
    
    public ProprietaireCrud(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
    
   
    @Override
    public void ajouter(Proprietaire p) throws SQLException {
         
        String req1="INSERT INTO `utilisateur` (`email`,`password`,`telephone`,`matricule_fiscale`,`raison_sociale`) VALUES('"+p.getEmail()+"','"+p.getPwd()+"','"+p.getTelephone()+"','"+p.getMatricule()+"','"+p.getRaison()+"');";
       
      ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(Proprietaire p) throws SQLException {
        
         String sql = "DELETE FROM `utilisateur` WHERE email = '"+p.getEmail()+"'";
      ste.executeUpdate(sql); 
     
        
    }
    

    @Override
    public void update(Proprietaire p) throws SQLException {
        String sql="UPDATE `utilisateur` SET password='"+p.getPwd()+"',telephone='"+p.getTelephone()+"',matricule_fiscale='"+p.getMatricule()+"', raison_sociale='"
                +p.getRaison()+"' WHERE email = '"+p.getEmail()+"';";
     ste.executeUpdate(sql);
    }

    @Override
    public ObservableList<Proprietaire> readAll() throws SQLException {
   ObservableList<Proprietaire> list = FXCollections.observableArrayList();
        String req="select * from utilisateur";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            String matricule=rs.getString(10);
            String raison=rs.getString(9); 
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String telephone=rs.getString(14);
            boolean verifie=rs.getBoolean(11);
            Proprietaire p1=new Proprietaire(email,pwd,telephone,raison,matricule,verifie);
            list.add(p1);
        }return list;    
    }}


 
   
    
    
    
    
    
    
