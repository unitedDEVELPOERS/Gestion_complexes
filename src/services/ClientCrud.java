/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Arbitre;
import entities.Client;
import entities.User;
import tools.MyConnection;
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
            int equipe=rs.getInt(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
            
            Client a=new Client(rs.getInt(1),email,pwd,telephone,nom,prenom,equipe,soldeP,position);
            list.add(a);
        }return list;    
    
    
    
    }
    
    public ObservableList<Client> readEquipe(int id) throws SQLException {
        ObservableList<Client> list = FXCollections.observableArrayList();
        String req="SELECT * FROM utilisateur where id = "+id;
        try{
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
           int equipe=rs.getInt(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
            
            Client a=new Client(rs.getInt(1),email,pwd,telephone,nom,prenom,equipe,soldeP,position);
            list.add(a);
        }
        } catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
        return list;    
    
    
    
    }
    //****
    public Client find(int id){
		Client a=null;
	String req="select * from utilisateur where id="+id;
	try {
		ResultSet rs=ste.executeQuery(req);
		
		
		if(rs.next())
                {
                    String email=rs.getString(2);
            String pwd=rs.getString(3);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
            int equipe=rs.getInt(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
                    
                    a=new Client(id,email,pwd,telephone,nom,prenom,equipe,soldeP,position);
                    System.out.println(a);
                }	
                
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return a;
	
	}
    
    public ObservableList<Client> getEquipe(int eq){
        ObservableList<Client> list = FXCollections.observableArrayList();
        String req="SELECT * FROM utilisateur where equipe = "+eq;
        try{
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
            int equipe=rs.getInt(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
            
            Client a=new Client(rs.getInt(1),email,pwd,telephone,nom,prenom,equipe,soldeP,position);
            list.add(a);
        }
        } catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
        return list;     
    }
    
    
    public List<Client> getListMembres(int eq){
        List<Client> list = new ArrayList();
        String req="SELECT * FROM utilisateur where equipe = "+eq;
        try{
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
            int equipe=rs.getInt(8);
            int soldeP=rs.getInt(12);
            String position=rs.getString(13);
            String telephone=rs.getString(14);
            
            Client a=new Client(rs.getInt(1),email,pwd,telephone,nom,prenom,equipe,soldeP,position);
            list.add(a);
        }
        } catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
        return list;     
    }
    
//    public ObservableList<Client> getMonEquipe(Client client) {
//        ObservableList<Client> list = FXCollections.observableArrayList();
//        String req="SELECT * FROM utilisateur where equipe = "+client.getEquipe();
//        try{
//        ResultSet rs=ste.executeQuery(req);
//        while(rs.next()){
//            
//            String email=rs.getString(2);
//            String pwd=rs.getString(3);
//            String nom=rs.getString(5);
//            String prenom=rs.getString(6);
//            int equipe=rs.getInt(8);
//            int soldeP=rs.getInt(12);
//            String position=rs.getString(13);
//            String telephone=rs.getString(14);
//            
//            Client a=new Client(rs.getInt(1),email,pwd,telephone,nom,prenom,equipe,soldeP,position);
//            list.add(a);
//        }
//        } catch (SQLException e) {
//		System.out.println("erreur"+e.getMessage());
//	}
//        return list;    
//    
//    
//    
//    }
//    
    
}
