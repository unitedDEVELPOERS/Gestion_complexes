/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Proprietaire;
import entities.Reservation;
import entities.Terrain;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import java.time.ZoneId;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import services.AcceptationReservationCrud;
import services.ClientCrud;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ReservationsListController implements Initializable {
    User user=null;
    Proprietaire prop = new Proprietaire(30);
    
    @FXML
    private TableView<Reservation> tab_reservation;
    @FXML
    private TableColumn<Reservation, Date> colDate;
    @FXML
    private TableColumn<Reservation, LocalTime> colHeure;
    @FXML
    private TableColumn<Reservation, String> colClient;
    @FXML
    private TableColumn<Reservation, String> colTerrain;
    @FXML
    private TableColumn<Reservation, Float> colMontant;

    ReservationCrud rc = new ReservationCrud();
    ObservableList listReserv = FXCollections.observableArrayList();
    Reservation r = null;
    TerrainCrud tc = new TerrainCrud();
    ObservableList listTerrains = FXCollections.observableArrayList();
    ClientCrud cc = new ClientCrud();
    ObservableList listClients = FXCollections.observableArrayList();
    
    @FXML
    private JFXDatePicker datepick;
    @FXML
    private TextField tfTerrain;
    @FXML
    private ImageView imgRefresh;
    @FXML
    private JFXComboBox<?> cbTerrains;
    @FXML
    private Button btnSupprimer;
    @FXML
    private JFXComboBox<?> cbEtat;
    @FXML
    private Button btnAfficher;
    @FXML
    private AnchorPane paneList;
    @FXML
    private Pane paneAfficher;
    @FXML
    private Button btnValider;
    @FXML
    private TextField tfClient;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfHeure;
    @FXML
    private TextField tfMontant;
    @FXML
    private ImageView btnClose;
    @FXML
    private Button btnAnnuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneAfficher.setVisible(false);
        listReserv=rc.afficherResComplexe(prop);
        loadCbTerrains();
        loadCbEtat();
        loadTable();
    }   
    
    public void setRefresh(ObservableList l){
        listReserv=l;
        loadTable();
    }
    
    public void loadTable(){        
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));  
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
        colTerrain.setCellValueFactory(new PropertyValueFactory<>("terrain"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant")); 
        
             
        
//        ActButton();
        tab_reservation.setItems(listReserv);
        
    }
    
    public void afficher(Reservation reservation){
        
        tfClient.setText(reservation.getClient().toString());
        tfTerrain.setText(reservation.getTerrain().toString());
        tfDate.setText(reservation.getDate_reservation().toString());
        tfHeure.setText(reservation.getHeure().toString());
        tfMontant.setText(Double.toString(reservation.getMontant()));
        System.out.println(r.isValidee());
        if(reservation.isValidee())
        {
            btnValider.setDisable(true);
            btnAnnuler.setDisable(true);            
        }
        else 
            {
            btnValider.setDisable(false);
            btnAnnuler.setDisable(false);            
        }
        paneAfficher.setVisible(true);
        
    }
//    public void ActButton(){
//        Callback<TableColumn<Reservation, String>, TableCell<Reservation, String>> cellFoctory = (TableColumn<Reservation, String> param) -> {
//
//            final TableCell<Reservation, String> cell = new TableCell<Reservation, String>() {
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//
//                    if (empty) {
//                        setGraphic(null);
//                        setText(null);
//
//                    } else {
//                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//                        
//                        deleteIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#ff1744;"
//                        );
//                        
//                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
//                            r=(Reservation)tab_reservation.getSelectionModel().getSelectedItem();
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            alert.setTitle("Confirmation Dialog");
//                            alert.setContentText("Voulez vous vraiment supprimer cette réservation ?");
//
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK){
//                                rc.supprimerReservation(r);
//                                loadTable();
//                            } else {
//                                
//                            }                                                     
//                            loadTable();
//
//                        });
//                        
//                        HBox managebtn = new HBox( deleteIcon);
//                        managebtn.setStyle("-fx-alignment:center");
//                                                
//                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
//
//                        setGraphic(managebtn);
//
//                        setText(null);
//
//                    }
//                }
//
//            };
//
//            return cell;
//        };
//        colAct.setCellFactory(cellFoctory);
//    }

    @FXML
    private void selectItem(MouseEvent event) {
        if(tab_reservation.getSelectionModel().getSelectedIndex()!=-1)
        r=tab_reservation.getSelectionModel().getSelectedItem();
        //if(r.isValidee())
    }

    @FXML
    private void datepick(ActionEvent event) {
        LocalDate d = datepick.getValue();    
        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        listReserv.clear();
        listReserv=rc.affResComplexeDate(prop,new java.sql.Date(date.getTime()));
        loadTable();
    }

    @FXML
    private void chercherTerrain(ActionEvent event) {
        if(cbTerrains.getSelectionModel().getSelectedIndex() ==-1 || cbTerrains.getSelectionModel().getSelectedIndex()==0)
           listReserv = rc.afficherResComplexe(prop);
        else
        listReserv = rc.afficherResTerrain((Terrain)cbTerrains.getSelectionModel().getSelectedItem());
        
            
        loadTable();
    }
    
    private void loadCbTerrains(){
        listTerrains.add("tous");
        listTerrains.addAll(tc.getAll());
        cbTerrains.setItems(listTerrains);
    }
    
    private void loadCbEtat(){
        ObservableList etats = FXCollections.observableArrayList();
        etats.addAll("tous", "Validées", "En attente");
        cbEtat.setItems(etats);         
    }
    
    

    @FXML
    private void refresh(MouseEvent event) {
        datepick.getEditor().clear();
        listReserv.clear();
        listReserv=rc.afficherResComplexe(prop);
        loadTable();
    }

//    @FXML
//    private void chercherTerrain(MouseEvent event) {
//        if(cbTerrains.getSelectionModel().getSelectedIndex() !=-1 && cbTerrains.getSelectionModel().getSelectedIndex() !=0)
//           listReserv = rc.afficherResTerrain((Terrain)cbTerrains.getSelectionModel().getSelectedItem());
//        else if (cbTerrains.getSelectionModel().getSelectedIndex()==0)
//            listReserv = rc.afficherReservations();
//        loadTable();
//    }

    
    @FXML
    private void btnSupprimer(ActionEvent event) {
        
        if(r!=null){
            
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Voulez vouz annuler cette réservation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {                  
            rc.supprimerReservation(r);
            alerte("Réservation annulée");           
            listReserv=rc.afficherResComplexe(prop);
            loadTable();
            //if(r.getClient().getIdUser()==user.getIdUser()){  System.out.println("Controller.Admin.ReservationsListController.btnSupprimer()");              
              Notifications.create().title("titre texte").text("Votre réservation a été annulée").showInformation();
        
        } 
        
        }
    }

    


    @FXML
    private void chercherParEtat(ActionEvent event) {
        if(cbEtat.getSelectionModel().getSelectedIndex() ==-1 || cbEtat.getSelectionModel().getSelectedIndex()==0)
           listReserv = rc.afficherResComplexe(prop);
        else if(cbEtat.getSelectionModel().getSelectedIndex() ==1)
        listReserv = rc.afficherResEtat(1);
            else 
                listReserv = rc.afficherResEtat(0);
            
        loadTable();
    }

    @FXML
    private void btnAfficher(ActionEvent event) {
        if(r!=null){
            afficher(r);
        }
//        if(r!=null){
//        try {            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/ReservationEncaissement.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.initStyle(StageStyle.UNDECORATED);     
//            ReservationEncaissementController utc = loader.getController();
//            utc.setReservation(r);
//            stage.setScene(new Scene(root));
//            stage.show();          
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        }
    }

    @FXML
    private void btnValider(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Encaisser et valider cette réservation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {        
            r.setValidee(true);
            rc.modifierReservation(r);
            //alerte("Réservation validée"); 
            paneAfficher.setVisible(false);
        }   
    }
    
    public void alerte(String msg){       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //alert.setTitle("Attention !");
        alert.setContentText(msg);
        alert.showAndWait();

    }

    @FXML
    private void btnClose(MouseEvent event) {
        paneAfficher.setVisible(false);
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Encaisser et valider cette réservation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {                    
            rc.supprimerReservation(r);
            //alerte("Réservation annulée");           
            paneAfficher.setVisible(false);
            listReserv=rc.afficherResComplexe(prop);
            loadTable();
        }   
    }
    
   
    
}
