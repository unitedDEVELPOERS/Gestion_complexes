/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.tools.MyConnection;
import edu.esprit.entities.Proprietaire;
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
public class AuthentificationProprietaireController implements Initializable {
   Proprietaire p=new Proprietaire();
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField login;
    @FXML
    private Button btLogin;
    @FXML
    private Label incorrect;
    @FXML
    private Button btAdmin;
    @FXML
    private Button btClient;

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
        try {
            String client="Proprietaire";
            Statement statement=cnx.createStatement();
            String sql="SELECT* FROM utilisateur WHERE email='"+login.getText()+"' AND password='"+mdp.getText()+"' AND role='"+client+"';";
            ResultSet resultset=statement.executeQuery(sql);
            
            if(resultset.next()){
                 this.p.setEmail(login.getText());
                 
                 
                
                FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AcceuilProp.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                     
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                }
            
        else {
                
                JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect");
                //incorrect.setText("Email ou mot de passe incorrect");
                
                }
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
     private void AuthClient(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
     }
     
     @FXML
     private void Retour(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      login.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationProprietaireController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
     }
      
     
    @FXML
     private void AuthArbitre(ActionEvent event){
         
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
      public String loginProp(String login){
     return login;
    }

    public Proprietaire getP() {
        return p;
    }

    public void setP(Proprietaire p) {
        this.p = p;
    }
    
      
      
      
      
       
    }
    

