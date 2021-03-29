/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServiceEquipe;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class ChangelogoController implements Initializable {
public equipe equipe;
public utilisateur utilisateur;
    @FXML
    private Button btAcceuil;
    @FXML
    private Button btReservation;
    @FXML
    private Button btEquipe;
    @FXML
    private Button btBoutique;
    @FXML
    private Button btCompte;

    public equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(equipe equipe) {
        this.equipe = equipe;
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private ImageView v1;
    @FXML
    private ImageView v3;
    @FXML
    private ImageView v2;
    @FXML
    private ImageView v5;
    @FXML
    private ImageView v4;
    @FXML
    private ImageView v6;
    @FXML
    private Button valider;
  boolean v1t=false,v2t=false,v3t=false,v4t=false,v5t=false,v6t=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          Image iv1= new Image("/icons/vector1.png");
            Image iv2= new Image("/icons/vector2.jpg");
              Image iv3= new Image("/icons/vector3.jpg");
                Image iv4= new Image("/icons/vector4.jpg");
                  Image iv5= new Image("/icons/vector5.jpg");
                    Image iv6= new Image("/icons/vector6.png");
                      v1.setImage(iv1);
                        v2.setImage(iv2);
                          v3.setImage(iv3);
                            v4.setImage(iv4);
                              v5.setImage(iv5);
                                v6.setImage(iv6);
    }    

    @FXML
    private void onvalide(ActionEvent event) {
       try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
           v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void v1c(MouseEvent event) throws SQLException {
     try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector1.png");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
           v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void v3c(MouseEvent event) throws SQLException {
      try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
           VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector3.jpg");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
              v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }  }

    @FXML
    private void v2c(MouseEvent event) throws SQLException {   try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector2.jpg");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
             v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void v5c(MouseEvent event) throws SQLException {   try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
             VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector5.jpg");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
         pdc.setUtilisateur(utilisateur);
               v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void v4c(MouseEvent event) throws SQLException {   try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector4.jpg");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
              v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }    }

    @FXML
    private void v6c(MouseEvent event) throws SQLException {   try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            equipe.setLogo("/icons/vector6.png");
            ServiceEquipe ser=new ServiceEquipe();
            ser.update(equipe);
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
                v1.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void Acceuil(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void Equipe(ActionEvent event) {
    }

    @FXML
    private void Compte(ActionEvent event) {
    }
    
}
