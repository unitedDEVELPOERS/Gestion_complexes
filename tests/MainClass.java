/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import APIs.SendingMail;
import entities.Arbitre;
import entities.Match;
import entities.Penalite;
import entities.Utilisateurs;
import services.ArbitreCRUD;
import services.PenaliteCRUD;
import services.UserCRUD;
import tools.MyConnection;
import javax.mail.MessagingException;

/**
 *
 * @author bezin
 */
public class MainClass {
  public static void main(String[] args) throws MessagingException {
        MyConnection cn =new MyConnection ();
        
        Match mt= new Match();
        PenaliteCRUD PenCrud = new PenaliteCRUD ();
        // Utilisateurs u=new Utilisateurs(4, "kjk@fj", "02323", "bezzin");
        // Penalite p = new Penalite (152,"jka",54,12);
        //arbCrud.ajouterArbitre(arb, 3);
      //UserCRUD uc = new UserCRUD();
   // PenCrud.AfficherPenalit(p);
     //uc.supprimer(u);
      //uc.modifier(u);
     SendingMail.mail("bezzine.onsa@gmail.com", "equipe", 0);
      
    }
 
}
