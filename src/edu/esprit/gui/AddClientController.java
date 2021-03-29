/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Client;
import edu.esprit.services.ClientCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class AddClientController implements Initializable {
 ObservableList<String> ListeChoice=FXCollections.observableArrayList("Gardien","Defenseur","Attaquant","Milieu");

   
    @FXML
    private TextField txtNon;
    @FXML
    private Button btAjouter;
    @FXML
    private Button btAnnuler;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtConfirme;
    @FXML
    private TextField txtMdp;
    @FXML
    private ChoiceBox<String> choice;
    private Label l1;
    @FXML
    private Label snom;
    @FXML
    private Label sprenom;
    @FXML
    private Label stelephone;
    @FXML
    private Label semail;
    @FXML
    private Label smdp;
    @FXML
    private Label smdp1;
    @FXML
    private Button btfacebook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choice.setValue("Gardien");
        choice.setItems(ListeChoice);
    }    

    @FXML
    private void AjouterClient(ActionEvent event) throws SQLException {
             try {
                 // try {
                 //1- SAVE Proprietaire IN DATABASE
                 String rNom= txtNon.getText();
                 String rPrenom= txtPrenom.getText();
                 String rEmail= txtEmail.getText();
                 String rPwd= txtMdp.getText();
                 String rTelephone= txtTelephone.getText();
                 
                 String rPosition=choice.getValue();
                 
               
                 
                 Client p = new Client(rEmail,rPwd,rTelephone,rNom,rPrenom,rPosition);
                 ClientCrud pcd = new ClientCrud();
                 pcd.ajouter(p);
                 try {
                     senEmail.mail(p.getEmail(),p.getNom());
                     
                 } catch (MessagingException ex) {
                     Logger.getLogger(AjouterArbitreController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 //2- REDIRECTION
                 
                 FXMLLoader loader = new FXMLLoader(
                         getClass().getResource("AcceuilClient.fxml"));
                 Parent root = loader.load();
                 AcceuilClientController pdc = loader.getController();
                 
                 txtPrenom.getScene().setRoot(root);
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(AddClientController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
   }

  @FXML
   private void Annuler(ActionEvent event) {
   FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      txtMdp.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
   
   }

    @FXML
    private void Control1(MouseDragEvent event) {
        if (txtNon.getText().isEmpty()){
            l1.setText("veuillez saisir votre nom");
            
        }
    }

    @FXML
    private void Control3(MouseDragEvent event) {
    }

    @FXML
    private void Control6(MouseDragEvent event) {
    }

    @FXML
    private void Control7(MouseDragEvent event) {
    }

    @FXML
    private void Control4(MouseDragEvent event) {
    }

    @FXML
    private void Control2(MouseDragEvent event) {
    }

    @FXML
    private void Control5(MouseDragEvent event) {
    }

    @FXML
    private void Facebook(ActionEvent event) {
    }
  







}



    

    

