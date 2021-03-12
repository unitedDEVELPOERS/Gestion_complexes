/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author fachr
 */
public class SendMail {
    public static void mail(String recepient,String nom, int nbr) throws MessagingException{
         System.out.println("preparing to send email");
        Properties properties =new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccount ="complexsportiftunis@gmail.com";
        String password ="Azerty_010123";
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount,password);
            }
        });
        Message message =preparedMessage(session,myAccount,recepient,  nom , nbr);
           Transport.send(message);
           System.out.println("message sent succefly");
    }

    private static Message preparedMessage(Session session, String myAccount, String recepient, String nom,int nbr) throws AddressException, MessagingException {
     Message message = new MimeMessage(session); 
     message.setFrom(new InternetAddress(myAccount));
     message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
     if(nbr==0){
     message.setSubject("Creation equipe");
     message.setText("vous avez créé une équipe avec le nom : "+nom);
     }else if(nbr==1){
         message.setSubject("Request equipe");
     message.setText("vous avez une invitation a cette équipe avec le nom : "+nom);
     }else if (nbr==2){
            message.setSubject("Demande Joueur");
     message.setText("vous avez une request a votre équipe avec le nom : "+nom);
     }
     return message;
     
     
    }
}
