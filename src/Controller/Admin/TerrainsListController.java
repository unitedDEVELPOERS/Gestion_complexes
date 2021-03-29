/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Categorie;
import entities.Client;
import entities.Proprietaire;
import entities.Reservation;
import entities.Terrain;
//import gui.terrain.DetailsTerrainController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jdk.nashorn.internal.runtime.JSType;
import services.CategorieCrud;
import services.ClientCrud;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TerrainsListController implements Initializable {

    @FXML
    private TableView<Terrain> tableTerrain;
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
    private TextField tfr;
    Date datRes=null;
    ObservableList listTerrains = FXCollections.observableArrayList();
    ObservableList listReservations = FXCollections.observableArrayList();
    TerrainCrud tc = new TerrainCrud();
    ReservationCrud rc = new ReservationCrud();
    String seance="";
    Terrain terrain = null;
    Proprietaire c = new Proprietaire(30);
    String nom ;        
        String desc ;        
        Categorie ca;
        String gouv;
        String localite;
        String image;
        double prix;
        LocalTime hOuv;
        LocalTime hFerm;
    Path from;
    Path to;
    
    private BorderPane bp;
    
    private Button btnNouveau;
    @FXML
    private Pane paneDetails;
    @FXML
    private ImageView img;
    @FXML
    private TableView<Reservation> tableReservations;
    @FXML
    private TableColumn<Reservation, String> colClient;
    @FXML
    private TableColumn<Reservation, Date> colDate;
    @FXML
    private TableColumn<Reservation, Integer> colHeure;
    private TableColumn<Reservation, Integer> colEtat;
    @FXML
    private Text lbDesignation;
    @FXML
    private Label lbOuv;
    @FXML
    private Label lbFerm;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbAdresse;
    @FXML
    private Text txt;
    @FXML
    private Button btnEditer;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnAfficher;
    @FXML
    private JFXDatePicker datePick;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfImage;
    @FXML
    private JFXTextArea taDesc;
    @FXML
    private TextField tfPrix;
    @FXML
    private JFXTimePicker timeOuvert;
    @FXML
    private JFXTimePicker timeFerm;
    @FXML
    private ComboBox<?> cbCategorie;
    @FXML
    private ComboBox<?> cbGouvernorat;
    @FXML
    private AnchorPane paneUpdate;
    @FXML
    private Button btnAjouter;
    @FXML
    private AnchorPane paneAdd;
    @FXML
    private ComboBox<?> cbGouvernoratAdd;
    @FXML
    private Pane paneList;
    @FXML
    private Pane paneFoot;
    @FXML
    private Button btnNosTerrains;
    @FXML
    private Pane paneHead;
    @FXML
    private Button btnImageUpdate;
    @FXML
    private Button btnImageAdd;
    @FXML
    private ComboBox<?> cbCategorieAdd;
    @FXML
    private TextField tfImageAdd;
    @FXML
    private TextField tfNomAdd;
    @FXML
    private JFXTextArea taDescAdd;
    @FXML
    private TextField tfPrixAdd;
    @FXML
    private JFXTimePicker timeOuvertAdd;
    @FXML
    private JFXTimePicker timeFermAdd;
    @FXML
    private Button btnEnregistrerAdd;
    @FXML
    private TextField tfLocaliteAdd;
    @FXML
    private Button btnEnregistrerUpdate;
    @FXML
    private TextField tfLocaliteUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        loadCbCategorie();
        loadGouvernorat();
//        System.out.println(c);
//        
//        
        loadTable();
       System.out.println(tc.find(2));
    }    
    
    public void init(){
        terrain=null;
        btnNosTerrains.setVisible(false);
        btnAjouter.setVisible(true);
        paneDetails.setVisible(false);
        paneAdd.setVisible(false);
        paneUpdate.setVisible(false);
        paneList.setVisible(true);
        paneFoot.setVisible(true);
    }

    public void edit(){
        
    }
