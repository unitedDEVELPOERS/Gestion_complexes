/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author ghara
 */
public class Arbitre extends User {

    String nom;
    String prenom;
   
    String matricule;
    String categorie;

    public Arbitre() {
        super(null, null);
    }
    public Arbitre(String email) {
        super(email);
    }
     
    
    
    
    
    
     public Arbitre(int idUser, String email, String pwd, String role,String telephone, String nom, String prenom,String matricule,String categorie) {
   
    super(idUser,email,pwd,role,telephone);
    this.nom=nom;
    this.prenom=prenom;
    this.matricule=matricule;
    this.categorie=categorie;
    
    
}
      public Arbitre(String email, String pwd, String role,String telephone, String nom, String prenom,String matricule,String categorie) {
   
    super(email,pwd,role,telephone);
    this.nom=nom;
    this.prenom=prenom;
    this.matricule=matricule;
    this.categorie=categorie;
    
    
}

    public Arbitre(String email,String telephone,String nom,String prenom,String categorie,String matricule) {
        super(email, telephone);
        this.nom=nom;
        this.prenom=prenom;
        this.categorie=categorie;
        this.matricule=matricule;
        
        
    }
     
     
     
     
     public Arbitre(String email, String pwd,String telephone, String nom, String prenom,String matricule,String categorie) {
   
    super(email,pwd,telephone);
    this.nom=nom;
    this.prenom=prenom;
    this.matricule=matricule;
    this.categorie=categorie;
    
}

    

    @Override
    public int getIdUser() {
        return idUser;
    }
 @Override
    public String getEmail() {
        return email;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getCategorie() {
        return categorie;
    }
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
 @Override
    public String getPwd() {
        return pwd;
    }
 @Override
    public String getTelephone() {
        return telephone;
    }
 @Override
    public String getRole() {
        return role;
    }
 @Override
    public void setEmail(String email) {
        this.email = email;
    }
 @Override
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
 @Override
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
 @Override
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + "nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + ", categorie=" + categorie + '}';
    }
     
    
     
     
     
     
     
     
     
}

  
