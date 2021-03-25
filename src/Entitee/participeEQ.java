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
public class participeEQ {
    private int id;
    private String nom;
    private String nbre_joueur;

    public participeEQ(int id, String nom, String nbre_joueur) {
        this.id = id;
        this.nom = nom;
        this.nbre_joueur = nbre_joueur;
    }

    public participeEQ() {
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

    public String getNbre_joueur() {
        return nbre_joueur;
    }

    public void setNbre_joueur(String nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }

    @Override
    public String toString() {
        return "participeEQ{" + "id=" + id + ", nom=" + nom + ", nbre_joueur=" + nbre_joueur + '}';
    }

    
}
