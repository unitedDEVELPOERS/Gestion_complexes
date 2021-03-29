/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import entities.Client;
import gui.AdminPanelController;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import services.ReservationCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AcceuilClientController implements Initializable {
    ReservationCrud rc = new ReservationCrud();
    Client client = new Client(31,3);   
    int notif;
    
    @FXML
    private Button btn;
    @FXML
    private Button btnReservation;
    @FXML
    private BorderPane bp;
    @FXML
    private Label lbNotif;
    @FXML
    private Label lbMessage;
    @FXML
    private Pane btnInvitations;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        if(client!=null)
            notif = rc.afficherinvitations(client).size();
        if(notif!=0){
            lbNotif.setText(String.valueOf(notif));
            if(notif == 1 )
                lbMessage.setText("Nouvelle invitation");
            else 
                lbMessage.setText("Nouvelles invitations");
        }                           
        else {
            btnInvitations.setVisible(false);
        }

    }    

    private void loadPage(String page){
        Parent root=null;
        try{
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
        
    }
    @FXML
    private void btnReservation(ActionEvent event) {
        loadPage("/gui/client/Reservation");
    }

    @FXML
    private void btnInvitations(MouseEvent event) {
        loadPage("/gui/client/MesReservations");
    }
    
    
//    private static void callMyService() {
//        System.out.println("DEBUT appel bloquant");
//        try {
//                                //le programme va attendre 7 secondes
//        Thread.currentThread().sleep(10000);
//        System.out.println("FIN appel bloquant");
//        } catch (InterruptedException e) {
//        System.out.println("appel bloquant interrompu");
//        }
//        }
//
//            private void maj(){
//                System.out.println("starting MAIN");
//        Timer t = new Timer();
//        t.schedule(new TimerTask() {
//        int i = 0;
//
//        public void run() {
//                                        //répéter chaque 3 secondes 
//        System.out.println("timer exec n°:" + ++i);
//        if(client!=null)
//                    notif = rc.afficherinvitations(client).size();
//                if(notif!=0){
//                    lbNotif.setText(String.valueOf(notif));
//                    if(notif == 1 )
//                        lbMessage.setText("Nouvelle invitation");
//                    else 
//                        lbMessage.setText("Nouvelles invitations");
//                }                           
//                else {
//                    lbNotif.setVisible(false);
//                    lbMessage.setVisible(false);
//                }
//
//        }
//        }, 0, 1000);
//
//        callMyService();
//
//        System.out.println("end MAIN");
//        t.cancel();
//            }
    
    
}
