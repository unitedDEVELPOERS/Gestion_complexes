///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui.terrain;
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXComboBox;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import entities.Categorie;
//import entities.Proprietaire;
//import entities.Terrain;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Time;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.geometry.Insets;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//import services.CategorieCrud;
//import services.ProprietaireCrud;
//import services.ReservationCrud;
//import services.TerrainCrud;
//
///**
// * FXML Controller class
// *
// * @author ahmed
// */
//public class NewReservationController implements Initializable {
//
//    @FXML
//    private JFXComboBox<?> cbVille;
//    @FXML
//    private JFXComboBox<?> cbCategorie;
//    @FXML
//    private JFXComboBox<?> cbComplexe;
//    @FXML
//    private JFXButton btnChercher;    
//    @FXML
//    private TableColumn<Terrain, String> colNom;
//    @FXML
//    private TableColumn<Terrain, String> colCategorie;
//    @FXML
//    private TableColumn<Terrain, Double> colPrix;
//    @FXML
//    private TableColumn<Terrain, Time> colHOuv;
//    @FXML
//    private TableColumn<Terrain, Time> colHFerm;
//    @FXML
//    private TableColumn<Terrain, String> colAct;
//    @FXML
//    private JFXButton btnRefrech;
//    @FXML
//    private TableView<Terrain> tableTerrain;
//    @FXML
//    private TableColumn<Terrain, String> colVille;
//    @FXML
//    private Text txtTitre;
//    
//    
//    Terrain ter=null;
//    ObservableList listComplexes = FXCollections.observableArrayList();
//    ObservableList categories = FXCollections.observableArrayList();
//    ObservableList villes = FXCollections.observableArrayList();
//    ObservableList listTerrains = FXCollections.observableArrayList();
//    TerrainCrud tc = new TerrainCrud();
//    ObservableList listReservations = FXCollections.observableArrayList();
//    ReservationCrud rcrud = new ReservationCrud();
//    
//    Proprietaire comp = new Proprietaire(1);
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        listTerrains=tc.getAll();
//        loadTable();
//        loadCbVille();
//        loadCbCategorie();
//        loadCbComplexes();
//    }    
//    
//    public void loadTable(){   
//        colNom.setCellValueFactory(new PropertyValueFactory<>("designation"));
//        colVille.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix_location"));
//        colHOuv.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
//        colHFerm.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));         
//        ActButton();
//        
//        tableTerrain.setItems(listTerrains);
//    }
//
//    public void afficherDetails(Terrain ter){
//        try {            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsTerrain.fxml"));
//            Parent root = (Parent)loader.load();
//            Stage stage = new Stage();            
//            DetailsTerrainController dtc = loader.getController();
//            dtc.setTerrain(ter);           
//            stage.setScene(new Scene(root));
//            stage.show();            
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void ActButton(){
//        Callback<TableColumn<Terrain, String>, TableCell<Terrain, String>> cellFoctory = (TableColumn<Terrain, String> param) -> {
//            // make cell containing buttons
//            final TableCell<Terrain, String> cell = new TableCell<Terrain, String>() {
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    //that cell created only on non-empty rows
//                    if (empty) {
//                        setGraphic(null);
//                        setText(null);
//
//                    } else {
//                        FontAwesomeIconView showIcon = new FontAwesomeIconView(FontAwesomeIcon.ADN);
//                        
//                        
//                        showIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#00E676;"
//                        );
//                        showIcon.setOnMouseClicked((MouseEvent event) -> {
//                            Terrain te=new Terrain();
//                            ter=tableTerrain.getSelectionModel().getSelectedItem();
//                            afficherDetails(ter);
//                            System.out.println(ter);
//
//                        });
//                        
//                        
//
//                        HBox managebtn = new HBox(showIcon);
//                        managebtn.setStyle("-fx-alignment:center");
//                        
//                        HBox.setMargin(showIcon, new Insets(2, 3, 0, 2));
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
//
//
//    @FXML
//    private void chercher(ActionEvent event) {
//        if(cbVille.getSelectionModel().getSelectedIndex()!=-1 && cbCategorie.getSelectionModel().getSelectedIndex()!=-1){
//            String ville = cbVille.getSelectionModel().getSelectedItem().toString();
//            Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();           
//            listTerrains= tc.getAllVilleCategorie(ville, c);
//            loadTable();
//        }
//        else if (cbCategorie.getSelectionModel().getSelectedIndex()!=-1){
//            Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();            
//            listTerrains=tc.getAllCategorie(c);
//            loadTable();
//        }
//        else if(cbComplexe.getSelectionModel().getSelectedIndex()!=-1){
//            Proprietaire comp=(Proprietaire)cbComplexe.getSelectionModel().getSelectedItem();
//            listTerrains=tc.getAllComp(comp.getIdUser());
//            loadTable();
//        }
//    }
//    
//    
//    
//    public void loadCbComplexes(){
//        listComplexes.clear();
//        ProprietaireCrud compCrud = new ProprietaireCrud();
//        listComplexes.add("Tous");
//        listComplexes.addAll(compCrud.readAll());        
//        cbComplexe.setItems(listComplexes);
//    }
//    
//    public void loadCbCategorie(){
//        categories.clear(); 
//        CategorieCrud cCrud = new CategorieCrud();
//        categories.add("Toutes");
//        categories.addAll(cCrud.getAll());    
//        cbCategorie.setItems(categories);       
//    }
//    public void loadCbVille(){
//        villes.clear();
//        villes.addAll("Toutes", "Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan", "Sfax");
//        cbVille.setItems(villes);
//    } 
//
//    @FXML
//    private void refrechir(ActionEvent event) {
//        listTerrains.clear();
//        listTerrains=tc.getAll();
//        tableTerrain.setItems(listTerrains);
//        loadCbVille();       
//        loadCbCategorie();        
//        loadCbComplexes();
//        
//    }
//
//    @FXML
//    private void cherchVille(ActionEvent event) {
//        if(cbVille.getSelectionModel().getSelectedIndex()!=-1 && cbVille.getSelectionModel().getSelectedIndex()!=0){
//            String ville = cbVille.getSelectionModel().getSelectedItem().toString();
//            //Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();           
//            listTerrains= tc.getAllVille(ville);
//        }
//        else 
//            listTerrains=tc.getAll();
//        loadTable();       
//    }
//
//    @FXML
//    private void cherchCategorie(ActionEvent event) {
//        if (cbCategorie.getSelectionModel().getSelectedIndex()!=-1 
//                && cbCategorie.getSelectionModel().getSelectedIndex()!=0 
//                && cbVille.getSelectionModel().getSelectedIndex()!=-1){
//            String ville = cbVille.getSelectionModel().getSelectedItem().toString();
//            Categorie c = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();            
//            listTerrains=tc.getAllVilleCategorie(ville,c);
//          
//        }
//        else if (cbVille.getSelectionModel().getSelectedIndex()==-1)
//            listTerrains= tc.getAllCategorie((Categorie)cbCategorie.getSelectionModel().getSelectedItem());
//        else
//            listTerrains=tc.getAll();
//            loadTable();
//    }
//
//    @FXML
//    private void cherchComplexe(ActionEvent event) {
//        if( cbComplexe.getSelectionModel().getSelectedIndex()!=-1 
//                && cbComplexe.getSelectionModel().getSelectedIndex()!=0
//                && cbCategorie.getSelectionModel().getSelectedIndex()!=-1){
//            Proprietaire comp=(Proprietaire)cbComplexe.getSelectionModel().getSelectedItem();
//            listTerrains=tc.getAllCompCategorie(comp.getIdUser(), (Categorie)cbCategorie.getSelectionModel().getSelectedItem());
//        }
//        else if (cbCategorie.getSelectionModel().getSelectedIndex()==-1)
//            listTerrains= tc.getAllComp(comp.getIdUser());
//        else listTerrains = tc.getAll();
//            loadTable();
//    }
//    
//}
