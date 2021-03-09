/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.javax;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sun.rmi.transport.Transport;

/**
 * FXML Controller class
 *
 * @author bezin
 */
public class SendingMailController implements Initializable {

    @FXML
    private Button sendEmailButton;
    @FXML
    private Label sentBoolValue;
    @FXML
    private TextField emailToField;
    @FXML
    private TextField emailPasswordField;
    @FXML
    private TextField emailSubjectField;
    @FXML
    private TextArea emailMessageField;
    @FXML
    private TextField emailFromField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void buttonClicked(ActionEvent actionEvent){
        sendEmail();
    }

    public void sendEmail(){
        String to = emailToField.getText();
        String from = emailFromField.getText();
        String host = "smtp.gmail.com";
        final String username = emailFromField.getText();
        final String password = emailPasswordField.getText();

        //setup mail server

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.Mail.Authenticator(){
            
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        //create mail
        MimeMessage m = new MimeMessage(session);
        m.setFrom(new InternetAddress(from));
        m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        m.setSubject(emailSubjectField.getText());
        m.setText(emailMessageField.getText());
        //send mail
        
        Transport.send(m);
        sentBoolValue.setVisible(true);
        System.out.println("Message sent!");

    }
}
