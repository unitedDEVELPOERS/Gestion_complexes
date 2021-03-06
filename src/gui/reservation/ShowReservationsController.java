/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Client;
import entities.Complexe;
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
    private TableColumn<Reservation, Integer> colClient;
    @FXML
    private TableColumn<Reservation, Integer> colTerrain;
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
    Complexe c = new Complexe(1);
    @FXML
    private TableColumn<Reservation, String> colAct;
    @FXML
    private Button btnRefresh1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listReserv=rc.afficherReservations();
        loadTable();
        loadCbxFiltre();
    }    
    
    public void loadTable(){
        //listReserv.clear();
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
        colTerrain.setCellValueFactory(new PropertyValueFactory<>("terrain"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));      

         ActButton();
        tab_reservation.setItems(listReserv);
        
    }
    public void ActButton(){
        Callback<TableColumn<Reservation, String>, TableCell<Reservation, String>> cellFoctory = (TableColumn<Reservation, String> param) -> {
            // make cell containing buttons
            final TableCell<Reservation, String> cell = new TableCell<Reservation, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        FontAwesomeIconView showIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        
                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        showIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        showIcon.setOnMouseClicked((MouseEvent event) -> {
//                            System.out.println("icone show");  
//                           
//                            r=tab_reservation.getSelectionModel().getSelectedItem();
//                            System.out.println(r.getClient().getNom());
//                            System.out.println(r.getTerrain().getDesignation());

                          

                        });
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            r=tab_reservation.getSelectionModel().getSelectedItem();
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            //alert.setHeaderText("Look, a Confirmation Dialog");
                            alert.setContentText("Voulez vous vraiment suppriter ce terrain ?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                rc.supprimerReservation(r);
                            } else {
                                // ... user chose CANCEL or closed the dialog
                            }                                                     
                            loadTable();
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
//                            System.out.println("icone edit");                          
                        });

                        HBox managebtn = new HBox(showIcon, editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        
                        HBox.setMargin(showIcon, new Insets(2, 3, 0, 2));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
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
                lstTerrains=tc.getAllComp(1);
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
                listReserv.clear();
                Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
                listReserv=rc.afficherResTerrain(ttt);
                loadTable();
                System.out.println("c'est bien");
            }}
            else if(f=="Date"){
                LocalDate d = datePick.getValue();
                System.out.println(d.toString());
            }
      
    
    }

    @FXML
    private void selectTerrain(ActionEvent event) {
        Terrain ttt=(Terrain) cbTerrain.getSelectionModel().getSelectedItem();
        terrain = ttt.getId();
        if(terrain<=-1)
            return;
        else{
            
            System.out.println(terrain);
            System.out.println(ttt);
           
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
    
    
    
}
