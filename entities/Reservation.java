/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javafx.scene.control.Button;

/**
 *
 * @author bezin
 */
public class Reservation {
    private int id;
    private Date date_creation;
    private Date date_reservation;
    private int heure;
    private boolean validee;
    private Client client;
    private Terrain terrain;
    private double montant;
    private Button buttonEdit;
    private Button buttonSupp;
    private Button buttonAfficher;
    
    public Reservation() {
    }

    public Reservation(Date date_reservation, int heure, Client joueur, Terrain terrain, double montant) {
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = joueur;
        this.terrain = terrain;
        this.montant = montant;
        this.buttonAfficher= new Button("Editer");
        this.buttonEdit= new Button("Editer");
        this.buttonSupp= new Button("Supprimer");
    }
    public Reservation(int id, Date date_reservation, int heurs, Client joueur, Terrain terrain, double montant) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
        this.buttonAfficher= new Button("Editer");
        this.buttonEdit= new Button("Editer");
        this.buttonSupp= new Button("Supprimer");
    }

    public void setButtonEdit(Button button) {
        this.buttonEdit = button;
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public int getId() {
        return id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public Button getButtonSupp() {
        return buttonSupp;
    }

    public Button getButtonAfficher() {
        return buttonAfficher;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setButtonSupp(Button buttonSupp) {
        this.buttonSupp = buttonSupp;
    }

    public void setButtonAfficher(Button buttonAfficher) {
        this.buttonAfficher = buttonAfficher;
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

    public void setClient(Client joueur) {
        this.client = joueur;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    
}
