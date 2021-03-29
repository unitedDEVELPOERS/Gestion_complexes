///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui.terrain;
//
//import Controller.Admin.AddTerrainController;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXDatePicker;
//import com.jfoenix.controls.JFXTimePicker;
//import com.jfoenix.svg.SVGGlyphLoader;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import entities.Categorie;
//import entities.Complexe;
//import entities.Reservation;
//import entities.Terrain;
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
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
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.Border;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Text;
//import javafx.stage.FileChooser;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//import services.CategorieCrud;
//import services.ReservationCrud;
//import services.TerrainCrud;
//
///**
// * FXML Controller class
// *
// * @author ahmed
// */
//public class ListeTerrainsController implements Initializable {
//
//    @FXML
//    private TableView<Terrain> tableTerrain;
//    @FXML
//    private TableColumn<Terrain, Integer> colId;
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
//    private TextField tfr;
//    Date datRes=null;
//    
//    
//    
//    String seance="";
//    Terrain ter = null;
//ObservableList listTerrains = FXCollections.observableArrayList();
//TerrainCrud tc = new TerrainCrud();
//ObservableList listReservations = FXCollections.observableArrayList();
//    ReservationCrud rcrud = new ReservationCrud();
//
//    @FXML
//    private AnchorPane paneDetails;
//    @FXML
//    private Text lbDesignation;
//    @FXML
//    private Label lbOuv;
//    @FXML
//    private Label lbFerm;
//    @FXML
//    private JFXDatePicker datePick;
//    private SplitPane splite;
//    @FXML
//    private TextArea taDescription;
//    @FXML
//    private Button btnRetour;
//    @FXML
//    private Button btnNouveau;
//    @FXML
//    private SplitPane spliteList;
//    @FXML
//    private AnchorPane paneNouveau;
//    @FXML
//    private TextField tfNom;
//    @FXML
//    private TextField tfImage;
//    @FXML
//    private ComboBox<?> cbGouvernorat;
//    private ComboBox<?> cbDelagation;
//    @FXML
//    private ComboBox<?> cbLocalite;
//    @FXML
//    private TextArea taDesc;
//    @FXML
//    private TextField tfPrix;
//    @FXML
//    private JFXButton btnImage;
//    @FXML
//    private JFXTimePicker timeOuvert;
//    @FXML
//    private JFXTimePicker timeFerm;
//    @FXML
//    private JFXButton btnEnregistrer;
//    @FXML
//    private Pane ancheAlert;
//    @FXML
//    private ComboBox<?> cbCategorie;
//    
//    CategorieCrud cCrud = new CategorieCrud();
//    Categorie categ=null;
//    int idCateg = -1;
//    String msg;
//    String gouv="";
//    String deleg, localite;
//    
//    String nom = "";        
//        String desc = "";
//        
//        Categorie ca = null;
//        
//        //int indGouv = cbGouvernorat.getSelectionModel().getSelectedIndex();
//        //String deleg = cbDelagation.getSelectionModel().getSelectedItem().toString();
//        //String localite = cbLocalite.getSelectionModel().getSelectedItem().toString();
//        String image = "";
//        float prix ;
//        String hOuv = "";
//        String hFerm = "";
//        
//        Complexe c = new Complexe(1);
//    
//    @FXML
//    private ComboBox<?> cbDelegation;
//    @FXML
//    private ImageView img;
//    @FXML
//    private Label lbPrix;
//    @FXML
//    private Button btnRetour1;
//    @FXML
//    private Label s1;
//    @FXML
//    private Label s2;
//    @FXML
//    private Label s8;
//    @FXML
//    private Label s7;
//    @FXML
//    private Label s3;
//    @FXML
//    private Label s4;
//    @FXML
//    private Label s5;
//    @FXML
//    private Label s6;
//    @FXML
//    private Label s9;
//    
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        loadTable();
//        CategorieCrud ccc= new CategorieCrud();
//        Categorie c1=ccc.find(1);
//        System.out.println(c1);
//    }  
//    ///**************Liste Terrains****************///
//    public void loadTable(){
//        paneDetails.setVisible(false);
//        paneNouveau.setVisible(false);
//        listTerrains.clear();
//        listTerrains=tc.getAll();
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colNom.setCellValueFactory(new PropertyValueFactory<>("designation"));
//        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix_location"));
//        colHOuv.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
//        colHFerm.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
//        ActButton();
//        tableTerrain.setItems(listTerrains);
//}
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
//                        FontAwesomeIconView showIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        
//                        deleteIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#ff1744;"
//                        );
//                        editIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#00E676;"
//                        );
//                        showIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#00E676;"
//                        );
//                        showIcon.setOnMouseClicked((MouseEvent event) -> {
////                            System.out.println("icone show"); 
////                            ter=tableTerrain.getSelectionModel().getSelectedItem();
////                            afficherTerrain();
////                            System.out.println(ter);
//                            Terrain te=new Terrain();
//                            te=tableTerrain.getSelectionModel().getSelectedItem();
//                            afficherDetails(te);
//                            System.out.println(ter);
//
//                        });
//                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
//                            ter=tableTerrain.getSelectionModel().getSelectedItem();
//                            Alert alert = new Alert(AlertType.CONFIRMATION);
//                            alert.setTitle("Confirmation Dialog");
//                            //alert.setHeaderText("Look, a Confirmation Dialog");
//                            alert.setContentText("Voulez vous vraiment suppriter ce terrain ?");
//
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK){
//                                tc.supprimerTerrain(ter);
//                            } else {
//                                // ... user chose CANCEL or closed the dialog
//                            }
//                            
//                            loadTable();
//
//                        });
//                        editIcon.setOnMouseClicked((MouseEvent event) -> {
//                            
//                            System.out.println("icone edit");
//                            ter = tableTerrain.getSelectionModel().getSelectedItem();
//                            System.out.println(ter);
//                            modifierTerrain();
//                            msg="modifié";
//
//                        });
//
//                        HBox managebtn = new HBox(showIcon, editIcon, deleteIcon);
//                        managebtn.setStyle("-fx-alignment:center");
//                        
//                        HBox.setMargin(showIcon, new Insets(2, 3, 0, 2));
//                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
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
//
//
//    public void afficherDetails(Terrain ter){
//        try {
//            
//            // REDIRECTION
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsTerrain.fxml"));
//            Parent root = (Parent)loader.load();
//            Stage stage = new Stage();
//            
//            DetailsTerrainController dtc = loader.getController();
//            dtc.setTerrain(ter);
//            stage.setScene(new Scene(root));
//            stage.show();
//            
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void afficherTerrain(){
//        spliteList.setVisible(false);
//        lbDesignation.setText(ter.getDesignation());
//        lbOuv.setText(ter.getHeure_ouverture());
//        lbFerm.setText(ter.getHeure_fermeture());
//        taDescription.setText(ter.getDescription());
//        datePick.setValue(LocalDate.now());
//        Image image = new Image(getClass().getResourceAsStream(ter.getImage()));
//        img.setImage(image);
//        
//        paneDetails.setVisible(true);
//                
//    }
//    
//    public void vv(){
//        try{
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("AddTerrain.fxml"));
//            Parent root = loader.load();
//            AddTerrainController pdc = loader.getController();
////            pdc.setContNom(rNom);//injecter les variables du premier formulaire
////            pdc.setContPrenom(rPrenom);
//            tfNom.getScene().setRoot(root);
//            
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void modifierTerrain(){
//        spliteList.setVisible(false);
//        tfNom.setText(ter.getDesignation());
//        nom=ter.getDesignation();
//        cbCategorie.setPromptText(ter.getCategorie().toString());
//        categ=ter.getCategorie();
//        taDesc.setText(ter.getDescription());
//        desc=ter.getDescription();
//        cbGouvernorat.setPromptText(ter.getAdresse());
//        gouv=ter.getAdresse();
//        tfImage.setText(ter.getImage());
//        image=ter.getImage();
//        tfPrix.setText(Float.toString(ter.getPrix_location()));
//        prix=ter.getPrix_location();
//        timeOuvert.setPromptText(ter.getHeure_ouverture());
//        hOuv=ter.getHeure_ouverture();
//        timeFerm.setPromptText(ter.getHeure_fermeture());
//        hFerm=ter.getHeure_fermeture();
//        paneNouveau.setVisible(true);
//                
//    }
//    
//    
//    
//    private boolean Supp(){
//        boolean supp = false;
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("Voulez vous vraiment supprimer ce terrain !");
//        alert.setTitle("Supprimer !");
//        alert.setHeaderText("Supprimer !");
//        Optional<ButtonType> result = alert.showAndWait();
//        if(result.isPresent() && result.get() == ButtonType.OK) {
//            supp = true;
//        }
//        return supp;
//    }
//
////    private void retour(ActionEvent event) {
////        paneDetails.setVisible(false);
////        spliteList.setVisible(true);
////    }
//
//    @FXML
//    private void nouveau(ActionEvent event) {
//        paneNouveau.setVisible(true);
//        spliteList.setVisible(false);
//        loadCbCategorie();
//        loadGouvernorat();
//        msg="ajouté";
//        
//    }
//    ///*****************************************///
//    
//    ///**************Ajouter Terrain****************///
//    
//    private void enregistrer(ActionEvent event) {
//
//        String nom = tfNom.getText();        
//        String  desc = taDesc.getText();        
//        Categorie ca = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
//        String gouv = cbGouvernorat.getSelectionModel().getSelectedItem().toString();
//        String image = tfImage.getText();
//        float prix =Float.parseFloat(tfPrix.getText());
//        String hOuv = timeOuvert.getValue().toString();
//        String hFerm = timeFerm.getValue().toString();       
//        if(nom.length()==0 || ca==null || desc.length()==0 || gouv.length()==0 || image.length()==0 || prix<=0 || hOuv.length()==0 || hFerm.length()==0)
//            alerte();
////        else{
////            Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
////            TerrainCrud tCrud = new TerrainCrud();            
////            tCrud.ajouterTerrain(terrain);            
////            alertInf(msg);
////            vider();
////        }
//                                     
//    
//    }
//    
//    //private void handleButtonAction(Action)
//    public void alerte(){
//        Stage stage=(Stage)ancheAlert.getScene().getWindow();
//        Alert.AlertType type = Alert.AlertType.INFORMATION;
//        Alert alert = new Alert(type,"");
//        alert.initModality(Modality.APPLICATION_MODAL);
//        alert.initOwner(stage);
//        alert.getDialogPane().setContentText("Tous les champs sont obligatoires !");
//        alert.getDialogPane().setHeaderText("Attention !");
//        alert.showAndWait();
//        
//    }
//    
//    public void alertInf(String msg){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Terrain "+ msg + " avec succes !" );
//
//        alert.showAndWait();
//    }
//    public void vider(){
//        tfNom.clear();        
//        taDesc.clear();
//        cbGouvernorat.setPromptText("Gouvernorat");
//        cbDelagation.setPromptText("Delegation");
//        cbLocalite.setPromptText("Localité");
//        tfImage.clear();
//        tfPrix.clear();
//        //timeOuvert.setPromptText("");
//        
//        
//    }
//
//    @FXML
//    private void selectImage(ActionEvent event) {
//        FileChooser fc = new FileChooser();
//        File selectedFile = fc.showOpenDialog(null);
//        if(selectedFile != null){
//            tfImage.setText(selectedFile.getPath());
//        }
//    }
//    
//    
//    public void loadCbCategorie(){
//        ObservableList categories = FXCollections.observableArrayList();
//        categories=cCrud.getAll();
//        
//        cbCategorie.setItems(categories);       
//    }
//    
//    public void loadGouvernorat(){
//        ObservableList gouvs = FXCollections.observableArrayList();
//        gouvs.addAll("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan");
//        cbGouvernorat.setItems(gouvs); 
//    }
//
//    @FXML
//    private void setCategorie(ActionEvent event) {
//        categ = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
//        idCateg = categ.getId();
//       if(idCateg<=-1)
//            return;
//
//    }
//    
//    
//
//    @FXML
//    private void retourDetails(ActionEvent event) {
//        paneDetails.setVisible(false);
//        paneNouveau.setVisible(false);
//        spliteList.setVisible(true);
//    }
//
//    @FXML
//    private void retourNouveau(ActionEvent event) {
//        paneDetails.setVisible(false);
//        paneNouveau.setVisible(false);
//        spliteList.setVisible(true);
//    }
//    
//    
//    public void rr(){
//        try {
//            
//            //2- REDIRECTION
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("ListeTerrains.fxml"));
//            Parent root = loader.load();
//            ListeTerrainsController pdc = loader.getController();
//            
//            tfNom.getScene().setRoot(root);
//            
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @FXML
//    private void ajoutTerrain(ActionEvent event) {
// nom = tfNom.getText();        
//desc = taDesc.getText();        
//ca = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
//       
//int i = cbGouvernorat.getSelectionModel().getSelectedIndex();
//    gouv = cbGouvernorat.getSelectionModel().getSelectedItem().toString();
//     
//image = tfImage.getText();
//    if(tfPrix.getText().length()!=0)
//prix =Float.parseFloat(tfPrix.getText());
//    System.out.println("mmm: "+nom+desc+ca+gouv+image+prix);
//hOuv = timeOuvert.getValue().toString();
//hFerm = timeFerm.getValue().toString();       
//if(nom.length()==0 || ca==null || desc.length()==0 || i==-1||  image.length()==0 || prix<=0 || hOuv.length()==0 || hFerm.length()==0)
//
//    alerte();
//
//else{
//    Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
//    TerrainCrud tCrud = new TerrainCrud();         
//    if(msg=="ajouté"){
//        tCrud.ajouterTerrain(terrain); 
//            
//    }
//    else 
//        tCrud.modifierTerrain(terrain); 
//                       
//}
//    alertInf(msg);
//    paneDetails.setVisible(false);
//        paneNouveau.setVisible(false);
//        spliteList.setVisible(true);
//return;
//
//    }
//
//    @FXML
//    private void selectSeance(MouseEvent event) {
//        
//        seance=s1.getText();
//        System.out.println(seance);
//    }
//    
//    public void refrechSeances(){
//        //listReservations = rcrud.affResDateTime(ter, (java.sql.Date) datRes);
//        
//    }
//
//    @FXML
//    private void refrechListSeances(ActionEvent event) {
//        //datRes=(datePick.getValue().toString();
//        System.out.println(listReservations.size());
//    }
//    
//}
