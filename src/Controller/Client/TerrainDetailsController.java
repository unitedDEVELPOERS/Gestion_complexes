/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import com.jfoenix.controls.JFXDatePicker;
import entities.Client;
import entities.Reservation;
import entities.Terrain;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import services.ReservationCrud;
import entities.Reservation;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TerrainDetailsController implements Initializable {
    ObservableList reservations = FXCollections.observableArrayList();
    ReservationCrud rc = new ReservationCrud();
    Reservation reservation = new Reservation();
    Terrain terrain = null;
    LocalTime heure=null;
    List<LocalTime> HeuresReserv = new ArrayList();
    Reservation r =null;
    Client client=new Client(32);
    
    @FXML
    private ImageView img;
    @FXML
    private Text lbDesignation;
    private TextArea taDescription;
    @FXML
    private Label lbOuv;
    @FXML
    private Label lbFerm;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbAdresse;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXDatePicker datePick;
    @FXML
    private Text txtDescription;
    @FXML
    private Pane paneSeances;
    @FXML
    private Pane s1;
    @FXML
    private Pane s3;
    @FXML
    private Pane s4;
    @FXML
    private Pane s5;
    @FXML
    private Pane s7;
    @FXML
    private Pane s6;
    @FXML
    private Pane s2;
    @FXML
    private Pane s8;
    @FXML
    private Pane s9;
    @FXML
    private Button btnReserver;
    @FXML
    private ImageView btnClose;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    public void setTerrain(Terrain t) {
        terrain=t;
        reservations = rc.afficherResTerrain(t);
        System.out.println("init "+terrain);
        System.out.println(reservations.size());

        lbDesignation.setText(terrain.getDesignation());
        txtDescription.setText(terrain.getDescription());
        lbOuv.setText(terrain.getHeure_ouverture().toString());
        lbFerm.setText(terrain.getHeure_fermeture().toString());
        lbAdresse.setText(terrain.getAdresse());
        lbPrix.setText(Double.toString(terrain.getPrix_location()));
        Image image = new Image(getClass().getResourceAsStream(terrain.getImage()),410,200,false,false);
        img.setImage(image);
        
        datePick.setValue(LocalDate.now());
        LocalDate d = datePick.getValue();    
        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        reservations.clear();
        reservations=rc.affResDateTerrain(terrain, new java.sql.Date(date.getTime()));
        System.out.println("nbre reservations : "+reservations.size());

        
    }


    @FXML
    private void chercherDate(ActionEvent event) {
        LocalDate d = datePick.getValue();    
        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        HeuresReserv.clear();
        HeuresReserv = rc.affHeuresTerrainDate(terrain, new java.sql.Date(date.getTime()));
        System.out.println("nbre reservations : "+HeuresReserv.size());
        System.out.println("nbre reservations : "+LocalTime.of(21, 30, 59));
        if(HeuresReserv.contains(LocalTime.of(06, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(8, 00, 00)))
            s2.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(10, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(12, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(14, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(16, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(18, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(20, 00, 00)))
            s1.setDisable(true);
        if(HeuresReserv.contains(LocalTime.of(22, 00, 00)))
            s1.setDisable(true);
    }
    
    private void loadSeances(){
//        LocalDate d = datePick.getValue();    
//        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        reservations.clear();
//        reservations=rc.affResDateTerrain(terrain, new java.sql.Date(date.getTime()));
//        if(reservations.size()>0){
//            for(Reservation rs in reservations){
//                System.out.println("Controller.Client.TerrainDetailsController.loadSeances()");
//            }
//            System.out.println("Controller.Client.TerrainDetailsController.loadSeances()");
//        }
    }

    @FXML
    private void clicS1(MouseEvent event) {
        heure = LocalTime.of(06, 00, 00);
    }

    @FXML
    private void clicS3(MouseEvent event) {
        heure = LocalTime.of(10, 00, 00);
    }

    @FXML
    private void clicS4(MouseEvent event) {
        heure = LocalTime.of(12, 00, 00);
    }

    @FXML
    private void clicS5(MouseEvent event) {
        heure = LocalTime.of(14, 00, 00);
    }

    @FXML
    private void clicS7(MouseEvent event) {
        heure = LocalTime.of(18, 00, 00);
    }

    @FXML
    private void clicS6(MouseEvent event) {
        heure = LocalTime.of(16, 00, 00);
    }

    @FXML
    private void clicS2(MouseEvent event) {
        heure = LocalTime.of(8, 00, 00);
        System.out.println(heure);
    }

    @FXML
    private void clicS8(MouseEvent event) {
        heure = LocalTime.of(20, 00, 00);
    }

    @FXML
    private void clicS9(MouseEvent event) {
        heure = LocalTime.of(22, 00, 00);
    }

    @FXML
    private void btnReserver(ActionEvent event) {
        if(heure!=null){
       LocalDate d = datePick.getValue();    
        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
            r= new Reservation(date,heure,false, client, terrain, terrain.getPrix_location());
            rc.addReservation(r);
            
        }
    }

    @FXML
    private void btnClose(MouseEvent event) {
        Stage stage = (Stage) btnReserver.getScene().getWindow();
        stage.close();
    }
               
}
