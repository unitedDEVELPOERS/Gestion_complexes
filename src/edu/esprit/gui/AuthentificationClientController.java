/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Client;
import edu.esprit.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class AuthentificationClientController implements Initializable {

String email;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField login;
    @FXML
    private Button btLogin;
    @FXML
    private Label incorrect;
    @FXML
    private Button btProp;
    @FXML
    private Button btAdmin;
    Client c=new Client();
    @FXML
    private Button inscrit;
    @FXML
    private Button retour;
    @FXML
    private Button btClient;
    @FXML
    private Label semail;
    @FXML
    private Label smdp;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
    }    

    @FXML
    private void Login(ActionEvent event) {
        MyConnection con=new MyConnection();
        Connection cnx=con.getConnection();
        String email=login.getText();
                if(email.isEmpty()){
            semail.setVisible(true);
            semail.setText("champ vide");

            
        }else {
        try {
            String client="client";
            String admin="admin";
            Statement statement=cnx.createStatement();
            String sql="SELECT* FROM utilisateur WHERE email='"+login.getText()+"' AND password='"+mdp.getText()+"';";
            ResultSet resultset=statement.executeQuery(sql);
            
            if(resultset.next()){
             if((resultset.getString(4).equals(client))){
               
                 //this.p.setEmail(login.getText());
                 
                 
                
                FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AcceuilClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                     
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             else if((resultset.getString(4).equals(admin))){
                 FXMLLoader loader = new FXMLLoader(
            getClass().getResource("GestionProprietaire.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                     
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
                }
            
        else {
                
                JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect");
                //incorrect.setText("Email ou mot de passe incorrect");
                
                }
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }}
    
    
   @FXML
    private void Retour(ActionEvent event) { 
    
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    
    
    @FXML
    private void AuthProp(ActionEvent event) { 
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationProprietaire.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    
    @FXML
    private void  InscritClient(ActionEvent event) { 
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AddClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
   
    
    
    @FXML
    private void  AuthArbitre(ActionEvent event) { 
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationArbitre.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
             
    }
    
    
    public String loginUtilisateur(String login){
     return login;
    }
   
    
    
}
