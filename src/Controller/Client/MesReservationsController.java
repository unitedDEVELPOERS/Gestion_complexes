/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import entities.AcceptationReservation;
import entities.Client;
import entities.Reservation;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.AcceptationReservationCrud;
import services.ClientCrud;
import services.ReservationCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class MesReservationsController implements Initializable {

    @FXML
    private TableView<Reservation> tableReservations;
    @FXML
    private TableColumn<Reservation, Date> colDate;
    @FXML
    private TableColumn<Reservation, LocalTime> colHeure;
    @FXML
    private TableColumn<Reservation, String> colTerrain;
    @FXML
    private TableColumn<Reservation, Double> colMontant;

    ReservationCrud rc = new ReservationCrud();
    ObservableList listReserv = FXCollections.observableArrayList();
    AcceptationReservationCrud arc = new AcceptationReservationCrud();
    ObservableList listDecisions = FXCollections.observableArrayList();
    ClientCrud cc = new ClientCrud();
    List<Client> listMembres = new ArrayList();
      
List <AcceptationReservation> l = new ArrayList();  
List <String> ll = new ArrayList();
    
    Reservation r = null;
    Client cl = new Client(31,3);
    @FXML
    private Button btnAccepter;
    @FXML
    private Button btnAnnuler;
    @FXML
    private JFXDatePicker datePick;
    @FXML
    private JFXTimePicker timePick;
    @FXML
    private JFXTextField tfTerrain;
    @FXML
    private JFXTextField tfPart;
    @FXML
    private ListView<?> listViewInvitations;
    @FXML
    private JFXTextField tfMontant;
    @FXML
    private Label j1;
    @FXML
    private Label j2;
    @FXML
    private Label j9;
    @FXML
    private Label j6;
    @FXML
    private Label j3;
    @FXML
    private Label j10;
    @FXML
    private Label j4;
    @FXML
    private Label j7;
    @FXML
    private Label j5;
    @FXML
    private Label j8;
    @FXML
    private Label d1;
    @FXML
    private Label d2;
    @FXML
    private Label d9;
    @FXML
    private Label d6;
    @FXML
    private Label d3;
    @FXML
    private Label d10;
    @FXML
    private Label d4;
    @FXML
    private Label d7;
    @FXML
    private Label d5;
    @FXML
    private Label d8;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listReserv=rc.afficherResEquipe(cl);
        
        loadTable();
        listViewInvitations.setItems(listReserv);
    }    
    
    public void loadTable(){        
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));          
        colTerrain.setCellValueFactory(new PropertyValueFactory<>("terrain"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant")); 
        
             
        
//        ActButton();
        tableReservations.setItems(listReserv);
        
    }

    @FXML
    private void selectReservation(MouseEvent event) {
        r=tableReservations.getSelectionModel().getSelectedItem();
        tfTerrain.setText(r.getTerrain().toString());
        datePick.setValue(LocalDate.parse(r.getDate_reservation().toString()));
        timePick.setValue(r.getHeure());
        System.out.println(cl.getIdUser());
        
                
    }

    @FXML
    private void btnAccepter(ActionEvent event) {
        if(r!=null){
            AcceptationReservation ar = new AcceptationReservation(r,cl,true);
            if (arc.find(r,cl)==null)
            {
                arc.addConfirmation(ar);
                
            }
            else 
                arc.modifierReservation(ar);
        
        
        listReserv.clear();
         listReserv=rc.afficherinvitations(cl);
        loadTable();
        if(cc.getEquipe(cl.getEquipe()).size()==arc.findReservation(r).size())
            r.setConfirmee(true);
        }
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        if(r!=null){
        AcceptationReservation ar = new AcceptationReservation(r,cl,false);
//        if (arc.find(r,cl)==null)
//            {
                arc.addConfirmation(ar);
                
//            }
//            else 
//                arc.modifierReservation(ar);
        
        listReserv.clear();
         listReserv=rc.afficherinvitations(cl);
        loadTable();
        }
    }

    @FXML
    private void selectInvitation(MouseEvent event) {
        r=(Reservation) listViewInvitations.getSelectionModel().getSelectedItem();
        tfTerrain.setText(r.getTerrain().toString());
        datePick.setValue(LocalDate.parse(r.getDate_reservation().toString()));
        timePick.setValue(r.getHeure());
        System.out.println(r);
        afficherDetailsMembres();
        
        
    }
    
    private void afficherDetailsMembres(){
     listMembres = cc.getListMembres(cl.getEquipe());
        for(Client c : listMembres)
        {
            for(AcceptationReservation acp : l)            
        {
            if(!listMembres.contains(acp.getClient()))
            {
                ll.add(c.getNom()+" "+c.getPrenom()+"    En attente");
            }
            else if(acp.isAcceptee())
            {
                ll.add(c.getNom()+" "+c.getPrenom()+"    Accepte");
            }
            else if(!acp.isAcceptee())
            {
                ll.add(c.getNom()+" "+c.getPrenom()+"    Refuse");
            }
        }
            
        }
        System.out.println("mmmmmmmmmm "+ll);
              
        
        
        
        
    }
    
}
