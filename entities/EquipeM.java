/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bezin
 */
public class EquipeM {
     int Capitain;
    public int id;
    public String nom;
    public int nbre_joueur;

    public EquipeM(int Capitain, int id, String nom, int nbre_joueur) {
        this.Capitain = Capitain;
        this.id = id;
        this.nom = nom;
        this.nbre_joueur = nbre_joueur;
    }

    public int getCapitain() {
        return Capitain;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbre_joueur() {
        return nbre_joueur;
    }

    public void setCapitain(int Capitain) {
        this.Capitain = Capitain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbre_joueur(int nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }

    @Override
    public String toString() {
        return "EquipeM{" + "Capitain=" + Capitain + ", id=" + id + ", nom=" + nom + ", nbre_joueur=" + nbre_joueur + '}';
    }
   
    
   

}
