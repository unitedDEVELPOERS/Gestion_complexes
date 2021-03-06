/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import entities.Categorie;
import entities.Complexe;
import entities.Terrain;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.AutoCompletionBinding;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import services.CategorieCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddTerrainController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfImage;
    private TextField tfGouvernorat;
    private TextField tfDelegation;
    private TextField tfLocalite;
    @FXML
    private TextArea taDesc;
    @FXML
    private TextField tfPrix;
    private TextField tfCategorie;
    @FXML
    private JFXButton btnImage;
    @FXML
    private JFXTimePicker timeOuvert;
    @FXML
    private JFXTimePicker timeFerm;
    @FXML
    private Button btnEnregistrer;
    TerrainCrud tCrud = new TerrainCrud();
    CategorieCrud cCrud = new CategorieCrud();
    Categorie categ=null;
    int idCateg = -1;
    String gouv, deleg, localite;
    String msg = "ajouté";
    Complexe c = new Complexe(1);
    //private  AutoCompletionBinding <String> autoCompletionBinding;
   
    
    private AnchorPane ancheAlert;
    @FXML
    private ComboBox<?> cbCategorie;
    @FXML
    private Button btnRetour;
    @FXML
    private ComboBox<?> cbGouvernorat;
    @FXML
    private ComboBox<?> cbDelegation;
    @FXML
    private ComboBox<?> cbLocalite;
//    ObservableList listGouv = FXCollections.observableArrayList();
//    ObservableList listDeleg = FXCollections.observableArrayList();
//    ObservableList listLocalite = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCbCategorie();
        loadGouvernorat();
        
        
        //autoCompletionBinding=TextFields.bindAutoCompletion(tfNom, ll);
       //loadGouv();
//        loadDeleg();
        
       //TextFields.bindAutoCompletion(tfGouvernorat, ll);
        //tfGouvernorat.bindAutoCompletion
    } 
    
    
    
    public void redir(){
        try{
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("GestionTerrains.fxml"));
            Parent root = loader.load();
            //GestionTerrainsController pdc = loader.getController();
//            pdc.setContNom(rNom);//injecter les variables du premier formulaire
//            pdc.setContPrenom(rPrenom);
            tfNom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void loadGouvernorat(){
        ObservableList gouvs = FXCollections.observableArrayList();
        gouvs.addAll("Terrain", "kk");
        gouvs.add("Date");
        cbGouvernorat.setItems(gouvs); 
    }
    
    public void alertInf(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Terrain "+ msg + " avec succes !" );

        alert.showAndWait();
    }
    
    //private void handleButtonAction(Action)
    public void alerte(){
        Stage stage=(Stage)ancheAlert.getScene().getWindow();
        AlertType type = AlertType.INFORMATION;
        Alert alert = new Alert(type,"");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("Tous les champs sont obligatoires !");
        alert.getDialogPane().setHeaderText("Attention !");
        alert.showAndWait();
        
    }
    
    public void vider(){
        tfNom.clear();
        tfCategorie.clear();
        taDesc.clear();
        tfGouvernorat.clear();
        tfDelegation.clear();
        tfLocalite.clear();
        tfImage.clear();
        tfPrix.clear();
        timeOuvert.setValue(LocalTime.MAX);
        
        
        
    }

    @FXML
    private void selectImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null){
            tfImage.setText(selectedFile.getName());
        }
    }
    
    
    public void loadCbCategorie(){
        ObservableList categories = FXCollections.observableArrayList();
        categories=cCrud.getAll();
        
        cbCategorie.setItems(categories);       
    }
    


    @FXML
    private void setCategorie(ActionEvent event) {
        categ = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
        idCateg = categ.getId();
       if(idCateg<=-1)
            return;
//        else{
//            
//            System.out.println(idCateg);
//            System.out.println(categ);
//           
//        }
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void redirection(ActionEvent event) {
        save();
        vv();
    }
    
    public void vv(){
        try{
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("GestionTerrains.fxml"));
            Parent root = loader.load();
            //GestionTerrainsController pdc = loader.getController();
//            pdc.setContNom(rNom);//injecter les variables du premier formulaire
//            pdc.setContPrenom(rPrenom);
            tfNom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void save(){
        String nom = tfNom.getText();        
        String desc = taDesc.getText();        
        Categorie ca = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
        String gouv = cbGouvernorat.getSelectionModel().getSelectedItem().toString();
        String image = tfImage.getText();
        float prix =Float.parseFloat(tfPrix.getText());
        String hOuv = timeOuvert.getValue().toString();
        String hFerm = timeFerm.getValue().toString();       
        if(nom.length()==0 || ca==null || desc.length()==0 || gouv.length()==0 || image.length()==0 || prix<=0 || hOuv.length()==0 || hFerm.length()==0)
            alerte();
        else{
            Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
            TerrainCrud tCrud = new TerrainCrud();            
            tCrud.ajouterTerrain(terrain);            
            alertInf(msg);
            //vider();
        }
    }
    
}
