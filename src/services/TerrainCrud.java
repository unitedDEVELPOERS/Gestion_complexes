/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import entities.Complexe;
import entities.Terrain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.util.calendar.BaseCalendar.Date;
import tools.MyConnection;

/**
 *
 * @author ahmed
 */
public class TerrainCrud {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
    private Statement st;
    CategorieCrud cc = new CategorieCrud();
        Categorie c=null;
        ComplexeCrud comc= new ComplexeCrud();
        Complexe complexe=null;
    
    public TerrainCrud(){
        try{
            st=cnx.createStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public void ajouterTerrain(Terrain t){
        try {
            String req = "insert into terrain (designation, description, adresse, image, prix_location,"+
                    "complexe, categorie, heure_ouverture, heure_fermeture)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, t.getDesignation());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getImage());
            pst.setDouble(5, t.getPrix_location());
            pst.setInt(6, t.getComplexe().getId());
            pst.setInt(7, t.getCategorie().getId());
            pst.setString(8, t.getHeure_ouverture());
            pst.setString(9, t.getHeure_fermeture());
            //java.util.Date d = new java.util.Date();
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//            LocalDateTime now = LocalDateTime.now();
//            java.sql.Date sd = new java.sql.Date(d.getTime());
//            pst.setTimestamp(10, sd);
            pst.executeUpdate();
            System.out.println("Terrain ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerTerrain (Terrain t) {
        try {
            String req = "delete from Terrain where id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Terrain supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } 
    }
    
    public void modifierTerrain (Terrain t){
        try {
            String req = "update Terrain set designation=?, description=?, adresse=?, image=?, prix_location=?,"+
                    "complexe=?, categorie=?, heure_ouverture=?, heure_fermeture=?  where id=?";
            pst = cnx.prepareStatement(req);
            pst.setString(1, t.getDesignation());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getImage());
            pst.setDouble(5, t.getPrix_location());
            pst.setInt(6, t.getComplexe().getId());
            pst.setInt(7, t.getCategorie().getId());
            pst.setString(8, t.getHeure_ouverture());
            pst.setString(9, t.getHeure_fermeture());
            pst.setInt(10, t.getId());
            pst.executeUpdate();
            System.out.println("Terrain modifié avec succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ObservableList<Terrain> getAll()  {
        
        
            ObservableList terrains = FXCollections.observableArrayList();
       try{
           String req = "select * from terrain";        
           pst = cnx.prepareStatement(req);
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                int id = rs.getInt(1);
                String designation = rs.getString("designation");
                String desc = rs.getString(3);
                // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;
        
    }
    
    public ObservableList<Terrain> getAllComp(int id)  {
        
        
            ObservableList terrains = FXCollections.observableArrayList();
       try{
           String req = "select * from terrain where complexe=?"; 
           pst = cnx.prepareStatement(req);
           pst.setInt(1, id);          
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;
        
    }
    
    public Terrain find(int id){
		Terrain t=null;
	String rsql="select * from terrain where id=?";
	try {
		PreparedStatement pst=cnx.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet rs=pst.executeQuery();
		if(rs.next())
                {
                    t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                
                }	
                rs.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return t;
	
	}
    
    
    public List<Terrain> fetch()  {
        
        
            List<Terrain> terrains = new ArrayList();
       try{
           String req = "select * from terrain";        
           pst = cnx.prepareStatement(req);
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                int id = rs.getInt(1);
                String designation = rs.getString("designation");
                String desc = rs.getString(3);
                // System.out.println(" id :" + id + " nom :" + nom + " prenom :" + prenom);
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;
        
    }
    
    public ObservableList<Terrain> getAllCompCategorie(int id, Categorie c)  {
        
        
            ObservableList terrains = FXCollections.observableArrayList();
       try{
           String req = "select * from terrain where complexe=? and categorie=?"; 
           pst = cnx.prepareStatement(req);
           pst.setInt(1, id);          
           pst.setInt(2, c.getId());          
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;
        
    }
    
    public ObservableList<Terrain> getAllVilleCategorie(String ville, Categorie c)  {
        ObservableList terrains = FXCollections.observableArrayList();
        try{
           String req = "select * from terrain where adresse like ? and categorie=?"; 
           pst = cnx.prepareStatement(req);
           pst.setString(1, ville);          
           pst.setInt(2, c.getId());          
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;
        
    }
    
    public ObservableList<Terrain> getAllCategorie(Categorie c)  {
        ObservableList terrains = FXCollections.observableArrayList();
        try{
           String req = "select * from terrain where categorie=?"; 
           pst = cnx.prepareStatement(req);               
           pst.setInt(1, c.getId());          
           ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 c=cc.find(rs.getInt(9));
                complexe=comc.Affichercomplexe(rs.getInt(8));
                Terrain t=new Terrain(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(7), complexe, c, rs.getString(10), rs.getString(11));
                terrains.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return terrains;        
    }
    
    
}
