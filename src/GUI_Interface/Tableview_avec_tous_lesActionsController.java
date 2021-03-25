/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Interface;

import Entitee.Categorie;
import Entitee.Competition;
import Entitee.proprietaire_complexe;
import Services.CRUD;
import Services.CategorieCrud;
import com.jfoenix.controls.JFXDatePicker;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;
//import sun.util.calendar.BaseCalendar.Date;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Tableview_avec_tous_lesActionsController implements Initializable {

    @FXML
    private TableView<Competition> table_liste_competition;
    @FXML
    private TableColumn<Competition, Integer> col_id;
    @FXML
    private TableColumn<Competition, String> col_desgniation;

    @FXML
    private TableColumn<Competition, String> col_datec;

    @FXML
    private TableColumn<Competition, String> col_dated;

    @FXML
    private TableColumn<Competition, String> col_nbeq;

    @FXML
    private TableColumn<Competition, String> col_catg;

    @FXML
    private TableColumn<Competition, String> col_complex;

    @FXML
    private TableColumn<Competition, String> col_prix;

    @FXML
    private TextField filterField;

    @FXML
    private JFXDatePicker txt_dd;
    @FXML
    private TextField txt_nbeq;

    @FXML
    private TextField txt_comp;
    @FXML
    private TextField txt_des;
    ObservableList listM = FXCollections.observableArrayList();
    ObservableList<Competition> listM2;
    ObservableList<Competition> dataList;
    ObservableList<Categorie> listcat;
    int cat = -1;
    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField txt_prix;
    @FXML
    private ComboBox<?> combo;
    private AnchorPane ancheAlert;
Categorie ccca = null;
    @FXML
    private TextField txt_id;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        CategorieCrud ccc = new CategorieCrud();
        Categorie c1 = ccc.find(1);
        System.out.println(c1);
        ObservableList listcat = FXCollections.observableArrayList();
        listcat = (ObservableList) ccc.AfficherCategories();
        combo.setItems(listcat);
        search_user();
        txt_comp.setText("2");
        txt_comp.setVisible(false);
        txt_id.setDisable(true);
                UpdateTable();

    }

    @FXML
    private void Add_COMP(ActionEvent event) {
        try {
            String des = txt_des.getText();
            String desc = txt_dd.getValue().toString();
            String e = txt_nbeq.getText();
            
            Categorie ca = (Categorie) combo.getSelectionModel().getSelectedItem();
            
            String g = txt_comp.getText();
            String z = txt_prix.getText();

            Competition cccc = new Competition(des, desc, e, ca, g, z);
           
            CRUD tCrud = new CRUD();
            tCrud.Add_COMP(cccc);
            if(des.length()==0 || desc==null || e.length()==0 || ca==null || g.length()==0 ||  g.length()==0 || z.length()==0)
            alerte();
            
            
            UpdateTable();
             alertInf();
             envoyerMail();
        
            vider();
        } catch (Exception e) {

        }
       
    }

    public void alerte() {
        Stage stage = (Stage) ancheAlert.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("Tous les champs sont obligatoires !");
        alert.getDialogPane().setHeaderText("Attention !");
        alert.showAndWait();

    }

    public void vider() {
       txt_des.clear();
       
        
    }

    @FXML
    private void Edit(ActionEvent event) throws SQLException {

try {
            String des = txt_des.getText();
            String desc = txt_dd.getValue().toString();
            String e = txt_nbeq.getText();
            Categorie ca = (Categorie) combo.getSelectionModel().getSelectedItem();

            String g = txt_comp.getText();
            String z = txt_prix.getText();

            Competition cccc = new Competition(des, desc, e,ca,  g, z);
            CRUD tCrud = new CRUD();
            tCrud.Edit(cccc);
            vider();
            UpdateTable();

        } catch (Exception e) {

        }

    }

    @FXML
    private void Delete(ActionEvent event) {
        String value1 = txt_des.getText();
        String value2 = txt_dd.getValue().toString();
        String value3 = txt_nbeq.getText();
//            String value3 = combo.getSelectionModel().getSelectedItem().toString();
        String value4 = txt_comp.getText();
        String value5 = txt_prix.getText();
        Competition uu = new Competition(value1, value2, value3, value4, value5);
        CRUD pp = new CRUD();
        pp.Delete(uu);
        UpdateTable();
        search_user();

    }

    @FXML
    void getSelected(MouseEvent event) {
        index = table_liste_competition.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_des.setText(col_desgniation.getCellData(index).toString());
        txt_nbeq.setText(col_nbeq.getCellData(index).toString());
//        combo.setPromptText(col_catg.getCellData(index).toString());
        txt_comp.setText(col_complex.getCellData(index).toString());
        txt_prix.setText(col_prix.getCellData(index).toString());
       
         
    }

    public void UpdateTable() {
        ObservableList listM = FXCollections.observableArrayList();
        CRUD tc = new CRUD();
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_desgniation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<>("categorie"));  
        col_complex.setCellValueFactory(new PropertyValueFactory<>("complexe"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix_participation"));

        listM = tc.getDatacompetition();
        table_liste_competition.setItems(listM);
        
search_user();
    }

    void search_user() {

        CRUD tc = new CRUD();
        col_id.setCellValueFactory(new PropertyValueFactory<Competition, Integer>("id"));
        col_desgniation.setCellValueFactory(new PropertyValueFactory<Competition, String>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<Competition, String>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<Competition, String>("categorie"));
        col_complex.setCellValueFactory(new PropertyValueFactory<Competition, String>("complexe"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Competition, String>("prix_participation"));

        dataList = tc.getDatacompetition();
        table_liste_competition.setItems(dataList);
        FilteredList<Competition> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(c -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (c.getDesignation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (c.getDate_debut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                  return true; // Filter matches date debut
                  }            
                else {
                    return false;
                }
            });
        });

        SortedList<Competition> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_liste_competition.comparatorProperty());
        table_liste_competition.setItems(sortedData);

    }
  public void alertMail(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email envoyé");
        alert.setHeaderText(null);
        alert.setContentText("Les clients de ton complexe sont informés de votre nouveau Competition!" );

        alert.showAndWait();
    }
    

    public void envoyerMail(){
        try {
                
                sendMail("Ounifisamiritdsi@gmail.com");
                alertMail();
            } catch (Exception ex) {
                Logger.getLogger(Tableview_avec_tous_lesActionsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "num.20746081@gmail.com";
        //Your gmail password
        String password = "Ahmed20746081";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Nouveau Competition pour vous");
            String htmlCode = "<h1> Nous mettons à votre disposition un nouveau Competition </h1>"
                    + "<h3> Participiez .....les places est illimites :)</h3>";           
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Tableview_avec_tous_lesActionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
 public void alertInf(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information !!");
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Votre Competition est enregistrée avec succes !" );

        alert.showAndWait();
    }
}
