/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author ahmed
 */
public class CategorieCrud {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
    ObservableList cat = FXCollections.observableArrayList();
    
//    public ObservableList<String> AfficherCategories(){        
//        ObservableList<String> listacombo= FXCollections.observableArrayList();
//        try {
//            String req = "select * from categorie";
//            pst = cnx.prepareStatement(req);
//            ResultSet res = pst.executeQuery(req);
//            while(res.next()){
//                Categorie c = new Categorie();                
//                c.setId(res.getInt("id"));
//                c.setDesignation(res.getString("designation"));                
//                //categories.add(c);
//                listacombo.add(res.getString("designation"));
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());        }
//        return listacombo;
//    }
    
    public ObservableList<Categorie> getAll(){
       
       try{
           String req = "select * from categorie";        
           pst = cnx.prepareStatement(req);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               cat.add(new Categorie(res.getInt(1),res.getString(2)));
           }
           
           
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       return cat;
    }
    
//    public Categorie AfficherCategorie(int id){
//        Categorie c =null;
//        
//        try {
//            String req = "select * from categorie where id =?";
//            pst = cnx.prepareStatement(req);
//            pst.setInt(1, id); 
//            ResultSet res = pst.executeQuery();
//            c = new Categorie(res.getInt(1),res.getString(2));
//            
//            
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());        }
//        return c;
//    }
    
    
    public Categorie find(int id){
		Categorie p=null;
	String rsql="select * from categorie where id=?";
	try {
		PreparedStatement pst=cnx.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet res=pst.executeQuery();
		if(res.next())
                {
                    p = new Categorie(res.getInt(1),res.getString(2));
                }	
                res.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return p;
	
	}
    
    
}
