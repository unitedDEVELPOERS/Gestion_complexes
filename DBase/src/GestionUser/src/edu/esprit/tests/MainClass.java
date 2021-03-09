/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import edu.esprit.entities.Arbitre;
import edu.esprit.entities.Client;
import edu.esprit.entities.Proprietaire;
import edu.esprit.services.ArbitreCrud;
import edu.esprit.services.ClientCrud;
import edu.esprit.services.ProprietaireCrud;
import edu.esprit.services.UserCrud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ghara
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            
            ArbitreCrud cc=new ArbitreCrud();
            Arbitre a=new Arbitre("Email","pasjswd","teli","nom","prenom","matricule","categorie");
            cc.update(a);
            List<Arbitre> list=new ArrayList<>();
       list=cc.readAll();
       System.out.println(list);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      

      
           
            
            
            
            
            
            
            
            
            
       
        
       
        
        
        
        
        
    }
    
}
