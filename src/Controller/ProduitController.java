/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.*;

import CRUD.ProduitCrud;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jawher
 */
public class ProduitController implements Initializable {

    @FXML
    private JFXTextField cidentifiant;
    @FXML
    private FontAwesomeIconView csearch;
    @FXML
    private JFXTextField creferences;
    @FXML
    private JFXTextField cdesignation;
    @FXML
    private JFXTextField cprix;
    @FXML
    private JFXTextField cquantite;
    @FXML
    private TableColumn<Produit, String> coid;
    @FXML
    private TableColumn<Produit, String> coref;
    @FXML
    private TableColumn<Produit, String> codes;
    @FXML
    private TableColumn<Produit, String> coprix;
    @FXML
    private TableColumn<Produit, String> coprix1 ;
    @FXML
    private JFXButton btnsupprimer;
    @FXML
    private JFXButton btnmodifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search(MouseEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
              try {
            String des = creferences.getText();
            String desc = cdesignation.getText();
            String e = cprix.getText();
            String ca=cquantite.getText();
            Produit cccc = new Produit(des, desc, e, ca);
            ProduitCrud tCrud = new ProduitCrud();
            tCrud.add(cccc);
           
                  
        } catch (Exception e) {

        }
        
    }

    @FXML
    private void delete(MouseEvent event) {    
        
    }

    @FXML
    private void modify(MouseEvent event) {
               String value1 = creferences.getText();
        String value2 = cdesignation.getText();
        String value3 = cprix.getText();
        String value4 = cquantite.getText();
  

        Produit uu = new Produit(value1, value2, value3, value4);
        ProduitCrud pp = new ProduitCrud();
        pp.update(uu);

     
        
        
    }

   
}
