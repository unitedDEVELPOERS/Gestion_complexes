/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin;

import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddTerrainController implements Initializable {

    @FXML
    private AnchorPane paneUpdate;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfImage;
    @FXML
    private Text taDesc;
    @FXML
    private TextField tfPrix;
    @FXML
    private JFXTimePicker timeOuvert;
    @FXML
    private JFXTimePicker timeFerm;
    @FXML
    private ComboBox<?> cbCategorie;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private ComboBox<?> cbGouvernorat;
    @FXML
    private Button btnImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadGouvernorat(MouseEvent event) {
    }

    @FXML
    private void inputPrix(TouchEvent event) {
    }

    @FXML
    private void setCategorie(ActionEvent event) {
    }

    @FXML
    private void btnEnregistrer(ActionEvent event) {
    }

    @FXML
    private void selectImage(ActionEvent event) {
    }
    
}
