/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import CRUD.ProduitCrud;
import Crud.FournisseurCrud;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Fournisseur;
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
public class FournisseurController implements Initializable {

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
    private TableColumn<Fournisseur, String> coid;
    @FXML
    private TableColumn<Fournisseur, String> coref;
    @FXML
    private TableColumn<Fournisseur, String> codes;
    @FXML
    private TableColumn<Fournisseur, String> coprix;
    @FXML
    private TableColumn<Fournisseur, String> coprix1;
    @FXML
    private TableColumn<Fournisseur, String> coprix11;
    @FXML
    private JFXButton btnsupprimer;
    @FXML
    private JFXButton btnmodifier;
    @FXML
    private JFXTextField cquantite1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
            
              try {
            String a = creferences.getText();
            String b = cdesignation.getText();
            String c = cprix.getText();
            String d=cquantite.getText();
            String e=cquantite1.getText();

           

             Fournisseur four = new Fournisseur(a, b,c, d,e);
            FournisseurCrud tCrud = new FournisseurCrud();
            tCrud.add_four(four);
           
                  
        } catch (Exception e) {

        }
    }

    @FXML
    private void delete(MouseEvent event) {
    }

    @FXML
    private void modify(MouseEvent event) {
    }
    
}
