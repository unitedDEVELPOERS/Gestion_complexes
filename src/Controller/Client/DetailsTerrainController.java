///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui.terrain;
//
//import Controller.Admin.AddTerrainController;
//import com.jfoenix.controls.JFXDatePicker;
//import entities.Client;
//import entities.Proprietaire;
//import entities.Reservation;
//import entities.Terrain;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Platform;
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
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.Region;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import org.controlsfx.control.Notifications;
//import services.ReservationCrud;
//import services.TerrainCrud;
//
///**
// * FXML Controller class
// *
// * @author ahmed
// */
//public class DetailsTerrainController implements Initializable {
//
//    @FXML
//    private ImageView img;
//    @FXML
//    private Text lbDesignation;
//    @FXML
//    private Label lbOuv;
//    @FXML
//    private Label lbFerm;
//    @FXML
//    private Label lbPrix;
//    private JFXDatePicker datePick;
//
//    @FXML
//    private TextArea taDescription;
//    private Button btnRetour;
//    
//    ObservableList listReservations = FXCollections.observableArrayList();
//    ReservationCrud rcrud = new ReservationCrud();
//    Client cl = new Client(6);
//    Terrain terrain=null;
//    TerrainCrud tc=new TerrainCrud();
//    Proprietaire comp = new Proprietaire(1);
//    String parent  ;
//        
//    /**
//     * Initializes the controller class.
//     */
//    List<String> l = new ArrayList();
//    private MyListener myListener;
//    //String seance = "";
//    int s=0;
//    @FXML
//    private Button s2;
//    @FXML
//    private Button s6;
//    @FXML
//    private Button s5;
//    @FXML
//    private Button s3;
//    @FXML
//    private Button s4;
//    @FXML
//    private Button s1;
//    @FXML
//    private Button s7;
//    @FXML
//    private Button s8;
//    @FXML
//    private Button s9;
//    @FXML
//    private Button btnReserver;
//    int i;
//    @FXML
//    private Label lbAdresse;
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
////       LocalDate d = LocalDate.now();
////       datePick.setPromptText(d.toString());
////        System.out.println(d.toString());
//        
//        //if(rcrud.affHeuresTerrainDate(terrain, d.toString()).size()>0)           
//        //l=rcrud.affHeuresTerrainDate(terrain, d.toString());
//        //l=rcrud.affHeuresRes(terrain);
//        //List<Integer> lst= new ArrayList();
////        List<Reservation> ls =rcrud.getAll(d.toString());
//        //listReservations=rcrud.afficherResTerrain(terrain);
////        List<Integer> l2= new ArrayList();
////        for(Reservation rs : ls){
////            if(rs.getTerrain()==terrain)
////                l2.add(rs.getHeure());
////        }
////        if(ls.size()>0)
////        System.out.println(ls);
////        else System.out.println("videee");
////        System.out.println(l2.size());
//      
//        
//    }    
//    
//    
//    public void setParent(String p) {
//        parent = p;
//        if(parent=="TerrainsList")
//            btnReserver.setVisible(false);
//        System.out.println(parent);
//        
//        
//    }
//    public void setTerrain(Terrain t) {
//        terrain=t;
////        System.out.println(t);
////        System.out.println(t.getId());
//        //i=t.getId();
//        
//         //lbComplexe.setText(comp.getRaison());
//        //txtTitre.setText(terrain.getComplexe().getRaison());
//        lbDesignation.setText(terrain.getDesignation());
//        taDescription.setText(terrain.getDescription());
//        lbOuv.setText(terrain.getHeure_ouverture());
//        lbFerm.setText(terrain.getHeure_fermeture());
//        lbAdresse.setText(terrain.getAdresse());        
//        Image image = new Image(getClass().getResourceAsStream(terrain.getImage()));
//        
////        img.setFitWidth(430);
////        img.setFitHeight(250);
//        img.setImage(image);
//        listReservations= rcrud.afficherResTerrain(terrain);
//        //l=rcrud.affHeuresTerrainDate(terrain, Date.valueOf(LocalDate.now()));
//        l=rcrud.affHeuresTerrainDate(terrain,LocalDate.now().toString());
//        //System.out.println(listReservations.size());
//        if(l.contains("6"))            
//            s1.setDisable(true);
//        if(l.contains("8")) 
//            s2.setDisable(true);
//        if(l.contains("10")) 
//            s3.setDisable(true);
//        if(l.contains("12")) 
//            s4.setDisable(true);
//        if(l.contains("14")) 
//            s5.setDisable(true);
//        if(l.contains("16")) 
//            s6.setDisable(true);
//        if(l.contains("18")) 
//            s7.setDisable(true);
//        if(l.contains("20")) 
//            s8.setDisable(true);
//        if(l.contains("22")) 
//            s9.setDisable(true);
//        
//        
//        
//        
//    }
//
//
//    @FXML
//    private void s2(ActionEvent event) {
//        s=8;
//    }
//
//    @FXML
//    private void s6(ActionEvent event) {
//        s=16;
//    }
//
//    @FXML
//    private void s5(ActionEvent event) {
//        s=14;
//    }
//
//    @FXML
//    private void s3(ActionEvent event) {
//        s=10;
//    }
//
//    @FXML
//    private void s4(ActionEvent event) {
//        s=12;
//    }
//
//    @FXML
//    private void s1(ActionEvent event) {
//        s=6;
//    }
//
//    @FXML
//    private void s7(ActionEvent event) {
//        s=18;
//    }
//
//    @FXML
//    private void s8(ActionEvent event) {
//        s=20;
//    }
//
//    @FXML
//    private void s9(ActionEvent event) {
//        s=22;
//    }
//
//    @FXML
//    private void reserver(ActionEvent event) {
//        if(s!=0){
//            //Date d = new Date(2020,12,03);
//            Reservation r = new Reservation();
//        //Terrain t= new Terrain(2,"terrain foot", "terrain premier crée");
//        //Client j = new Client(6);
//        //r.setDate_creation(Date.valueOf(datePick.getValue());
//        r.setTerrain(terrain);
//        r.setValidee(true);
//        LocalDate d = datePick.getValue();
//        r.setDate_reservation(Date.valueOf(datePick.getValue()));
//        r.setHeure(s);
//        r.setClient(cl);
//        //r.setId(6);
//        r.setMontant(150);
//        ReservationCrud rc=new ReservationCrud();
//        rc.addReservation(r);
//        alertInf();
//        Notifications.create().title("titre texte").text("Une réservation a été enregistrer pour votre équipe").showInformation();
//        envoyerMail();
//        
//        Stage s = (Stage)btnReserver.getScene().getWindow();        
//        s.close();
//         }
//        
//    }
//    
//    public void alertInf(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Votre réservation est enregistrée avec succes !" );
//
//        alert.showAndWait();
//    }
//
//    private void refSeances(ActionEvent event) {
//        LocalDate d = datePick.getValue();
//        System.out.println(d.toString());
//        List<String> l2 =rcrud.affHeuresTerrainDate(terrain, d.toString());
//        if(l2.contains("6") || l2.contains(6))            
//            s1.setDisable(true);
//        else     s1.setDisable(false);
//        if(l2.contains("8") || l2.contains(8)) 
//            s2.setDisable(true);
//        else     s2.setDisable(false);
//        if(l2.contains("10") || l2.contains(10)) 
//            s3.setDisable(true);
//        else     s3.setDisable(false);
//        if(l2.contains("12") || l2.contains(12)) 
//            s4.setDisable(true);
//        else     s4.setDisable(false);
//        if(l2.contains("14") || l2.contains(14)) 
//            s5.setDisable(true);
//        else     s5.setDisable(false);
//        if(l2.contains("16") || l2.contains(16)) 
//            s6.setDisable(true);
//        else     s6.setDisable(false);
//        if(l2.contains("18") || l2.contains(18)) 
//            s7.setDisable(true);
//        else     s7.setDisable(false);
//        if(l2.contains("20") || l2.contains(20)) 
//            s8.setDisable(true);
//        else     s8.setDisable(false);
//        if(l2.contains("22") || l2.contains(22))
//            s9.setDisable(true);
//        else     s9.setDisable(false);
//    }
//
//    public void alertMail(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Email envoyé");
//        alert.setHeaderText(null);
//        alert.setContentText("Les membres de ton équipe sont informés de votre votre réservation!" );
//
//        alert.showAndWait();
//    }
//    
//
//    public void envoyerMail(){
//        try {
//                
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
//        //Enable authentication
//        properties.put("mail.smtp.auth", "true");
//        //Set TLS encryption enabled
//        properties.put("mail.smtp.starttls.enable", "true");
//        //Set SMTP host
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        //Set smtp port
//        properties.put("mail.smtp.port", "587");
//
//        //Your gmail address
//        String myAccountEmail = "num.20746081@gmail.com";
//        //Your gmail password
//        String password = "Ahmed20746081";
//
//        //Create a session with account credentials
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccountEmail, password);
//            }
//        });
//
//        //Prepare email message
//        Message message = prepareMessage(session, myAccountEmail, recepient);
//
//        //Send mail
//        Transport.send(message);
//        System.out.println("Message sent successfully");
//    }
//
//    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAccountEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//            message.setSubject("Nouvelle réservation");
//            String htmlCode = "<h1> Votre réservation a été bien enregistré </h1>"
//                    + "<h3>Bienvenue chez nous :)</h3>";           
//            message.setContent(htmlCode, "text/html");
//            return message;
//        } catch (Exception ex) {
//            Logger.getLogger(AddTerrainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//}
//
//    @FXML
//    private void retour(ActionEvent event) {
//        if(parent=="TerrainsList"){
//            try{
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("TerrainsList.fxml"));
//            Parent root = loader.load();           
//            btnRetour.getScene().setRoot(root);
//            
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        else {
//            Stage s = (Stage)btnReserver.getScene().getWindow();        
//        s.close();
////            try{
////            FXMLLoader loader = new FXMLLoader(
////                    getClass().getResource("/gui/reservation/ShowReservations.fxml"));
////            Parent root = loader.load();           
////            btnRetour.getScene().setRoot(root);
////            
////            } catch (IOException ex) {
////                System.out.println(ex.getMessage());
////            }
//        }
//            
//    }
//
//
//    
//    
//    
//}
