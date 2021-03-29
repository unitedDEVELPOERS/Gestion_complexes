//    /*
//    * To change this license header, choose License Headers in Project Properties.
//    * To change this template file, choose Tools | Templates
//    * and open the template in the editor.
//    */
//    package Controller.Admin;
//
//    import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXTextArea;
//    import com.jfoenix.controls.JFXTimePicker;
//    import entities.Categorie;
//    import entities.Proprietaire;
//    import entities.Terrain;
//    import java.io.File;
//    import java.io.IOException;
//    import java.net.URL;
//import java.nio.file.CopyOption;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//    import java.sql.Time;
//    import java.time.LocalTime;
//    import java.util.Arrays;
//    import java.util.Calendar;
//    import java.util.Date;
//    import java.util.HashSet;
//    import java.util.Locale;
//    import java.util.Properties;
//    import java.util.ResourceBundle;
//    import java.util.Set;
//    import java.util.logging.Level;
//    import java.util.logging.Logger;
//    import javafx.collections.FXCollections;
//    import javafx.collections.ObservableList;
//    import javafx.event.ActionEvent;
//    import javafx.fxml.FXML;
//    import javafx.fxml.FXMLLoader;
//    import javafx.fxml.Initializable;
//    import javafx.scene.Parent;
//    import javafx.scene.control.Alert;
//    import javafx.scene.control.Alert.AlertType;
//    import javafx.scene.control.Button;
//    import javafx.scene.control.ComboBox;
//    import javafx.scene.control.TextArea;
//    import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//    import javafx.scene.input.MouseEvent;
//    import javafx.scene.input.TouchEvent;
//    import javafx.scene.layout.AnchorPane;
//import java.nio.file.Path ;
//import java.nio.file.StandardCopyOption;
//import javafx.scene.text.Text;
//    import javafx.stage.FileChooser;
//    import javafx.stage.Modality;
//    import javafx.stage.Stage;
//    import javax.mail.Authenticator;
//    import javax.mail.Message;
//    import javax.mail.PasswordAuthentication;
//    import javax.mail.Session;
//    import javax.mail.Transport;
//    import javax.mail.internet.InternetAddress;
//    import javax.mail.internet.MimeMessage;
//    import org.controlsfx.control.Notifications;
//    import org.controlsfx.control.action.Action;
//    import org.controlsfx.control.textfield.AutoCompletionBinding;
//    //import org.controlsfx.control.textfield.AutoCompletionBinding;
//    import org.controlsfx.control.textfield.TextFields;
//    import services.CategorieCrud;
//    import services.TerrainCrud;
//
//    /**
//    * FXML Controller class
//    *
//    * @author ahmed
//    */
//    public class AddTerrainController implements Initializable {
//
//    @FXML
//    private TextField tfNom;
//    @FXML
//    private TextField tfImage;
//    private TextField tfGouvernorat;
//    private TextField tfDelegation;
//    private TextField tfLocalite;
//    @FXML
//    private JFXTextArea taDesc;
//    @FXML
//    private TextField tfPrix;
//
//    private TextField tfCategorie;
//    @FXML
//    private Button btnImage;
//    @FXML
//    private JFXTimePicker timeOuvert;
//    @FXML
//    private JFXTimePicker timeFerm;
//    @FXML
//    private Button btnEnregistrer;
//    TerrainCrud tCrud = new TerrainCrud();
//    CategorieCrud cCrud = new CategorieCrud();
//    Categorie categ=null;
//    int idCateg = -1;
//    String msg = "ajouté";
//    Proprietaire c = new Proprietaire(30);
//    Terrain terrain = null;
//
//    private String nom = "";        
//    private String desc = "";        
//    private Categorie ca = null;
//    private String gouv = "";
//    private String image = "";
//    private double prix =0;
//    private String hOuv ="";
//    private String hFerm = "";  
//
//
//    private AnchorPane ancheAlert;
//    @FXML
//    private ComboBox<?> cbCategorie;
//    @FXML
//    private ComboBox<?> cbGouvernorat;
//    private Button btnRetour;
//    @FXML
//    private AnchorPane paneUpdate;
//    @FXML
//    private ImageView btnClose;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//        loadCbCategorie();
//        loadGouvernorat();
//
//    }
//
//    public void setMessage(String m){
//        msg=m;
//        System.out.println(msg);
//        System.out.println(terrain);
//
//    }
//
//    public void setTerrain(Terrain t) {
//        terrain=t;
//        System.out.println(terrain);
//        msg="modifié";
//        nom=terrain.getDesignation();
//        tfNom.setText(terrain.getDesignation());
//        ca=terrain.getCategorie();
//        cbCategorie.setPromptText(terrain.getCategorie().getDesignation());
//        desc=terrain.getDescription();
//        taDesc.setText(terrain.getDescription());        
//        String[] adr = terrain.getAdresse().split(" ");
//        gouv= adr[0];
//        cbGouvernorat.setPromptText(gouv);
//        image=terrain.getImage();
//        tfImage.setText(terrain.getImage());
//        prix=terrain.getPrix_location();
//        tfPrix.setText(Double.toString(terrain.getPrix_location()));
//        hOuv=terrain.getHeure_ouverture();
//        timeOuvert.setPromptText(terrain.getHeure_ouverture());
//        hFerm=terrain.getHeure_fermeture();
//        timeFerm.setPromptText(terrain.getHeure_fermeture());
//        System.out.println("id :"+terrain.getId());
//    }
//
//
//
//    public void redir(){
//        try{
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("GestionTerrains.fxml"));
//            Parent root = loader.load();
//            tfNom.getScene().setRoot(root);
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//    }
//
//    @FXML
//    public void loadGouvernorat(){
//        ObservableList gouvs = FXCollections.observableArrayList();
//        gouvs.addAll("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba", "Medenine", "Manastir", "Nabeul" ,"Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan");       
//        cbGouvernorat.setItems(gouvs); 
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
//
//
//    public void alerte(){       
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Attention !");
//        alert.setContentText("Tous les champs sont obligatoires !");
//        alert.showAndWait();
//
//    }
//
//    public void alertMail(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Email envoyé");
//        alert.setHeaderText(null);
//        alert.setContentText("Vos clients sont informés de votre nouveau terrain!" );
//        alert.showAndWait();
//    }
//
//    public void vider(){
//        tfNom.clear();
//        tfCategorie.clear();
//        taDesc.setText("");
//        tfGouvernorat.clear();
//        tfDelegation.clear();
//        tfLocalite.clear();
//        tfImage.clear();
//        tfPrix.clear();
//
//
//    }
//
//    @FXML
//    private void selectImage(ActionEvent event) {                    
//        FileChooser fc = new FileChooser();
//        File selectedFile = fc.showOpenDialog(null);
//        String fn=selectedFile.getName();
//        String ext = fn.substring(fn.lastIndexOf("."));
//        if(selectedFile != null){
//            if(ext.equals(".jpg")||ext.equals(".png")||ext.equals(".jpeg")||ext.equals(".JPG")||ext.equals(".PNG")||ext.equals(".JPEG")){            
//            tfImage.setText("/images/"+selectedFile.getName());
//            System.out.println(selectedFile.getPath());
//            Path from = Paths.get(selectedFile.toURI());
//            Path to = Paths.get("C:\\Users\\ahmed\\OneDrive\\Documents\\NetBeansProjects\\Gestion_complexes\\src\\images\\"+selectedFile.getName());
//            CopyOption[] options = new CopyOption[]{
//                StandardCopyOption.REPLACE_EXISTING,
//                StandardCopyOption.COPY_ATTRIBUTES
//            };
//            try {
//                Files.copy(from, to, options);
//            }catch (IOException ex) {
//                Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
//        }
//    }
//
//
//    public void loadCbCategorie(){
//        ObservableList categories = FXCollections.observableArrayList();
//        categories=cCrud.getAll();
//        cbCategorie.setItems(categories);       
//    }
//
//
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
//    private void ajouterTerrain(ActionEvent event) {
//        
//        try{
//        nom = tfNom.getText();        
//        desc = taDesc.getText();        
//        ca = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
//
//        int i = cbGouvernorat.getSelectionModel().getSelectedIndex();
//        gouv = cbGouvernorat.getSelectionModel().getSelectedItem().toString();
//
//        image = tfImage.getText();
//        prix =Float.parseFloat(tfPrix.getText());
//        System.out.println("mmm: "+nom+desc+ca+gouv+image+prix);
//        hOuv = timeOuvert.getValue().toString();
//        hFerm = timeFerm.getValue().toString();  
//
////        if(nom.isEmpty() || desc.isEmpty() || ca==null || gouv.isEmpty() ||
////            image.isEmpty() || prix<=0 || hOuv.isEmpty() || hFerm.isEmpty())
////               alerte(); 
//        if(!nom.isEmpty() && !desc.isEmpty() && ca!=null && !gouv.isEmpty() &&
//            !image.isEmpty() && prix>0 && !hOuv.isEmpty() && !hFerm.isEmpty())
//                
//        {
//        Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
//        TerrainCrud tCrud = new TerrainCrud();         
//        if(msg=="ajouté"){
//        tCrud.ajouterTerrain(terrain); 
//        alertInf("ajouté");
//        envoyerMail();
//        retour(event);
//        }
//        else { 
//        terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
//        tCrud.modifierTerrain(terrain); 
//        alertInf("modifié");
//        retour(event);
//        }}
//        else alerte();
////        else{
////        Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
////        TerrainCrud tCrud = new TerrainCrud();         
////        if(msg=="ajouté"){
////        tCrud.ajouterTerrain(terrain); 
////        alertInf("ajouté");
////        envoyerMail();
////        retour(event);
////        }
////        else { 
////        terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
////        tCrud.modifierTerrain(terrain); 
////        alertInf("modifié");
////        retour(event);
////        }
//    
//
//    }catch(Exception ex){
//            System.out.println(ex.getMessage());
//    }
//
//
//
//
//
//    }
//
//
//    public void envoyerMail(){
//        try {              
//                sendMail("ahmedhajsaid@gmail.com");
//                alertMail();
//            } catch (Exception ex) {
//                Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
//
//    public static void sendMail(String recepient) throws Exception {
//        System.out.println("Preparing to send email");
//        Properties properties = new Properties();
//
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        String myAccountEmail = "num.20746081@gmail.com";
//        String password = "Ahmed20746081";
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccountEmail, password);
//            }
//        });
//
//        Message message = prepareMessage(session, myAccountEmail, recepient);
//
//        Transport.send(message);
//        System.out.println("Message sent successfully");
//    }
//
//    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAccountEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//            message.setSubject("Nouveau terrain pour vous");
//            String htmlCode = "<h1> Nous mettons à votre disposition un nouveau terrain</h1>"
//                    + "<h3>Bienvenue chez nous :)</h3>";           
//            message.setContent(htmlCode, "text/html");
//            return message;
//        } catch (Exception ex) {
//            Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @FXML
//    private void inputPrix(TouchEvent event) {
//
//    }
//
//
//    private float Float(String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void retour(ActionEvent event) {
//
//            try{
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("TerrainsList.fxml"));
//            Parent root = loader.load();           
//            btnRetour.getScene().setRoot(root);
//
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//
//    }
//
//    @FXML
//    private void btnEnregistrer(ActionEvent event) {
//        try{
//        nom = tfNom.getText();        
//        desc = taDesc.getText();        
//        ca = (Categorie)cbCategorie.getSelectionModel().getSelectedItem();
//
//        int i = cbGouvernorat.getSelectionModel().getSelectedIndex();
//        gouv = cbGouvernorat.getSelectionModel().getSelectedItem().toString();
//
//        image = tfImage.getText();
//        prix =Float.parseFloat(tfPrix.getText());
//        System.out.println("mmm: "+nom+desc+ca+gouv+image+prix);
//        hOuv = timeOuvert.getValue().toString();
//        hFerm = timeFerm.getValue().toString();  
//
////        if(nom.isEmpty() || desc.isEmpty() || ca==null || gouv.isEmpty() ||
////            image.isEmpty() || prix<=0 || hOuv.isEmpty() || hFerm.isEmpty())
////               alerte(); 
//        if(!nom.isEmpty() && !desc.isEmpty() && ca!=null && !gouv.isEmpty() &&
//            !image.isEmpty() && prix>0 && !hOuv.isEmpty() && !hFerm.isEmpty())
//                
//        {
//        Terrain terrain = new Terrain(nom, desc, gouv, image, prix,c,ca,hOuv, hFerm);
//        TerrainCrud tCrud = new TerrainCrud();         
//        if(msg=="ajouté"){
//        tCrud.ajouterTerrain(terrain); 
//        alertInf("ajouté");
//        Stage stage = (Stage) btnEnregistrer.getScene().getWindow();
//    stage.close();
//        envoyerMail();}
//        }
//        } catch (Exception ex) {
//            Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @FXML
//    private void btnClose(MouseEvent event) {
//        Stage stage = (Stage) btnEnregistrer.getScene().getWindow();
//    
//    stage.close();
//    }
//    
//
//
//    }
