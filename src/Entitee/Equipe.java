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
public class Equipe {
    private int id;
    private String nom;
    private int nbre_joueur;

    public Equipe(int id) {
        this.id = id;
    }

    public Equipe() {
    }

    public Equipe(String nom, int nbre_joueur) {
        this.nom = nom;
        this.nbre_joueur = nbre_joueur;
    }

    public Equipe(int id, String nom, int nbre_joueur) {
        this.id = id;
        this.nom = nom;
        this.nbre_joueur = nbre_joueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbre_joueur() {
        return nbre_joueur;
    }

    public void setNbre_joueur(int nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nom=" + nom + ", nbre_joueur=" + nbre_joueur + '}';
    }
    
}
