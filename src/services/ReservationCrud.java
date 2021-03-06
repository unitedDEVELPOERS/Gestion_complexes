/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Complexe;
import entities.Client;
import entities.Penalite;
import entities.Reservation;
import entities.Terrain;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import tools.MyConnection;

/**
 *
 * @author ahmed
 */
public class ReservationCrud {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
   // ClientCrud cCrud = new ClientCrud();
    TerrainCrud tCrud = new TerrainCrud();
    Client j = new Client(6) ;
    Terrain t= new Terrain(2,"terrain foot", "terrain premier crée");
    public void addReservation(Reservation r){
        
        
        try {
            String req = "insert into reservation (date_reservation,heure, validee, client, terrain, montant)"+ "values (?, ?, ?, ?, ?, ?)";
            pst = cnx.prepareStatement(req);
            pst.setDate(1, r.getDate_reservation());        
            pst.setInt(2, r.getHeure());
            pst.setBoolean(3, r.isValidee());           
            pst.setInt(4, r.getClient().getId());
            pst.setInt(5, r.getTerrain().getId());           
            pst.setDouble(6, r.getMontant());
            pst.executeUpdate();
            System.out.println("Reservation ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierReservation(Reservation r){
        
        try {
            String req = "update reservation set date_reservation=?, validee=?, client=?, terrain=?, montant=? where id=?";
            pst = cnx.prepareStatement(req);           
            pst.setDate(1, r.getDate_reservation());
            pst.setBoolean(2, r.isValidee());           
//            pst.setInt(3, r.getJoueur().getId());
//            pst.setInt(4, r.getTerrain().getId());
pst.setInt(4, r.getClient().getId());
            pst.setInt(5, r.getTerrain().getId());
            pst.setDouble(5, r.getMontant());
            pst.setInt(6, r.getId());
            pst.executeUpdate();
            System.out.println("Reservation modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerReservation (Reservation r) {
        try {
            String req = "delete from reservation where id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            System.out.println("Réservation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } 
    }
    
    public ObservableList<Reservation> afficherReservations(){
       ObservableList reservations = FXCollections.observableArrayList();
       
       try{
           String req = "select * from reservation";        
           pst = cnx.prepareStatement(req);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               t=tCrud.find(res.getInt(6));
               Client cl=new Client (6);
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getInt(4), cl, t, res.getDouble(7)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherResTerrain(Terrain t){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getInt(4), j, t, res.getDouble(7)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public List<Reservation> afficherResheure(int heure){
       List reservations = new ArrayList();
       try{
           String req = "select * from reservation where heure=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, heure);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getInt(4), j, t, res.getDouble(7)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public ObservableList<Reservation> afficherResComplexe(Complexe c){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain in (select id from terrain where complexe=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, c.getId());
           ResultSet res = pst.executeQuery();
           while(res.next()){
              reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getInt(4), j, t, res.getDouble(7)));
            }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public ObservableList<Reservation> affResDateTime(Terrain t, Date d ){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain=? and date_reservation!= ?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           pst.setDate(2, d);
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getInt(4), j, t, res.getDouble(7)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public List<String> affHeuresRes(Terrain t){
       List<String> reservations = new ArrayList();
       try{
           String req = "select heure from reservation where terrain=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(res.getString("heure"));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public List<String> affHeuresTerrainDate(Terrain t, Date d){
       List<String> reservations = new ArrayList();
       try{
           String req = "select heure from reservation where terrain=? and date_reservation=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           pst.setDate(2, (java.sql.Date)d);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(res.getString("heure"));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
}
