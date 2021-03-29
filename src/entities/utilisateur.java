/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author fachr
 */
public class utilisateur {
    public int id,equipe;
    public int position_equipe;

    public int getPosition_equipe() {
        return position_equipe;
    }

    public void setPosition_equipe(int position_equipe) {
        this.position_equipe = position_equipe;
    }
    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }
    public String nom,prenom,email,password,position;
     public utilisateur(int id,String nom,String prenom,String email,String position){
        this.id=id;
         this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.position=position;
        
    }
       public utilisateur(int id,String nom,String prenom,int equipe,String email,String position){
        this.id=id;
         this.nom=nom;
         this.equipe=equipe;
        this.prenom=prenom;
        this.email=email;
        this.position=position;
        
    }
         public utilisateur(int id,String nom,String prenom,int equipe,String email,String position,int position_equipe){
        this.id=id;
         this.nom=nom;
         this.equipe=equipe;
        this.prenom=prenom;
        this.email=email;
        this.position=position;
        this.position_equipe=position_equipe;
        
    }
    public utilisateur(String nom,String prenom,String email,String position){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.position=position;
        
    }

    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", position=" + position + '}';
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

   
}
