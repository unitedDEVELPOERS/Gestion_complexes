/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
public class AcceptationReservation {
    private int id;
    private Reservation reservation;
    private Client client;
    private boolean acceptee;

    public AcceptationReservation(int id, Reservation reservation, Client client, boolean acceptee) {
        this.id = id;
        this.reservation = reservation;
        this.client = client;
        this.acceptee=acceptee;
    }
    public AcceptationReservation(Reservation reservation, Client client, boolean acceptee) {        
        this.reservation = reservation;
        this.client = client;
        this.acceptee=acceptee;
    }

    public int getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Client getClient() {
        return client;
    }

    public boolean isAcceptee() {
        return acceptee;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAcceptee(boolean acceptee) {
        this.acceptee = acceptee;
    }
    
    
    
}
