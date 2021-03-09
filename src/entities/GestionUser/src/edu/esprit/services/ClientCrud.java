/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Arbitre;
import edu.esprit.entities.Client;
import edu.esprit.entities.User;
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
public class ClientCrud implements Service<Client>{
    
     private   Connection con=MyConnection.getInstance().getConnection();
    private Statement ste;
  
    
    public ClientCrud(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
    
    
    

    @Override
    public void ajouter(Client t) throws SQLException {
        
        
        String req2="INSERT INTO `utilisateur` (`email`,`password`,`telephone`,`nom`,`prenom`,`position`,`equipe`) VALUES('"+t.getEmail()+"','"+t.getPwd()+"','"+t.getTelephone()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getPosition()+"','"+t.getEquipe()+"');";
      ste.executeUpdate(req2);
      
        }

    @Override
    public void supprimer(Client t) throws SQLException {
        
       
     String sql = "DELETE FROM `utilisateur` WHERE email = '"+t.getEmail()+"'";
      ste.executeUpdate(sql); 
      
        
    }

    @Override
    public void update(Client t) throws SQLException {
        
       
        
        
    String sql="UPDATE `utilisateur` SET password='"+t.getPwd()+"',telephone='"+t.getTelephone()+"',nom='"+t.getNom()+"', prenom='"+t.getPrenom()+"', equipe='"+t.getEquipe()+"', position='"+t.getPosition()+"'WHERE email='"+t.getEmail()+"';";
     ste.executeUpdate(sql);   
    
    }

    @Override
    public ObservableList<Client> readAll() throws SQLException {
        ObservableList<Client> list = FXCollections.observableArrayList();
        String req="SELECT * FROM utilisateur";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
            String equipe=rs.getString(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
            
            Client a=new Client(email,pwd,telephone,nom,prenom,equipe,soldeP,position);
            list.add(a);
        }return list;    
    
    
    
    }
    
    
}
