/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.AcceptationReservation;
import entities.Client;
import entities.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author ahmed
 */
public class AcceptationReservationCrud {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
    ClientCrud cCrud = new ClientCrud();
    ReservationCrud rc = new ReservationCrud();
    
    
    public void addConfirmation(AcceptationReservation accept){                
        try {
            String req = "insert into acceptation_reservation (reservation,client,acceptee)"+ "values (?, ?, ?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, accept.getReservation().getId());                             
            pst.setInt(2, accept.getClient().getIdUser());            
            pst.setBoolean(3, accept.isAcceptee());            
            pst.executeUpdate();
            System.out.println("Reservation ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierReservation(AcceptationReservation accept){
        
        try {
            String req = "update acceptation_reservation set reservation=?, client=?, acceptee=? where id=?";
            pst = cnx.prepareStatement(req);           
            pst.setInt(1, accept.getReservation().getId());                             
            pst.setInt(2, accept.getClient().getIdUser()); 
            pst.setBoolean(3, accept.isAcceptee());  
            pst.setInt(4, accept.getId());
            pst.executeUpdate();
            System.out.println("Reservation modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerReservation (AcceptationReservation accept) {
        try {
            String req = "delete from acceptation_reservation where id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, accept.getId());
            pst.executeUpdate();
            System.out.println("Réservation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } 
    }
    
    public ObservableList<AcceptationReservation> afficherAcceptations(){
       ObservableList acceptations = FXCollections.observableArrayList();
       
       try{
           String req = "select * from acceptation_reservation";        
           pst = cnx.prepareStatement(req);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Reservation rs = rc.find(res.getInt("reservation"));
               Client cl1 = cCrud.find(res.getInt("client"));
               acceptations.add(new AcceptationReservation(res.getInt(1), rs, cl1, res.getBoolean("acceptee")));
               
               System.out.println(res.getBoolean(5));
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return acceptations;
    }
    
    public ObservableList<AcceptationReservation> findReservation(Reservation r){
       ObservableList acceptations = FXCollections.observableArrayList();      
       try{
           String req = "select * from acceptation_reservation where reservation=?";        
           pst = cnx.prepareStatement(req);
            pst.setInt(1, r.getId());
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Reservation rs = rc.find(res.getInt("reservation"));
               Client cl1 = cCrud.find(res.getInt("client"));
               acceptations.add(new AcceptationReservation(res.getInt(1), rs, cl1, res.getBoolean("acceptee")));               
               System.out.println(res.getBoolean(5));
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return acceptations;
    }
    
//    public ObservableList<AcceptationReservation> findListAcceptReservation(Reservation r){
//      ObservableList acceptations = FXCollections.observableArrayList();      
//            
//       try{
//           String req = "select * from acceptation_reservation where reservation=?";        
//           pst = cnx.prepareStatement(req);
//            pst.setInt(1, r.getId());
//           ResultSet res = pst.executeQuery();
//           while(res.next()){
//               Reservation rs = rc.find(res.getInt("reservation"));
//               Client cl1 = cCrud.find(res.getInt("client"));
//               
//               acceptations.add(new AcceptationReservation(res.getInt(1), rs, cl1, res.getBoolean("acceptee")));               
//               System.out.println(res.getBoolean(5));
//           }           
//           } catch (SQLException ex) {
//               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
//           }
//       return acceptations;
//    }
//    
    public AcceptationReservation find(int id){
            AcceptationReservation a = null;
            
       try{
           String req = "select * from acceptation_reservation where id=?";        
           pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
           ResultSet res = pst.executeQuery();
           if(res.next()){
               Reservation rs = rc.find(res.getInt("reservation"));
               Client cl1 = cCrud.find(res.getInt("client"));
               
               a = new AcceptationReservation(res.getInt(1), rs, cl1, res.getBoolean("acceptee"));               
               System.out.println(res.getBoolean(5));
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return a;
    }
    public AcceptationReservation find(Reservation r, Client c){
            AcceptationReservation a = null;
            
       try{
           String req = "select * from acceptation_reservation where reservation=? and client=?";        
           pst = cnx.prepareStatement(req);
            pst.setInt(1, r.getId());
            pst.setInt(1, c.getIdUser());
           ResultSet res = pst.executeQuery();
           if(res.next()){
               Reservation rs = rc.find(res.getInt("reservation"));
               Client cl1 = cCrud.find(res.getInt("client"));
               
               a = new AcceptationReservation(res.getInt(1), rs, cl1, res.getBoolean("acceptee"));               
               System.out.println(res.getBoolean(5));
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return a;
    }
    
    
    public void check(Reservation r){
       try {
            String req = "delete from acceptation_reservation where reservation=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            System.out.println("Confirmation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } 
    }
}
