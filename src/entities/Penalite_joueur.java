/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Time;

/**
 *
 * @author ahmed
 */
public class Penalite_joueur {
    private int id;
    private Time heure;
    private Penalite penalite;
    private Arbitre arbitre;
    private Client joueur;
    private Matche matche;

    public Penalite_joueur(int id, Time heure, Penalite penalite, Arbitre arbitre, Client joueur, Matche matche) {
        this.id = id;
        this.heure = heure;
        this.penalite = penalite;
        this.arbitre = arbitre;
        this.joueur = joueur;
        this.matche = matche;
    }

    public int getId() {
        return id;
    }

    public Time getHeure() {
        return heure;
    }

    public Penalite getPenalite() {
        return penalite;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public Client getJoueur() {
        return joueur;
    }

    public Matche getMatche() {
        return matche;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public void setPenalite(Penalite penalite) {
        this.penalite = penalite;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    public void setJoueur(Client joueur) {
        this.joueur = joueur;
    }

    public void setMatche(Matche matche) {
        this.matche = matche;
    }

    
}
