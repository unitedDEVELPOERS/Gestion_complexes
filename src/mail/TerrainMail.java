/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmed
 */
public class TerrainMail {
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Préparation d'envoi");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enabe", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myEmail = "num.20746081@gmail.com";
        String password = "Ahmed20746081";
        
        Session session = Session.getInstance(properties, new Authenticator(){
          @Override
          protected PasswordAuthentication getPasswordAuthentication(){
              return new PasswordAuthentication(myEmail, password);
          }
        });
        Message message = prepareMessage(session, myEmail, recepient);        
        Transport.send(message);
        System.out.println("Email bien envoyé");
    }
    private static Message prepareMessage(Session session, String myEmail, String recepient){
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Test mail complexe sportif");
            message.setText("mon premier mail de test");
            return message;

        } catch (Exception ex) {
            Logger.getLogger(TerrainMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
            
}
