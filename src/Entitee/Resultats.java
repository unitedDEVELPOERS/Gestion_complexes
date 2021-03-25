/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitee;

/**
 *
 * @author user
 */
public class Resultats {
    private int id;
    private String nomeq;
    private int jouer;
    private int gagne;
    private int nulle;
    private int perdu;
    private int points;

    public Resultats() {
    }

    public Resultats(int id, String nomeq, int jouer, int gagne, int nulle, int perdu, int points) {
        this.id = id;
        this.nomeq = nomeq;
        this.jouer = jouer;
        this.gagne = gagne;
        this.nulle = nulle;
        this.perdu = perdu;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    public int getJouer() {
        return jouer;
    }

    public void setJouer(int jouer) {
        this.jouer = jouer;
    }

    public int getGagne() {
        return gagne;
    }

    public void setGagne(int gagne) {
        this.gagne = gagne;
    }

    public int getNulle() {
        return nulle;
    }

    public void setNulle(int nulle) {
        this.nulle = nulle;
    }

    public int getPerdu() {
        return perdu;
    }

    public void setPerdu(int perdu) {
        this.perdu = perdu;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
}
