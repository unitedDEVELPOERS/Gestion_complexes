/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.jfoenix.controls.JFXDatePicker;
import entities.Client;
import entities.Reservation;
import entities.Terrain;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ReservationCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class DetailsTerrainController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Text lbDesignation;
    @FXML
    private Label lbOuv;
    @FXML
    private Label lbFerm;
    @FXML
    private Label lbPrix;
    @FXML
    private JFXDatePicker datePick;

    @FXML
    private AnchorPane paneDetails;
    @FXML
    private TextArea taDescription;
    @FXML
    private Button btnRetour;
    
    ObservableList listReservations = FXCollections.observableArrayList();
    ReservationCrud rcrud = new ReservationCrud();
    Client cl = new Client(6,"hs");
    Terrain ter=null;
        
    /**
     * Initializes the controller class.
     */
        List<String> l = new ArrayList();
        //String seance = "";
        int s=0;
    @FXML
    private Button s2;
    @FXML
    private Button s6;
    @FXML
    private Button s5;
    @FXML
    private Button s3;
    @FXML
    private Button s4;
    @FXML
    private Button s1;
    @FXML
    private Button s7;
    @FXML
    private Button s8;
    @FXML
    private Button s9;
    @FXML
    private Button btnReserver;
    @FXML
    private Button bn;
    int i;
    @FXML
    private Label lbAdresse;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //setContTerrain(ter);
        
        
             
        
    }    
    public void setTerrain(Terrain t) {
        ter=t;
        //i=t.getId();
        lbDesignation.setText(ter.getDesignation());
        taDescription.setText(t.getDescription());
        lbOuv.setText(ter.getHeure_ouverture());
        lbFerm.setText(ter.getHeure_fermeture());
        lbAdresse.setText(t.getAdresse());
//        Image image = new Image(getClass().getResourceAsStream(t.getImage()));
//        img.setImage(image);
        listReservations= rcrud.afficherResTerrain(t);
        l=rcrud.affHeuresTerrainDate(t, Date.valueOf(LocalDate.now()));
        //l=rcrud.affHeuresRes(ter);
        //System.out.println(listReservations.size());
        if(l.contains("6"))            
            s1.setDisable(true);
        if(l.contains("8")) 
            s2.setDisable(false);
        if(l.contains("10")) 
            s3.setDisable(false);
        if(l.contains("12")) 
            s4.setDisable(false);
        if(l.contains("14")) 
            s5.setDisable(false);
        if(l.contains("16")) 
            s6.setDisable(false);
        if(l.contains("18")) 
            s7.setDisable(false);
        if(l.contains("20")) 
            s8.setDisable(false);
        if(l.contains("22")) 
            s9.setDisable(false);
        
        
        
        
    }

    @FXML
    private void retourDetails(ActionEvent event) {
    }

    @FXML
    private void s2(ActionEvent event) {
        s=8;
    }

    @FXML
    private void s6(ActionEvent event) {
        s=16;
    }

    @FXML
    private void s5(ActionEvent event) {
        s=14;
    }

    @FXML
    private void s3(ActionEvent event) {
        s=10;
    }

    @FXML
    private void s4(ActionEvent event) {
        s=12;
    }

    @FXML
    private void s1(ActionEvent event) {
        s=6;
    }

    @FXML
    private void s7(ActionEvent event) {
        s=18;
    }

    @FXML
    private void s8(ActionEvent event) {
        s=20;
    }

    @FXML
    private void s9(ActionEvent event) {
        s=22;
    }

    @FXML
    private void reserver(ActionEvent event) {
        if(s!=0){
            Date d = new Date(2020,12,03);
            Reservation r = new Reservation();
        //Terrain t= new Terrain(2,"terrain foot", "terrain premier crée");
        //Client j = new Client(6);
        //r.setDate_creation(Date.valueOf(datePick.getValue());
        r.setTerrain(ter);
        r.setValidee(true);
        r.setDate_reservation(d);
        r.setHeure(s);
        r.setClient(cl);
        //r.setId(6);
        r.setMontant(150);
        ReservationCrud rc=new ReservationCrud();
        rc.addReservation(r);
        alertInf();
            Stage s = (Stage)btnReserver.getScene().getWindow();
            s.close();
         }
        
    }
    
    public void alertInf(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Votre réservation est enregistrée avec succes !" );

        alert.showAndWait();
    }

    @FXML
    private void refSeances(ActionEvent event) {

        Date d1= Date.valueOf(datePick.getValue());
        if(rcrud.affHeuresTerrainDate(ter, d1).size()>0)
            
        l=rcrud.affHeuresTerrainDate(ter, d1);
        if(l.contains("6"))            
            s1.setDisable(true);
        if(l.contains("8")) 
            s2.setDisable(false);
        if(l.contains("10")) 
            s3.setDisable(false);
        if(l.contains("12")) 
            s4.setDisable(false);
        if(l.contains("14")) 
            s5.setDisable(false);
        if(l.contains("16")) 
            s6.setDisable(false);
        if(l.contains("18")) 
            s7.setDisable(false);
        if(l.contains("20")) 
            s8.setDisable(false);
        if(l.contains("22")) 
            s9.setDisable(false);
    }

    @FXML
    private void bn(ActionEvent event) {
//        Date d1= Date.valueOf(datePick.getValue());
//        if(rcrud.affHeuresTerrainDate(ter, d1).size()>0)
//        l=rcrud.affHeuresTerrainDate(ter, d1);
//        if(l.contains("6"))            
//            s1.setDisable(true);
//        if(l.contains("8")) 
//            s2.setDisable(false);
//        if(l.contains("10")) 
//            s3.setDisable(false);
//        if(l.contains("12")) 
//            s4.setDisable(false);
//        if(l.contains("14")) 
//            s5.setDisable(false);
//        if(l.contains("16")) 
//            s6.setDisable(false);
//        if(l.contains("18")) 
//            s7.setDisable(false);
//        if(l.contains("20")) 
//            s8.setDisable(false);
//        if(l.contains("22")) 
//            s9.setDisable(false);
//        
    }

    
    
    
}
