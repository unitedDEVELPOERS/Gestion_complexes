/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ghara
 */

public class User{
    int idUser;
    String email;
    String pwd;
    String role;
    String telephone;
    
    
    

    public User(String email,String pwd) {
        this.email=email;
        this.pwd=pwd;
    }


    public User() {
    }
     public User(String email) {
         this.email=email;
    }
     
    public User(int idUser) {
         this.idUser=idUser;
    }

    public User(int idUser,String email,String pwd,String role,String telephone) {
        this.idUser=idUser;
        this.email=email;
        this.pwd=pwd;
        this.role=role;
        this.telephone=telephone;
    }
    public User(String email,String pwd,String role,String telephone) {
        
        this.email=email;
        this.pwd=pwd;
        this.role=role;
        this.telephone=telephone;
    }
     public User(int idUser, String email,String pwd,String telephone) {
        this.idUser=idUser;
        this.email=email;
        this.pwd=pwd;
        this.role=role;
        this.telephone=telephone;
    }
     public User( String email,String pwd,String telephone) {
        
        this.email=email;
        this.pwd=pwd;
        this.role=role;
        this.telephone=telephone;
    }
    
   

    public String getEmail() {
        return email;
    }

    public int getIdUser() {
        return idUser;
    }

   
    public String getPwd() {
        return pwd;
    }

    

    public String getRole() {
        return role;
    }

   
    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

   

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    

    public void setRole(String role) {
        this.role = role;
    }

    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
   
    
    
    
   
    

    @Override
    public String toString() {
        return  " email= " + email + ", pwd= " + pwd + ", role= " + role;
    }
    
    
    
    
  

    
    
    
}
