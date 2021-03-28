/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.time.LocalTime;
import javafx.scene.control.Button;

/**
 *
 * @author ahmed
 */
public class Reservation {

    private int id;
    private Date date_creation;
    private Date date_reservation;
    private LocalTime heure;
    private boolean validee;
    private Client client;
    private Terrain terrain;
    private double montant;
    private boolean confirmee;
    
    
    public Reservation() {
    }

    public Reservation(Date date_reservation, LocalTime heure, Client client, Terrain terrain, double montant) {
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
       
    }
    public Reservation(int id, Date date_reservation, LocalTime heure,boolean validee, Client client, Terrain terrain, double montant) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }
    public Reservation(int id, Date date_reservation, LocalTime heure,boolean validee, Client client, Terrain terrain, double montant,boolean confirmee) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
        this.confirmee = confirmee;
    }
    public Reservation(Date date_reservation, LocalTime heure,boolean validee, Client client, Terrain terrain, double montant) {
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }
    
    public Reservation(int id,Date date_creation, Date date_reservation, LocalTime heure, Client client, Terrain terrain, double montant) {
        this.id = id;
        this.date_creation=date_creation;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }

   

    public int getId() {
        return id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

   
    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    

    public Date getDate_reservation() {
        return date_reservation;
    }

    public boolean isValidee() {
        
        return validee;
    }

    public Client getClient() {
        return client;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public double getMontant() {
        return montant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isConfirmee() {
        return confirmee;
    }

    public void setConfirmee(boolean confirmee) {
        this.confirmee = confirmee;
    }
    
    
           

//    @Override
//    public String toString() {
//        return "Reservation{" + "id=" + id + ", date_creation=" + date_creation + ", date_reservation=" + date_reservation +", Heure= "+heure+ ", validee=" + validee + ", client=" + client + ", terrain=" + terrain + ", montant=" + montant + '}';
//    }
    
    
    @Override
    public String toString() {
        return  client.getNom()+" "+client.getPrenom()+" vous invite à un match le " + date_reservation + "\nà "+heure+ " au "+ terrain ;
    }
    
    
    
}
