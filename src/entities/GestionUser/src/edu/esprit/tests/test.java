/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import edu.esprit.entities.User;
import edu.esprit.services.UserCrud;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ghara
 */
public class test {
       public static void main(String[] args) {
           try {
               UserCrud u=new UserCrud();
               User a=new User("sahar","sahar","client","123544");
              u.ajouter(a);
              
               
           } catch (SQLException ex) {
               Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    
}
