/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Proprietaire;
import entities.Client;

import entities.Reservation;
import entities.Terrain;
import entities.User;
//import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
    ClientCrud cCrud = new ClientCrud();
    TerrainCrud tCrud = new TerrainCrud();
    //AcceptationReservationCrud arc = new AcceptationReservationCrud();
            
    Client c = new Client(31);
    Terrain t= new Terrain(2,"terrain foot", "terrain premier crée");
    
    public void addReservation(Reservation r){                
        try {
            String req = "insert into reservation (date_reservation,heure, validee, client, terrain, montant)"+ "values (?, ?, ?, ?, ?, ?)";
            pst = cnx.prepareStatement(req);
            pst.setDate(1, new java.sql.Date(r.getDate_reservation().getTime()));        
            pst.setTime(2, Time.valueOf(r.getHeure()));
            pst.setBoolean(3, r.isValidee());           
            pst.setInt(4, r.getClient().getIdUser());
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
            String req = "update reservation set date_reservation=?, heure=?, validee=?, client=?, terrain=?, montant=? where id=?";
            pst = cnx.prepareStatement(req);           
            pst.setDate(1, new java.sql.Date(r.getDate_reservation().getTime()));
            pst.setTime(2, Time.valueOf(r.getHeure()));
            pst.setBoolean(3, r.isValidee());           
            pst.setInt(4, r.getClient().getIdUser());
            pst.setInt(5, r.getTerrain().getId());           
            pst.setDouble(6, r.getMontant());
            pst.setInt(7, r.getId());
            pst.executeUpdate();
            System.out.println("Reservation modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerReservation (Reservation r) {
        AcceptationReservationCrud arc = new AcceptationReservationCrud();
        arc.check(r);
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
       check();
       try{
           String req = "select * from reservation";        
           pst = cnx.prepareStatement(req);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
               Client cl1 = cCrud.find(res.getInt("client"));
               System.out.println("kkk "+cl1);
               System.out.println(cl1.getIdUser());
               System.out.println(tr1);
               
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean(5), cl1, tr1, res.getDouble(8)));
          System.out.println(res.getBoolean(5));
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherResTerrain(Terrain tr1){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, tr1.getId());
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Client cl1 = cCrud.find(res.getInt("client"));
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherResEtat(int etat){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where validee=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, etat);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
              Client cl1 = cCrud.find(res.getInt("client"));
               
               
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherinvitations(Client client){
       ObservableList reservations = FXCollections.observableArrayList();
       check();
       try{
           String req = "select * from reservation where client in (select id from utilisateur where equipe =?) and id not in (select reservation from acceptation_reservation where client=?)  ";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, client.getEquipe());
           System.out.println(client.getEquipe());
           
           pst.setInt(2, client.getIdUser());
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
              Client cl1 = cCrud.find(res.getInt("client"));
               
               
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherResEquipe(Client client){
       ObservableList reservations = FXCollections.observableArrayList();
       check();
       try{
           //String req ="SELECT *FROM reservation WHERE client in (select id from utilisateur where equipe=?) and TIMEDIFF(CURTIME(), heure) > '00:30'";
          String req = "select * from reservation where client in (select id from utilisateur where equipe=?)";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, client.getEquipe());
           System.out.println(client.getEquipe());
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
              Client cl1 = cCrud.find(res.getInt("client"));

               System.out.println("**********");
               
               System.out.println(res.getTimestamp(2));
               
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public Reservation find(int id){
		Reservation r=null;
	String rsql="select * from reservation where id=?"; 
	try {
		PreparedStatement pst=cnx.prepareStatement(rsql);
		pst.setInt(1, id);
		
		ResultSet res=pst.executeQuery();
		if(res.next())
                {
                    Terrain tr1 = tCrud.find(res.getInt("terrain"));
                    Client cl1 = cCrud.find(res.getInt("client"));            
                    r = new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8));
                }	
                res.close();
		pst.close();
	} catch (SQLException e) {
		System.out.println("erreur"+e.getMessage());
	}
	return r;
	
	}
    
//    public List<Reservation> afficherResheure(int heure){
//       List reservations = new ArrayList();
//       try{
//           String req = "select * from reservation where heure=?";        
//           pst = cnx.prepareStatement(req);
//           pst.setInt(1, heure);
//           ResultSet res = pst.executeQuery();
//           while(res.next()){
//               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), c, t, res.getDouble(7)));
//           }
//           
//           
//        }   catch (SQLException ex) {
//            Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
//            }
//       return reservations;
//    }   
    
    public ObservableList<Reservation> afficherResComplexe(Proprietaire compl){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain in (select id from terrain where complexe=?)";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, compl.getIdUser());
           ResultSet res = pst.executeQuery();
           while(res.next()){
              Terrain tr1 = tCrud.find(res.getInt("terrain"));
                    Client cl1 = cCrud.find(res.getInt("client"));            
                    reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
                }
                      
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> afficherResClient(Client cli){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where client=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, cli.getIdUser());
           ResultSet res = pst.executeQuery();
           while(res.next()){
              reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cli, t, res.getDouble(8)));
            }
                      
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
      
    public ObservableList<Reservation> affResClientTerrain(Client cli , Terrain tr){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where client=? and terrain=?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, cli.getIdUser());
           pst.setInt(2, tr.getId());
           ResultSet res = pst.executeQuery();
           while(res.next()){
              reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cli, tr, res.getDouble(8)));
            }
                      
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
     
    public ObservableList<Reservation> affResDateTerrain(Terrain t, Date d ){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain=? and date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           pst.setDate(2, d);
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Client cl1 = cCrud.find(res.getInt("client"));
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, t, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public List<Reservation> affListResDateTerrain(Terrain t, Date d ){
       List reservations = new ArrayList();
       try{
           String req = "select * from reservation where terrain=? and date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           pst.setDate(2, d);
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Client cl1 = cCrud.find(res.getInt("client"));
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, t, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> affResComplexeDate(Proprietaire p, Date d ){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where terrain in ( select id from terrain where complexe=? )  and date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, p.getIdUser());
           pst.setDate(2, d);
           
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
               Client cl1 = cCrud.find(res.getInt("client"));
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    public ObservableList<Reservation> affResDate(Date d ){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setDate(1, d);                      
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
               Client cl1 = cCrud.find(res.getInt("client"));
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), cl1, tr1, res.getDouble(8)));
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
    
    public List<LocalTime> affHeuresTerrainDate(Terrain t, Date d){
       List<LocalTime> reserv = new ArrayList();
       try{
           String req = "select * from reservation where terrain=? and date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setInt(1, t.getId());
           pst.setDate(2, d);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reserv.add(res.getTime(4).toLocalTime());
           }
           
           
           } catch (SQLException ex) {
               System.out.println("services.ReservationCrud.affHeuresTerrainDate()");
           }
       return reserv;
    }
    
    
    
    public ObservableList<Reservation> affResClientDate(Client cli, Date d ){
       ObservableList reservations = FXCollections.observableArrayList();
       try{
           String req = "select * from reservation where date_reservation = ? and client = ?";        
           pst = cnx.prepareStatement(req);
           pst.setString(1, d.toString());                      
           pst.setInt(2, cli.getIdUser());                      
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean("validee"), c, t, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }
    
    
    public List<Reservation> getAll(String date ){
       List reservations = new ArrayList();
       try{
           String req = "select * from reservation where date_reservation = ?";        
           pst = cnx.prepareStatement(req);
           pst.setString(1, date);                                                    
           ResultSet res = pst.executeQuery();
           while(res.next()){
               reservations.add(new Reservation(res.getInt(1),res.getDate(2),res.getDate(3),res.getTime(4).toLocalTime(), c, t, res.getDouble(8)));
           }
           
           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       return reservations;
    }

    
    private void check(){
       try{
           String req = "SELECT * FROM reservation WHERE acceptee = 0 and TIMEDIFF(CURRENT_TIMESTAMP(), date_creation) > '00:10'";        
           pst = cnx.prepareStatement(req);
           ResultSet res = pst.executeQuery();
           while(res.next()){
               Terrain tr1 = tCrud.find(res.getInt("terrain"));
               Client cl1 = cCrud.find(res.getInt("client"));
               
               Reservation r1 = new Reservation(res.getInt(1),res.getDate(3),res.getTime(4).toLocalTime(),res.getBoolean(5), cl1, tr1, res.getDouble(8));
               //arc.check(r1);
               this.supprimerReservation(r1);
               
           }           
           } catch (SQLException ex) {
               Logger.getLogger(ReservationCrud.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       
    }
    
}
