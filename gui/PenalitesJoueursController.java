/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.PenaliteJoueur;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.MatchCRUD;
import services.PenaliteJoueurCRUD;
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author bezin
 */
public class PenalitesJoueursController implements Initializable {

    @FXML
    private ImageView SendingMail;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Button pdf;
    @FXML
    private ComboBox<?> choiceboxPenalite;
    @FXML
    private Label txPenalite;
    @FXML
    private Button Mail;
    @FXML
    private Button btnRetour;
    @FXML
    private TableView<PenaliteJoueur> tableList;
    @FXML
    private TableColumn<PenaliteJoueur, ?> JoueurC;
    @FXML
    private TableColumn<PenaliteJoueur, ?> PenaliteC;
    @FXML
    private TableColumn<?, ?> btnID;
    @FXML
    private TextField txId1;
    @FXML
    private TextField tfJoueur1;
    @FXML
    private Label joueur1;
     int index = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    consulterPenaliteJoueur();
    }

    void consulterPenaliteJoueur() {

        ObservableList listM = FXCollections.observableArrayList();
        PenaliteJoueurCRUD tc = new PenaliteJoueurCRUD();
        btnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        JoueurC.setCellValueFactory(new PropertyValueFactory<>("joueur"));
        PenaliteC.setCellValueFactory(new PropertyValueFactory<>("penalite"));


        listM = tc.AfficherMatche();
        tableList.setItems(listM);

    }

    private void Modifier(ActionEvent event) throws SQLException {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionPage.fxml"));
//            Parent root = loader.load();
//            GestionPageController pdc = loader.getController();
//
//            BtnModifier.getScene().setRoot(root);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

   
   

    }

    public void vider() {

      txId1.clear();
      
        

    }
   
    public void alertInf(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information !!");
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Votre resultats est enregistrée avec succes !" );

        alert.showAndWait();
    }
    
    
    public void alertMail(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email envoyé");
        alert.setHeaderText(null);
        alert.setContentText("Les clients de ton complexe sont informés de votre nouveau Competition!" );

        alert.showAndWait();
    }
    
    @FXML
 public void envoyerMail(){
        try {
                
                sendMail("bezzine.onsa@gmail.com");
                alertMail();
            } catch (Exception ex) {
                Logger.getLogger(ConsulterMatchController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "num.20746081@gmail.com";
        //Your gmail password
        String password = "Ahmed20746081";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Nouveau Competition pour vous");
            String htmlCode = "<h1> Nous mettons à votre disposition un nouveau Competition </h1>"
                    + "<h3> Participiez .....les places est illimites :)</h3>";           
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(ConsulterMatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}      

    @FXML
    private void Update(ActionEvent event) {
        
        
        try {

            String i = txId1.getText();

            String rs1 = choiceboxPenalite.getTypeSelector();
            

            PenaliteJoueur ccc = new PenaliteJoueur(i, rs1);
            PenaliteJoueurCRUD tCrud = new PenaliteJoueurCRUD();
            tCrud.modifierResultat(ccc);

            consulterPenaliteJoueur();
            vider();
            alertInf();
            envoyerMail();
        } catch (Exception e) {

        }

    }


    @FXML
    private void Select(MouseEvent event) {
        index = tableList.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        tfJoueur1.setText(JoueurC.getCellData(index).toString());
        txId1.setText(btnID.getCellData(index).toString());
       

    }
    @FXML
    public void ActionPerformed(ActionEvent arg0) throws DocumentException, IOException{
    Document doc =new Document();
    String requet="update  matche set  , joueur=?,pen=? where id=? ";
         
        try {
           // PreparedStatement pst=new MyConnection().cn.prepareStatement(requet);
            
        //ResultSet resultat = pst.executeQuery();
            PdfWriter.getInstance(doc , new FileOutputStream("C:\\Users\\bezin\\PenaliteJoueur.pde"));
            doc.open();
            
            
            
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph("ListePenaliteJoueur"));
                 doc.add(new Paragraph(" "));
              PdfPTable table =new PdfPTable(2);
              table.setWidthPercentage(80);
              PdfPCell cell;
              
              
              ////////////////////
              
              
              cell =new PdfPCell (new Phrase("Joueur",FontFactory.getFont("Comic sans MS",14)));
              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
              cell.setBackgroundColor(BaseColor.GRAY);
              table.addCell(cell);
              
              
              //////////////////////
              
              //while(resultat.next()){
                  
                  
                  
              cell =new PdfPCell (new Phrase("Penalite",FontFactory.getFont("Comic sans MS",14)));
              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
              cell.setBackgroundColor(BaseColor.GRAY);
              table.addCell(cell);
              
              

              
               doc.add(table);
              
               
               
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\bezin\\PenaliteJoueur.pde"));
            System.out.println("Telechargement terminne!");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PenalitesJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (SQLException ex) {
//            Logger.getLogger(PenalitesJoueursController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    }
    

