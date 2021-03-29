/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Client;
import entities.Proprietaire;
import entities.Reservation;
import entities.Terrain;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ShowReservationsController implements Initializable {

    @FXML
    private Button btnChercher;
    @FXML
    private TableColumn<Reservation, Integer> colId;
    @FXML
    private TableColumn<Reservation, Date> colDate;
    @FXML
    private TableColumn<Reservation, String> colClient;
    @FXML
    private TableColumn<Reservation, String> colTerrain;
    @FXML
    private TableColumn<Reservation, Float> colMontant;
    @FXML
    private TableView<Reservation> tab_reservation;
    @FXML
    private ComboBox<?> cbFiltre;
    @FXML
    private DatePicker datePick;
    @FXML
    private ComboBox<?> cbTerrain;
    String f;
    int index = -1, terrain=-1;
    ReservationCrud rc = new ReservationCrud();
    ObservableList listReserv = FXCollections.observableArrayList();
    Reservation r = null;
    Proprietaire c = new Proprietaire(1);
    Client cli = new Client(6);
    String role="client";
    Terrain pt=new Terrain(1, "t11", "nouveau terrain11");
    
    @FXML
    private TableColumn<Reservation, String> colAct;
    @FXML
    private Button btnRefresh1;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(role=="complexe")
        listReserv=rc.afficherResComplexe(c);
        else if (role=="client")
            listReserv = rc.afficherResClient(cli);
        loadTable();
        loadCbxFiltre();
        
        
    }    
    
    public void loadTable(){
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        //colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));  
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
        colTerrain.setCellValueFactory(new PropertyValueFactory<>("terrain"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));      
        
        ActButton();
        tab_reservation.setItems(listReserv);
        
    }
    public void ActButton(){
        Callback<TableColumn<Reservation, String>, TableCell<Reservation, String>> cellFoctory = (TableColumn<Reservation, String> param) -> {

            final TableCell<Reservation, String> cell = new TableCell<Reservation, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        
                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            r=tab_reservation.getSelectionModel().getSelectedItem();
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setContentText("Voulez vous vraiment supprimer cette réservation ?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                rc.supprimerReservation(r);
                            } else {
                                
                            }                                                     
                            loadTable();

                        });
                        
                        HBox managebtn = new HBox( deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                                                
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        colAct.setCellFactory(cellFoctory);
    }
    
    
    public void filtre(){
        
    }
    
    public void loadCbxFiltre(){
        ObservableList filtre = FXCollections.observableArrayList();
        filtre.add("Terrain");
        filtre.add("Date");
        cbFiltre.setItems(filtre); 
        cbTerrain.setVisible(false);
        datePick.setVisible(false);
        
    }

    @FXML
    private void selectItem(MouseEvent event) {
        index = tab_reservation.getSelectionModel().getSelectedIndex();
        if(index <=-1)
            return ;
        else
        {
            System.out.println("bravo");
        }
        
    }

    @FXML
    private void selectFiltre(MouseEvent event) {
                
    }

    @FXML
    private void selectF(ActionEvent event) {
        terrain = -1;
        datePick.setValue(LocalDate.now());
        index = cbFiltre.getSelectionModel().getSelectedIndex();
        if(index<=-1)
            return;
        else{
            f=cbFiltre.getSelectionModel().getSelectedItem().toString();
            System.out.println(f);
            if(f=="Terrain"){
                cbTerrain.setVisible(true);
                datePick.setVisible(false);
                TerrainCrud tc = new TerrainCrud();
                ObservableList lstTerrains = FXCollections.observableArrayList();
                lstTerrains.clear();
                lstTerrains.add("Tous");
                lstTerrains.addAll(tc.getAllComp(c.getIdUser()));
                cbTerrain.setItems(lstTerrains);
            }
            else {
                cbTerrain.setVisible(false);
                datePick.setVisible(true);
            }
        }
    }

    @FXML
    private void chercher(ActionEvent event) {
        
        if(f=="Terrain"){
            if(terrain>-1){
                if(role=="client")
                {
                    listReserv.clear();
                    Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
                    listReserv=rc.affResClientTerrain(cli, ttt);
                    loadTable();

                }
                else if (role=="complexe")
                {
                    listReserv.clear();
                    Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
                    listReserv=rc.affResClientTerrain(cli, ttt);
                    loadTable();
                    System.out.println("c'est bien");
                }
                
            }}
            else if(f=="Date"){
                LocalDate d = datePick.getValue();
                System.out.println(d.toString());
                //listReserv=rc.affResDate(d.toString());
                loadTable();
            }
      
    
    }

    @FXML
    private void selectTerrain(ActionEvent event) {
        //Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
        //terrain = ttt.getId();
        if (role=="complexe"){
            if(cbTerrain.getSelectionModel().getSelectedIndex()!=-1 
                    && cbTerrain.getSelectionModel().getSelectedIndex()!=0){
            Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();         
            listReserv= rc.afficherResTerrain(pt);
            }
            else {
                listReserv=rc.afficherResComplexe(c);
                loadTable(); 
            }
        }
            
        else if (role=="client"){  
                        if(cbTerrain.getSelectionModel().getSelectedIndex()!=-1 
                    && cbTerrain.getSelectionModel().getSelectedIndex()!=0){
            Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
            listReserv.clear();
            listReserv= rc.affResClientTerrain(cli, ttt);
            loadTable();
                        }     
            else {
                listReserv.clear();
            listReserv=rc.afficherResClient(cli);
            loadTable();
                        }                         
        }         
    }

    @FXML
    private void refresh(ActionEvent event) {
        listReserv=rc.afficherReservations();
        loadTable();
    }
    
    public void alertInf(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Réservation ajoutée avec succes !" );

        alert.showAndWait();
    }

    @FXML
    private void cherchDate(ActionEvent event) {
        LocalDate d = datePick.getValue();
        listReserv.clear();
       // listReserv=rc.affResDate(d.toString());
        loadTable();
    }
    
    
    
}
