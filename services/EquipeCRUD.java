/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.equipe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author bezin
 */
public class EquipeCRUD {
    public ObservableList<equipe> getAll(){
       ObservableList cat = FXCollections.observableArrayList();
       try{
//           String req = "select * from categorie";        
//           pst = cn.prepareStatement(req);
//           ResultSet res = pst.executeQuery();
            String requet="select  * from equipe";
            PreparedStatement pst =new MyConnection().cn.prepareStatement(requet);
//            String req = "select * from categorie";
//            pst = cn.prepareStatement(req);
            ResultSet res = pst.executeQuery(requet);
           while(res.next()){
               cat.add(new equipe(res.getInt(1),res.getString(2)));
           }
           
           
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       return cat;
    }
    

    
    public equipe find(int id){
		equipe p=null;
	String rsql="select * from equipe where id=?";
	try {
            PreparedStatement pst =new MyConnection().cn.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet res=pst.executeQuery();
		if(res.next())
                {
                    p = new equipe(res.getInt(1),res.getString(2));
                }	
                res.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return p;
	
	}
}
