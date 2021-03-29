/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import entities.matche;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.MatchCRUD;

/**
 * FXML Controller class
 *
 * @author bezin
 */
public class ConsulterMatchController implements Initializable {

    @FXML
    private ImageView btRetour;
    @FXML
    private TableView<matche> tableV1;
    @FXML
    private TableColumn<matche, ?> Equipe2Column;
    @FXML
    private TableColumn<matche, ?> Equipe1Column;
    private Button BtnModifier;
    @FXML
    private TableColumn<matche, ?> btnID;
    @FXML
    private TextField tfResuEq1;
    @FXML
    private TextField tfResuEq2;

    int index = -1;
    @FXML
    private TableColumn<matche, ?> Rseq1;
    @FXML
    private TableColumn<matche, ?> Rseq2;
    @FXML
    private TextField Rs2;
    @FXML
    private TextField Rs1;
    @FXML
    private TextField txId1;
    @FXML
    private TextField txId2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        consulterMatche();
    }

    void consulterMatche() {

        ObservableList listM = FXCollections.observableArrayList();
        MatchCRUD tc = new MatchCRUD();
        btnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Equipe1Column.setCellValueFactory(new PropertyValueFactory<>("equipe1"));
        Equipe2Column.setCellValueFactory(new PropertyValueFactory<>("equipe2"));
        Rseq1.setCellValueFactory(new PropertyValueFactory<>("resultat_eq1"));
        Rseq2.setCellValueFactory(new PropertyValueFactory<>("resultat_eq2"));
//        txt_comp.setCellValueFactory(new PropertyValueFactory<>("competition"));
//        eeee.setCellValueFactory(new PropertyValueFactory<>("resultat_eq1"));
//        pppp.setCellValueFactory(new PropertyValueFactory<>("resultat_eq2"));
//         niv_match.setCellValueFactory(new PropertyValueFactory<>("nvcomp"));
//        col_nbeq.setCellValueFactory(new PropertyValueFactory<>("equipe2"));
//        col_catg.setCellValueFactory(new PropertyValueFactory<>("resultat_eq1"));  
//        col_complex.setCellValueFactory(new PropertyValueFactory<>("resultat_eq2"));

        listM = tc.AfficherMatche();
        tableV1.setItems(listM);

    }

    private void Modifier(ActionEvent event) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionPage.fxml"));
            Parent root = loader.load();
            GestionPageController pdc = loader.getController();

            BtnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Select(MouseEvent event) {

        index = tableV1.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        tfResuEq1.setText(Equipe1Column.getCellData(index).toString());
        tfResuEq2.setText(Equipe2Column.getCellData(index).toString());
        txId1.setText(btnID.getCellData(index).toString());
        txId2.setText(btnID.getCellData(index).toString());

    }

    @FXML
    private void Edit(ActionEvent event) throws SQLException {

        try {

            String i = txId1.getText();

            String rs1 = Rs1.getText();
            String rs2 = Rs2.getText();

            matche cccc = new matche(i, rs1, rs2);
            MatchCRUD tCrud = new MatchCRUD();
            tCrud.modifierResultat(cccc);

            consulterMatche();
            vider();
            alertInf();
            envoyerMail();
        } catch (Exception e) {

        }

    }

    public void vider() {

        Rs1.clear();
        Rs2.clear();
        txId1.clear();
        txId2.clear();
        tfResuEq1.clear();
        tfResuEq2.clear();

    }
   
    public void alertInf(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information !!");
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Votre resultats est enregistrée avec succes !" );

        alert.showAndWait();
    }

    private void envoyerMail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
}
