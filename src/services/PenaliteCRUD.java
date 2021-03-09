/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Complexe;
import entities.Penalite;
import tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bezin
 */
public class PenaliteCRUD {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
    public void addPenalite(Penalite p){
        try {
            String req = "insert into penalite (designation, nbre_points_retires, complexe )"+ "values (?, ?, ?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, p.getDesignation());
            pst.setInt(2, p.getNbre_points_retires());
            pst.setInt(3, p.getComplexe());  
            pst.executeUpdate();
            System.out.println("Pénalité ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerPenalite (Penalite p) {
        try {
            String req = "delete from penalite where id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Pénalité supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } 
    }
    
    public void updatePenalite (Penalite p){
        try {
            String req = "update penalite set designation=?, nbre_points_retires=?, complexe=? where id=?";
            pst = cnx.prepareStatement(req);
            pst.setString(1, p.getDesignation());
            pst.setInt(2, p.getNbre_points_retires());
            pst.setInt(3, p.getComplexe());  
            pst.setInt(4, p.getId()); 
            pst.executeUpdate();
            System.out.println("Pénalité modifiée avec succes !");
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    
    public List<Penalite> afficherPenalites() {
         List<Penalite> penalitesList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM penalite";
            //Statement st = MyConnection.getInstance().getConnection().createStatement(requete);
            pst=cnx.prepareStatement(requete);
            
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                Penalite p = new Penalite();
                p.setId(rs.getInt(1));
                p.setDesignation(rs.getString(2));
                
                penalitesList.add(p);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return penalitesList;
    }
    
    
    public Penalite AfficherPenalite(int id){
        //List<Penalite> penalites = new ArrayList<>();
        Penalite p=new Penalite();
        try {
            //Statement st = cnx.createStatement();
            String req = "select * from penalite where id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            ResultSet res = pst.executeQuery();           
                p.setId(res.getInt("id"));
                p.setDesignation(res.getString("designation"));
                p.setNbre_points_retires(res.getInt("id"));
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return p;
    }
    
    public Penalite find(int id){
		Penalite p=null;
	String rsql="select * from penalite where id=?";
	try {
		PreparedStatement pst=cnx.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet rs=pst.executeQuery();
		if(rs.next())
                {
                    p = new Penalite(rs.getInt("id"), rs.getString("designation"), rs.getInt("nbre_points_retires"));
                }	
                rs.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return p;
	
	}
    
    public Collection<Penalite> findAll(){
		Penalite p=null;
                Collection<Penalite> penalitesList = new TreeSet<Penalite>();
	String rsql="select * from penalite";
	try {
		pst=cnx.prepareStatement(rsql);
	
		
		ResultSet rs=pst.executeQuery();
		while(rs.next())
                    penalitesList.add(new Penalite(rs.getInt("id"), rs.getString("designation"), rs.getInt("nbre_points_retires")));
			
                rs.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return penalitesList;
	
	} 
}
