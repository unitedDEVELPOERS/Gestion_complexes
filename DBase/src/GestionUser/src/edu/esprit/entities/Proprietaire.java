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
public class Proprietaire extends User {
    
    String matricule;
    String raison;
    boolean verifie=false;

    public Proprietaire() {
        super(null, null);
    }
     public Proprietaire(String email) {
        super(email);
    }

    
    
    
public Proprietaire(String email, String pwd,String telephone,String raison,String matricule,boolean verifie){
    super(email,pwd,telephone);
    this.matricule=matricule;
    this.raison=raison; 
    this.verifie=verifie;
} 
public Proprietaire(String email, String pwd,String telephone,String raison,String matricule){
    super(email,pwd,telephone);
    this.matricule=matricule;
    this.raison=raison; 
    
} 
public Proprietaire(String pwd,String telephone,String raison,String matricule){
    super(pwd,telephone);
    this.matricule=matricule;
    this.raison=raison; 
    
} 
    
    public Proprietaire(int idUser,String email, String pwd,String telephone ,String role,String raison,String matricule,boolean verifie){
        super(idUser,email,pwd,role,telephone);
        this.matricule=matricule;
        this.raison=raison; 
         this.verifie=verifie;
       
    }

    

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int getIdUser() {
        return super.getIdUser(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMatricule() {
        return matricule;
    }

    @Override
    public String getPwd() {
        return super.getPwd(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRaison() {
        return raison;
    }

    @Override
    public String getRole() {
        return super.getRole(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelephone() {
        return super.getTelephone(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getVerifie(){
        return verifie;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdUser(int idUser) {
        super.setIdUser(idUser); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public void setPwd(String pwd) {
        super.setPwd(pwd); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Override
    public void setTelephone(String telephone) {
        super.setTelephone(telephone); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVerifie(boolean verifie) {
        this.verifie = verifie;
    }

    @Override
    public void setRole(String role) {
        super.setRole(role); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString()+ "matricule=" + matricule + ", raison=" + raison + ", verifie=" + verifie + '}';
    }
    

    
    
    

    
    
  
    
    
   
    
    
    
    
    
}