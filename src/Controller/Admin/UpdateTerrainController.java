///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller.Admin;
//
//import com.jfoenix.controls.JFXTimePicker;
//import entities.Categorie;
//import entities.Terrain;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.input.TouchEvent;
//
///**
// * FXML Controller class
// *
// * @author ahmed
// */
//public class UpdateTerrainController implements Initializable {
//
//    @FXML
//    private TextField tfNom;
//    @FXML
//    private TextField tfImage;
//    @FXML
//    private TextArea taDesc;
//    @FXML
//    private TextField tfPrix;
//    @FXML
//    private JFXTimePicker timeOuvert;
//    @FXML
//    private JFXTimePicker timeFerm;
//    @FXML
//    private ComboBox<?> cbCategorie;
//    @FXML
//    private Button btnEnregistrer;
//    @FXML
//    private ComboBox<?> cbGouvernorat;
//    @FXML
//    private Button btnImage;
//
//    Terrain terrain = null;
//    private String nom = "";        
//    private String desc = "";        
//    private Categorie ca = null;
//    private String gouv = "";
//    private String image = "";
//    private double prix =0;
//    private String hOuv ="";
//    private String hFerm = "";  
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//         System.out.println("welcome update init "+terrain);
//    }   
//
//    @FXML
//    private void loadGouvernorat(MouseEvent event) {
//    }
//
//    @FXML
//    private void inputPrix(TouchEvent event) {
//    }
//
//    @FXML
//    private void setCategorie(ActionEvent event) {
//    }
//
//
//    @FXML
//    private void selectImage(ActionEvent event) {
//    }
//    
//    public void setTerrain(Terrain terrain) {
//        
//        System.out.println("Update terrain ");
//        System.out.println(terrain);
//        
//        nom=terrain.getDesignation();
//        tfNom.setText(terrain.getDesignation());
//        ca=terrain.getCategorie();
//        cbCategorie.setPromptText(terrain.getCategorie().getDesignation());
//        desc=terrain.getDescription();
//        taDesc.setText(terrain.getDescription());        
//        String[] adr = terrain.getAdresse().split(" ");
//        gouv= adr[0];
//        cbGouvernorat.setPromptText(gouv);
//        image=terrain.getImage();
//        tfImage.setText(terrain.getImage());
//        prix=terrain.getPrix_location();
//        tfPrix.setText(Double.toString(terrain.getPrix_location()));
//        hOuv=terrain.getHeure_ouverture();
//        timeOuvert.setPromptText(terrain.getHeure_ouverture());
//        hFerm=terrain.getHeure_fermeture();
//        timeFerm.setPromptText(terrain.getHeure_fermeture());
//        System.out.println("id :"+terrain.getId());
//    }
//
//    @FXML
//    private void btnEnregistrer(ActionEvent event) {
//        
//        
//    }
//
//    
//}
