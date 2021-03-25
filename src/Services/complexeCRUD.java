/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Categorie;
import Entitee.proprietaire_complexe;
import MyConnection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class complexeCRUD {
    public ObservableList<String> AfficherCategories(){
        
        ObservableList<String> listacombo= FXCollections.observableArrayList();

        try {
             String requet="select  * from categorie";
            PreparedStatement pst =new MyConnection().cn.prepareStatement(requet);
            ResultSet res = pst.executeQuery(requet);
            while(res.next()){
                Categorie c = new Categorie();                
                c.setId(res.getInt("id"));
                c.setDesignation(res.getString("designation"));                
                //categories.add(c);
                listacombo.add(res.getString("designation"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return listacombo;
    }
    
    public ObservableList<Categorie> getAll(){
       ObservableList cat = FXCollections.observableArrayList();
       try{
//           String req = "select * from categorie";        
//           pst = cn.prepareStatement(req);
//           ResultSet res = pst.executeQuery();
String requet="select  * from categorie";
            PreparedStatement pst =new MyConnection().cn.prepareStatement(requet);
//            String req = "select * from categorie";
//            pst = cn.prepareStatement(req);
            ResultSet res = pst.executeQuery(requet);
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
    
    
    public proprietaire_complexe findcomplexe(int id){
		proprietaire_complexe p=null;
	String rsql="select * from proprietaire_complexe where id=?";
	try {
            PreparedStatement pst =new MyConnection().cn.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet res=pst.executeQuery();
		if(res.next())
                {
                    p = new proprietaire_complexe(res.getInt(1),res.getString(2));
                }	
                res.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return p;
	
	}
    
}