//    private void nouveau(ActionEvent event) {
//        nouveauTerrain();
//    
//    }
    
    public void loadTable(){        
        listTerrains.clear();
        listTerrains=tc.getAllComp(c.getIdUser());
        colNom.setCellValueFactory(new PropertyValueFactory<>("designation"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix_location"));
        colHOuv.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
        colHFerm.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
        //ActButton();
        tableTerrain.setItems(listTerrains);
    }
    
    public void loadTableReservation(){        
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        colHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
 
        tableReservations.setItems(listReservations);
    }
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
//                        Button btnAfficher = new Button();
//                        btnAfficher.setStyle("-fx-background-color: #ccf5ff; -fx-background-radius: 30;");
//                        Image imgAfficher = new Image("@../../img/eye.png");
//                        ImageView view = new ImageView(imgAfficher);
//                        view.setFitHeight(30);
//                        view.setFitWidth(30);
//                        view.setPreserveRatio(true);
//                        btnAfficher.setGraphic(view);
//                        
//                        Button btnEditer = new Button();
//                        btnEditer.setStyle("-fx-background-color: #b3ffb3; -fx-background-radius: 30;");
//                        Image imgEditer = new Image("@../../img/edit.png");
//                        ImageView view1 = new ImageView(imgEditer);
//                        view1.setFitHeight(30);
//                        view1.setFitWidth(30);
//                        view1.setPreserveRatio(true);
//                        btnEditer.setGraphic(view1);
//                        
//                        Button btnSupprimer = new Button();
//                        btnSupprimer.setStyle("-fx-background-color: #ffb3b3; -fx-background-radius: 30;");
//                        Image imgSupprimer = new Image("@../../img/trash.png");
//                        ImageView view2 = new ImageView(imgSupprimer);
//                        view2.setFitHeight(30);
//                        view2.setFitWidth(30);
//                        view2.setPreserveRatio(true);
//                        btnSupprimer.setGraphic(view2);
//                        
//                        FontAwesomeIconView showIcon = new FontAwesomeIconView(FontAwesomeIcon.EYE);
//                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        
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
//                        
//                        showIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#00E676;"
//                        );
//                                            
//                        showIcon.setOnMouseClicked((MouseEvent event) -> {
//                            System.out.println("btn ll cliqué");                            
//                            terrain=tableTerrain.getSelectionModel().getSelectedItem();
//                            //afficherDetails(terrain);
//
//                        });
//                        
//                        
//                        editIcon.setOnMouseClicked((MouseEvent event) -> {
//                            terrain = tableTerrain.getSelectionModel().getSelectedItem();
//                            System.out.println(terrain);
//                            //modifierDetails(terrain);
//                        });
//                        
//                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
//                            terrain=tableTerrain.getSelectionModel().getSelectedItem();
//                            System.out.println(terrain);
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            alert.setTitle("Confirmation Dialog");
//                            //alert.setHeaderText("Look, a Confirmation Dialog");
//                            alert.setContentText("Voulez vous vraiment suppriter ce terrain ?");
//
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK){
//                                tc.supprimerTerrain(terrain);
//                            } else {
//                                // ... user chose CANCEL or closed the dialog
//                            }
//                            
//                            loadTable();
//
//                        });
//
//                        
//
//                        HBox managebtn = new HBox(btnAfficher, btnEditer, btnSupprimer);
//                        //HBox managebtn = new HBox(showIcon, editIcon, deleteIcon);
//                        managebtn.setStyle("-fx-alignment:center");
//                        HBox.setMargin(showIcon, new Insets(2, 3, 0, 2));
//                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
//                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
//                        HBox.setMargin(btnEditer, new Insets(2, 2, 0, 3));
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
      
     
//    public void modifierDetails(Terrain ter){
//        try {            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/UpdateTerrain.fxml"));
//            Parent root = loader.load();
//                    
//            UpdateTerrainController utc = loader.getController();
//            utc.setTerrain(ter);
//            
//            //tableTerrain.getScene().setRoot(root);          
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//    }
    
//    public void afficherDetails(Terrain ter){
//        try {            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/TerrainDetails.fxml"));
//            Parent root = loader.load();
//            
//            Stage stage = new Stage();
//            stage.initStyle(StageStyle.UNDECORATED);
////            AddTerrainController pdc = loader.getController();
////            btnNouveau.getScene().setRoot(root);
//            stage.setScene(new Scene(root));
//            stage.show();          
//            TerrainDetailsController tdc = loader.getController();
//            tdc.setTerrain(ter);
//            
//            //tableTerrain.getScene().setRoot(root);          
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//    }
    
    
    
//    public void nouveauTerrain(){
//        //loadPage("/gui/Admin/AddTerrain");        
//    }
//    public void nosTerrains(){
//       // loadPage("/gui/Admin/TerrainsList");       
//    }
     
     

    private void nouveauT(ActionEvent event) {
//        nouveauTerrain();
    }

//    private void selectTerrain(MouseEvent event) {
////        LocalDate d = datePick.getValue();
////        listReservations.clear();
////        listReservations=rc.affResDate(d.toString());
////        loadTableReservation();
////ter=tableTerrain.getSelectionModel().getSelectedItem();
////        System.out.println(ter);
//        //modifierDetails(ter);
//       // loadPage("/gui/Admin/AddTerrain");    
//    }
    
    public void nouveauTerrain(){
        try{
            FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/gui/Admin/AddTerrain.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
//            AddTerrainController pdc = loader.getController();
//            btnNouveau.getScene().setRoot(root);
            stage.setScene(new Scene(root));
            stage.show();            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void selectionnerTerrain(MouseEvent event) {
        terrain=tableTerrain.getSelectionModel().getSelectedItem();
       System.out.println("terrain list : "+terrain);
//        modifierDetails(terrain);
    }

    @FXML
    private void btnEditer(ActionEvent event) {
        if(tableTerrain.getSelectionModel().getSelectedIndex()!=-1){
        System.out.println(terrain);
        modifierTerrain(terrain);
        
        }        
    }

    @FXML
    private void btnSupprimer(ActionEvent event) {
        if(tableTerrain.getSelectionModel().getSelectedIndex()!=-1){
        terrain=tableTerrain.getSelectionModel().getSelectedItem();
        System.out.println(terrain);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Voulez vous vraiment suppriter ce terrain ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {tc.supprimerTerrain(terrain);
        init();
        loadTable();
        terrain=null;
        }
        
        
        }
    }

    @FXML
    private void btnAfficher(ActionEvent event) {
        if(tableTerrain.getSelectionModel().getSelectedIndex()!=-1){
        System.out.println("terrain list aff : "+terrain);
        afficherTerrain(terrain);
        listReservations.clear();
        listReservations=rc.afficherResTerrain(terrain);
        if(listReservations.size()>0)
        loadTableReservation();
        btnAjouter.setVisible(false);
        btnNosTerrains.setVisible(true);
        paneDetails.setVisible(true);
        paneAdd.setVisible(false);
        paneUpdate.setVisible(false);
        paneList.setVisible(false);
        //paneFoot.setVisible(false);
        }
    }





    public void afficherTerrain(Terrain terrain){
        listReservations = rc.afficherResTerrain(terrain);   
        lbDesignation.setText(terrain.getDesignation());
        txt.setText(terrain.getDescription());
        lbOuv.setText(terrain.getHeure_ouverture().toString());
        lbFerm.setText(terrain.getHeure_fermeture().toString());
        lbAdresse.setText(terrain.getAdresse());        
        Image image = new Image(getClass().getResourceAsStream(terrain.getImage()),413,183,false,false);        
        img.setImage(image);
        lbPrix.setText(Double.toString(terrain.getPrix_location()));
}
    
    public void modifierTerrain(Terrain t) {       
        System.out.println("Update terrain ");
        this.terrain=t;
        System.out.println(terrain);
        tfNom.setText(terrain.getDesignation());
        nom=terrain.getDesignation();
        cbCategorie.setPromptText(terrain.getCategorie().getDesignation());
        ca=terrain.getCategorie();
        taDesc.setText(terrain.getDescription()); 
        desc=terrain.getDescription();
        
        String[] adr = terrain.getAdresse().split(" - ");
        gouv = adr[0];
        localite = adr[1];
        cbGouvernorat.setPromptText(gouv);
        tfLocaliteUpdate.setText(localite);
       
        tfImage.setText(terrain.getImage());
        image=terrain.getImage();
        tfPrix.setText(Double.toString(terrain.getPrix_location()));
        prix=terrain.getPrix_location();
        timeOuvert.setValue(terrain.getHeure_ouverture());
        hOuv=terrain.getHeure_ouverture();
        timeFerm.setValue(terrain.getHeure_fermeture());
        hFerm=terrain.getHeure_fermeture();
        System.out.println("id :"+terrain.getId());
        btnNosTerrains.setVisible(true);
        btnAjouter.setVisible(false);
        paneList.setVisible(false);
        paneDetails.setVisible(false);
        paneAdd.setVisible(false);
        paneUpdate.setVisible(true);
    }

    
    @FXML
    public void loadGouvernorat(){
        ObservableList gouvs = FXCollections.observableArrayList();
        gouvs.addAll("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba", "Medenine", "Manastir", "Nabeul" ,"Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan");
        cbGouvernorat.setItems(gouvs); 
        cbGouvernoratAdd.setItems(gouvs); 
    }
    
    public void loadCbCategorie(){
        CategorieCrud cCrud = new CategorieCrud();
        ObservableList categories = FXCollections.observableArrayList();
        categories=cCrud.getAll();
        cbCategorie.setItems(categories);       
        cbCategorieAdd.setItems(categories);       
    }
    

    @FXML
    private void inputPrix(TouchEvent event) {
    }

    @FXML
    private void setCategorie(ActionEvent event) {
        if(cbCategorie.getSelectionModel().getSelectedIndex()!=-1)
            ca=(Categorie)cbCategorie.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void btnAjouter(ActionEvent event) {
//        nouveauTerrain();
        btnAjouter.setVisible(false);
        btnNosTerrains.setVisible(true);
        paneDetails.setVisible(false);
        paneUpdate.setVisible(false);
        paneList.setVisible(false);
        paneFoot.setVisible(false);
        paneAdd.setVisible(true);
        loadCbCategorie();
        loadGouvernorat();
    }

    @FXML
    private void btnNosTerrains(ActionEvent event) {
        init();
    }

    @FXML
    private void btnEnregistrerUpdate(ActionEvent event) {
        if(tfNom.getText().length()>0 && taDesc.getText().length()>0 && ca!=null
                && !gouv.isEmpty() &&
            tfImage.getText().length()>0 && tfPrix.getText().length()>0 && isNumeric(tfPrix.getText()) && timeOuvert.getValue()!=null && timeFerm.getValue()!=null)              
        {
            Terrain tt = new Terrain(terrain.getId(),tfNom.getText(), taDesc.getText(), gouv+" - "+ tfLocaliteUpdate.getText(), tfImage.getText(), Double.parseDouble(tfPrix.getText()),c,ca,timeOuvert.getValue(), timeFerm.getValue());
              terrain.setDesignation(tfNom.getText());
              terrain.setDescription(taDesc.getText());
              tt.setAdresse(gouv +" - "+ tfLocaliteUpdate.getText());
              terrain.setCategorie(ca);
              terrain.setImage(tfImage.getText());
              terrain.setPrix_location(Double.parseDouble(tfPrix.getText()));
              terrain.setHeure_ouverture(hOuv);
              terrain.setHeure_fermeture(hFerm);
        tc.modifierTerrain(tt); 
        alertInf("modifié");
        init();
        loadTable();
        }
        else if(tfNom.getText().length()==0) alerte("nom");
        else if(ca==null)
            alerte("categorie");
        else if (taDesc.getText().length()==0)
            alerte("description");
        else if(gouv==null)
            alerte("gouvernorat");
        else if (tfImage.getText().length()==0)
            alerte("image");
        else if (tfPrix.getText().length()==0 || !isNumeric(tfPrix.getText()))
            alerte("prix de location");
        else if (timeOuvert.getValue()==null)
            alerte("heure d'ouverture");
        else if (timeFerm.getValue()==null)
            alerte("heure de fermeture");


////        if(tfNom.getText().length()>0 && taDesc.getText().length()>0 && cbCategorie.getSelectionModel().getSelectedIndex()!=-1
////                && cbGouvernorat.getSelectionModel().getSelectedIndex()!=-1 &&
////            tfImage.getText().length()>0 && tfPrix.getText().length()>0 && isNumeric(tfPrix.getText()) && timeOuvert.getValue()!=null && timeFerm.getValue()!=null)              
//        if(1==1)
//{
//             terrain = new Terrain(tfNom.getText(), desc, gouv, image, prix,c,ca,hOuv, hFerm);
//            //Terrain terrain = new Terrain(tfNom.getText(), desc, gouv, image, prix,c,ca,hOuv, hFerm);
//                  System.out.println("eeee**"+desc);
//        tc.modifierTerrain(terrain); 
//        alertInf("modifier");
//        loadTable();
//        }
//        else if(tfNom.getText().length()==0) alerte("nom");
//        else if(ca==null)
//            alerte("categorie");
//        else if (desc==null)
//            alerte("description");
//        else if(gouv==null)
//            alerte("gouvernorat");
//        else if (image==null)
//            alerte("image");
//        else if (prix<0 || !isNumeric(tfPrix.getText()))
//            alerte("prix de location");
//        else if (hOuv==null)
//            alerte("heure d'ouverture");
//        else if (hFerm==null)
//            alerte("heure de fermeture");


    }

    
    
    public void viderUpdate(){
        tfNom.clear();
        cbCategorie.getEditor().clear();
        taDesc.clear();
        cbGouvernorat.getEditor().clear();
        tfImage.clear();
        tfPrix.clear();
        timeOuvert.getEditor().clear();
        timeFerm.getEditor().clear();
    }
    public void viderAdd(){
        tfNomAdd.clear();
        cbCategorieAdd.getEditor().clear();
        taDescAdd.clear();
        cbGouvernoratAdd.getEditor().clear();
        tfImageAdd.clear();
        tfPrixAdd.clear();
        timeOuvertAdd.getEditor().clear();
        timeFermAdd.getEditor().clear();
    }
    
    public void alerte(String msg){       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attention !");
        alert.setContentText("Champ "+msg+ "obligatoire !");
        alert.showAndWait();

    }

    public void alertMail(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email envoyé");
        alert.setHeaderText(null);
        alert.setContentText("Vos clients seront informés de votre nouveau terrain!" );
        alert.showAndWait();
    }
    
    public void alertInf(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Terrain "+ msg + " avec succes !" );

        alert.showAndWait();
    }
    
    public void envoyerMail(){
        ClientCrud cc = new ClientCrud();
        ReservationCrud rc = new ReservationCrud();
                    
        for (Reservation rsv : rc.afficherResComplexe(c))
        {
        try {              
                sendMail(rsv.getClient().getEmail());

            } catch (Exception ex) {
                Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "num.20746081@gmail.com";
        String password = "Ahmed20746081";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Nouveau terrain pour vous");
            String htmlCode = "<h1> Nous mettons à votre disposition un nouveau terrain</h1>"
                    + "<h3>Bienvenue chez nous :)</h3>";           
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    @FXML
    private void btnEnregistrerAdd(ActionEvent event) {
        if(tfNomAdd.getText().length()>0 && taDescAdd.getText().length()>0 && cbCategorieAdd.getSelectionModel().getSelectedIndex()!=-1
            && cbGouvernoratAdd.getSelectionModel().getSelectedIndex()!=-1 
            && tfImageAdd.getText().length()>0 && tfPrixAdd.getText().length()>0 && isNumeric(tfPrixAdd.getText()) && timeOuvertAdd.getValue()!=null && timeFermAdd.getValue()!=null && tfLocaliteAdd.getText().length()!=0)              
        {
            Terrain terrain = new Terrain(tfNomAdd.getText(), taDescAdd.getText(), cbGouvernoratAdd.getSelectionModel().getSelectedItem().toString()+" - "+tfLocaliteAdd.getText(), tfImageAdd.getText(), Double.parseDouble(tfPrixAdd.getText()),c,(Categorie)cbCategorieAdd.getSelectionModel().getSelectedItem(),timeOuvertAdd.getValue(), timeFermAdd.getValue());
                  
        tc.ajouterTerrain(terrain); 
        alertInf("ajouté");
        alertMail();
        init();
        envoyerMail();
        
        loadTable();
        }
        else if(tfNomAdd.getText().length()==0) alerte("nom");
        else if(cbCategorieAdd.getSelectionModel().getSelectedIndex()==-1)
            alerte("categorie");
        else if (taDescAdd.getText().length()==0)
            alerte("description");
        else if(cbGouvernoratAdd.getSelectionModel().getSelectedIndex()==-1)
            alerte("gouvernorat");
        else if(tfLocaliteAdd.getText().length()==0)
            alerte("localité");
        else if (tfImageAdd.getText().length()==0)
            alerte("image");
        else if (tfPrixAdd.getText().length()==0 || !isNumeric(tfPrixAdd.getText()))
            alerte("prix de location");
        else if (timeOuvertAdd.getValue()==null)
            alerte("heure d'ouverture");
        else if (timeFermAdd.getValue()==null || timeFermAdd.getValue().compareTo(timeOuvertAdd.getValue())<=0)
            alerte("heure de fermeture");


    }

    public static boolean isNumeric(String str) {
 
        if (str == null || str.length() == 0) {
            return false;
        }
 
        try {
            Double.parseDouble(str);
            return true;
 
        } catch (NumberFormatException e) {
            return false;
        }
 
    }
    
    @FXML
    private void selectImageUpdate(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        String fn=selectedFile.getName();
        String ext = fn.substring(fn.lastIndexOf("."));
        if(selectedFile != null){
            if(ext.equals(".jpg")||ext.equals(".png")||ext.equals(".jpeg")||ext.equals(".JPG")||ext.equals(".PNG")||ext.equals(".JPEG")){            
            tfImage.setText("/images/"+selectedFile.getName());
            System.out.println(selectedFile.getPath());
            from = Paths.get(selectedFile.toURI());
            to = Paths.get("C:\\Users\\ahmed\\OneDrive\\Documents\\NetBeansProjects\\Gestion_complexes\\src\\images\\"+selectedFile.getName());
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            try {
                Files.copy(from, to, options);
            }catch (IOException ex) {
                Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @FXML
    private void selectImageAdd(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        String fn=selectedFile.getName();
        String ext = fn.substring(fn.lastIndexOf("."));
        if(selectedFile != null){
            if(ext.equals(".jpg")||ext.equals(".png")||ext.equals(".jpeg")||ext.equals(".JPG")||ext.equals(".PNG")||ext.equals(".JPEG")){            
//            image im = new Image()
                tfImageAdd.setText("/images/"+selectedFile.getName());
            System.out.println(selectedFile.getPath());
            from = Paths.get(selectedFile.toURI());
            to = Paths.get("C:\\Users\\ahmed\\OneDrive\\Documents\\NetBeansProjects\\Gestion_complexes\\src\\images\\"+selectedFile.getName());
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            try {
                Files.copy(from, to, options);
            }catch (IOException ex) {
                Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @FXML
    private void datePickDetails(ActionEvent event) {
        LocalDate d = datePick.getValue();    
        Date date = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        listReservations.clear();
        listReservations=rc.affResDateTerrain(terrain, new java.sql.Date(date.getTime()));
        loadTableReservation();
        System.out.println(terrain);
    }

    @FXML
    private void setVille(ActionEvent event) {
        if(cbGouvernorat.getSelectionModel().getSelectedIndex()!=-1)
            gouv=cbGouvernorat.getSelectionModel().getSelectedItem().toString();
    }

}