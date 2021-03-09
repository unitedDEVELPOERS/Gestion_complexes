/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import entities.Arbitre;
import entities.Match;
import entities.Utilisateurs;
import services.ArbitreCRUD;
import services.UserCRUD;
import tools.MyConnection;

/**
 *
 * @author bezin
 */
public class MainClass {
  public static void main(String[] args) {
        MyConnection cn =new MyConnection ();
        
        Match mt= new Match();
         //ArbitreCRUD arbCrud = new ArbitreCRUD ();
         //Utilisateurs u=new Utilisateurs(4, "kjk@fj", "02323", "bezzin");
         //Arbitre arb = new Arbitre(152,"jka","za",545);
        //arbCrud.ajouterArbitre(arb, 3);
      //UserCRUD uc = new UserCRUD();
      ///uc.ajouterUser(u);
     //uc.supprimer(u);
      //uc.modifier(u);
    }
 
}
