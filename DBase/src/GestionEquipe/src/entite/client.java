/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author fachr
 */
public class client {
    
    public int id ,solde_points=20;
    public String nom;
    public String prenom;
    public equipe equipe;
    public String position;
   public client(int id,String nom,String prenom,equipe equipe,String position){
       this.id=id;
       this.nom=nom;
       this.prenom=prenom;
       this.equipe=equipe;
       this.position=position;
   }
    public client (String nom,String prenom, String position){
        this.nom=nom;
        this.prenom=prenom;
        this.position=position;
        
    }

    public int getId() {
        return id;
    }

  
    public int getSolde_points() {
        return solde_points;
    }

    public void setSolde_points(int solde_points) {
        this.solde_points = solde_points;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(equipe equipe) {
        this.equipe = equipe;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "client{" + "id=" + id + ", solde_points=" + solde_points + ", nom=" + nom + ", prenom=" + prenom + ", equipe=" + equipe + ", position=" + position + '}';
    }
    
    
}
