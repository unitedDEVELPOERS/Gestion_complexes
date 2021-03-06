/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import services.CategorieCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class EssaiController implements Initializable {

    @FXML
    private ComboBox<?> cbxCategories;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieCrud cc = new CategorieCrud();
        //List<String>ccc=cc.getAll();
        ObservableList<String> op = FXCollections.observableArrayList("jj", "kk", "ll");
        cbxCategories = new ComboBox(op);
        //cbxCategories.getItems().addAll(op);
        //cbxCategories.setVisible(false);
        
    }    

    @FXML
    private void Afficher(MouseEvent event) {
    }
    
}
