///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller.Admin;
//
//import com.jfoenix.controls.JFXDatePicker;
//import entities.Reservation;
//import entities.Terrain;
//import java.net.URL;
//import java.util.Date;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Text;
//import services.ReservationCrud;
//
///**
// * FXML Controller class
// *
// * @author ahmed
// */
//public class TerrainDetailsController implements Initializable {
//    ReservationCrud rc = new ReservationCrud();
//    Reservation reservation = new Reservation();
//    Terrain terrain = null;
//    @FXML
//    private ImageView img;
//    @FXML
//    private TableView<Reservation> tableReservations;
//    @FXML
//    private TableColumn<Reservation, String> colClient;
//    @FXML
//    private TableColumn<Reservation, Date> colDate;
//    @FXML
//    private TableColumn<Reservation, Integer> colHeure;
//    @FXML
//    private TableColumn<Reservation, Integer> colEtat;
//    @FXML
//    private Text lbDesignation;
//    private TextArea taDescription;
//    @FXML
//    private Label lbOuv;
//    @FXML
//    private Label lbFerm;
//    @FXML
//    private Label lbPrix;
//    @FXML
//    private Label lbAdresse;
//    /**
//     * Initializes the controller class.
//     */
//    ObservableList reservations = FXCollections.observableArrayList();
//    @FXML
//    private JFXDatePicker datePick;
//    @FXML
//    private Text txt;
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        System.out.println(terrain);
//        
//    }    
//    public void setTerrain(Terrain t) {
//        terrain=t;
//        reservations = rc.afficherResTerrain(terrain);
//        System.out.println(t);
//        System.out.println(terrain+" kkkk");
//        lbDesignation.setText(terrain.getDesignation());
//        taDescription.setText(terrain.getDescription());
//        lbOuv.setText(terrain.getHeure_ouverture());
//        lbFerm.setText(terrain.getHeure_fermeture());
//        lbAdresse.setText(terrain.getAdresse());        
////        Image image = new Image(getClass().getResourceAsStream(terrain.getImage()));
////        img.setImage(image);
//        //img.setFitWidth(600);
////        img.setFitHeight(250);
//        
//    }
//
//    @FXML
//    private void retour(ActionEvent event) {
//    }
//
//    @FXML
//    private void chercherDate(ActionEvent event) {
//    }
//               
//}
