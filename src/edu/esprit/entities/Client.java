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

public class Client extends User{

    String nom;
    String prenom;
    int solde_points;
    String position;
    
    int equipe;

    public Client() {
        super(null, null);
    }
     public Client(String email) {
        super(email);
    }
    public Client(String email,String pwd) {
        super(email, pwd);
    }
    
   public Client(int idUser){
       super(idUser);
   } 
    
  
public Client(int idUser, String email, String pwd, String role, String telephone,String nom, 
        String prenom, int solde_points, String position,int equipe) {
      
      super(idUser,email,pwd,role,telephone);
      this.equipe=equipe;
      this.nom=nom;
      this.prenom=prenom;
      this.position=position;
      this.solde_points=solde_points;
     
} 



       public Client(int idUser,String email, String pwd,String telephone, String nom, String prenom,int equipe,int solde_points,
               String position) {
        super(idUser,email,pwd,telephone);
      
        this.equipe=equipe;
      this.nom=nom;
      this.prenom=prenom;
      this.position=position;
      this.solde_points=solde_points;
       }
       
    
     public Client(int idUser, String email ,String pwd,String telephone,String nom,String prenom,int equipe,String position){
         super(idUser,email,pwd,telephone);
         this.nom=nom;
      this.prenom=prenom;
      this.position=position;
      this.equipe=equipe;
     }
     public Client(String email ,String pwd,String telephone,String nom,String prenom,String position){
         super(email,pwd,telephone);
         this.nom=nom;
      this.prenom=prenom;
      this.position=position;
    }

    private Client(int idUser, String email, String pwd, String telephone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEquipe() {
        return equipe;
    }

    @Override
    public int getIdUser() {
        return super.getIdUser(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public String getPosition() {
        return position;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String getPwd() {
        return super.getPwd(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRole() {
        return super.getRole(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSolde_points() {
        return solde_points;
    }

    @Override
    public String getTelephone() {
        return super.getTelephone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    @Override
    public void setIdUser(int idUser) {
        super.setIdUser(idUser); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public void setPwd(String pwd) {
        super.setPwd(pwd); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRole(String role) {
        super.setRole(role); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSolde_points(int solde_points) {
        this.solde_points = solde_points;
    }

    @Override
    public void setTelephone(String telephone) {
        super.setTelephone(telephone); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
//    public String toString() {
//        
//        return super.toString() + "nom=" + nom + ", prenom=" + prenom + ", solde_points=" + solde_points + ", position=" + position + ", telephone=" + telephone + ", equipe=" + equipe ;
//    }
    public String toString() {
        
        return nom +" "+  prenom  ;
    }

    

   
  


}
    
    
    
    
    
    
    
    
    
    

