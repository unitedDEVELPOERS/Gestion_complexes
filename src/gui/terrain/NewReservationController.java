/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Categorie;
import entities.Complexe;
import entities.Terrain;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.CategorieCrud;
import services.ComplexeCrud;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class NewReservationController implements Initializable {

    @FXML
    private JFXComboBox<?> cbVille;
    @FXML
    private JFXComboBox<?> cbCategorie;
    @FXML
    private JFXComboBox<?> cbComplexe;
    @FXML
    private JFXButton btnChercher;
    
    
    @FXML
    private TableColumn<Terrain, String> colNom;
    @FXML
    private TableColumn<Terrain, String> colCategorie;
    @FXML
    private TableColumn<Terrain, Double> colPrix;
    @FXML
    private TableColumn<Terrain, Time> colHOuv;
    @FXML
    private TableColumn<Terrain, Time> colHFerm;
    @FXML
    private TableColumn<Terrain, String> colAct;
    @FXML
    private JFXButton btnRefrech;
    @FXML
    private TableView<Terrain> tableTerrain;
    @FXML
    private TableColumn<Terrain, String> colVille;
    Terrain ter=null;
    ObservableList listTerrains = FXCollections.observableArrayList();
    TerrainCrud tc = new TerrainCrud();
    ObservableList listReservations = FXCollections.observableArrayList();
    ReservationCrud rcrud = new ReservationCrud();
    CategorieCrud cCrud = new CategorieCrud();
    @FXML
    private Text txtTitre;
    
    @FXML
    private TableColumn<?, ?> cloVille;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listTerrains=tc.getAll();
        loadTable();
        loadCbVille();
        loadCbCategorie();
        loadCbComplexes();
    }    
    
    public void loadTable(){
        
        //listTerrains.clear();
        //
        //colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("designation"));
        colVille.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix_location"));
        colHOuv.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
        colHFerm.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
        ActButton();
        
        tableTerrain.setItems(listTerrains);
    }

    public void afficherDetails(Terrain ter){
        try {
            
            // REDIRECTION
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsTerrain.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = new Stage();
            
            DetailsTerrainController dtc = loader.getController();
            dtc.setTerrain(ter);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ActButton(){
        Callback<TableColumn<Terrain, String>, TableCell<Terrain, String>> cellFoctory = (TableColumn<Terrain, String> param) -> {
            // make cell containing buttons
            final TableCell<Terrain, String> cell = new TableCell<Terrain, String>() {
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
                            Terrain te=new Terrain();
                            te=tableTerrain.getSelectionModel().getSelectedItem();
                            afficherDetails(te);
                            System.out.println(ter);

                        });
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            ter=tableTerrain.getSelectionModel().getSelectedItem();
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            //alert.setHeaderText("Look, a Confirmation Dialog");
                            alert.setContentText("Voulez vous vraiment suppriter ce terrain ?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                tc.supprimerTerrain(ter);
                            } else {
                                // ... user chose CANCEL or closed the dialog
                            }
                            
                            loadTable();

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            System.out.println("icone edit");
                            ter = tableTerrain.getSelectionModel().getSelectedItem();
                            System.out.println(ter);
                            
                            

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


    @FXML
    private void chercher(ActionEvent event) {
        if(cbVille.getSelectionModel().getSelectedIndex()!=-1 && cbCategorie.getSelectionModel().getSelectedIndex()!=-1){
            String ville = cbVille.getSelectionModel().getSelectedItem().toString();
            Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();           
            listTerrains= tc.getAllVilleCategorie(ville, c);
            loadTable();
        }
        else if (cbCategorie.getSelectionModel().getSelectedIndex()!=-1){
            Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();            
            listTerrains=tc.getAllCategorie(c);
            loadTable();
        }
        else if(cbComplexe.getSelectionModel().getSelectedIndex()!=-1){
            Complexe comp=(Complexe)cbComplexe.getSelectionModel().getSelectedItem();
            listTerrains=tc.getAllComp(comp.getId());
            loadTable();
        }
    }
    
    public void loadGouvernorat(){
        ObservableList gouvs = FXCollections.observableArrayList();
        gouvs.addAll("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan");
        cbVille.setItems(gouvs); 
    }
    
    public void loadCbComplexes(){
        ObservableList listComplexes = FXCollections.observableArrayList();
        ComplexeCrud compCrud = new ComplexeCrud();
        listComplexes = compCrud.AfficherComplexes();
        cbComplexe.setItems(listComplexes);
    }
    
    public void loadCbCategorie(){
        ObservableList categories = FXCollections.observableArrayList();
        categories=cCrud.getAll();        
        cbCategorie.setItems(categories);       
    }
    public void loadCbVille(){
        ObservableList villes = FXCollections.observableArrayList();
        villes.addAll("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan");
        cbVille.setItems(villes);
    } 

    @FXML
    private void refrechir(ActionEvent event) {
        listTerrains.clear();
        listTerrains=tc.getAll();
        tableTerrain.setItems(listTerrains);
    }
}
