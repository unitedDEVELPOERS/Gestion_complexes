/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.invitation;
import entities.utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.ServiceInvitation;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class VerificationdemandeinvitationController implements Initializable {
 public invitation invitation;
public utilisateur utilisateur ;

    public invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(invitation invitation) {
        this.invitation = invitation;
    }
    @FXML
    private Button oui;
    @FXML
    private Button non;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void foui(ActionEvent event) throws SQLException {
        
        ServiceInvitation si = new ServiceInvitation();
        invitation.setValide(1);
        si.update(invitation);
        ServiceUtilisateur su=new ServiceUtilisateur();
        List<utilisateur>l =su.readAll();
        for(int i=0;i<l.size();i++){ 
            if(l.get(i).getId()==invitation.getUtilisateur())
                utilisateur=l.get(i);
        }
        utilisateur.setEquipe(invitation.getEquipe());
        utilisateur.setPosition_equipe(0);
        su.updateequipe(utilisateur);
        su.updatepositionequipe(utilisateur);
         Stage stage=(Stage)oui.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void fnon(ActionEvent event) {
         Stage stage=(Stage)oui.getScene().getWindow();
        stage.close();
    }
    
}
