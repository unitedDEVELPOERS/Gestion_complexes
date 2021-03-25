/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitee;

import java.sql.Date;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class Competition {

    public int id;
    public String designation;
    private String date_creation;    //pour change
    private String date_debut;
    private String nbre_equipes;
    private Categorie categorie;
    private proprietaire_complexe complexe;
    private String complexe2;
    private String prix_participation;
    private String idcatg;

    public Competition(int id, String designation, String date_creation, String date_debut, String nbre_equipes, Categorie categorie, proprietaire_complexe complexe, String prix_participation) {
        this.id = id;
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

    public String getComplexe2() {
        return complexe2;
    }

    public void setComplexe2(String complexe2) {
        this.complexe2 = complexe2;
    }

    public Competition(int id, String designation, String date_creation, String date_debut, Categorie categorie, String complexe2, String prix_participation) {
        this.id = id;
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.categorie = categorie;
        this.complexe2 = complexe2;
        this.prix_participation = prix_participation;
    }

    public Competition(String designation, String date_debut, String nbre_equipes, Categorie categorie, String complexe2, String prix_participation) {
        this.designation = designation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe2 = complexe2;
        this.prix_participation = prix_participation;
    }

    public Competition(int id) {
        this.id = id;
    }

//    public Competition(int id, String designation, String date_creation, String date_debut, String nbre_equipes, Categorie categorie, String complexe, String prix_participation) {
//        this.id = id;
//        this.designation = designation;
//        this.date_creation = date_creation;
//        this.date_debut = date_debut;
//        this.nbre_equipes = nbre_equipes;
//        this.categorie = categorie;
//        this.complexe = complexe;
//        this.prix_participation = prix_participation;
//    }

    
    public Competition(int id, String designation,String date_debut, String nbre_equipes, proprietaire_complexe complexe, String prix_participation) {
        this.id = id;
        this.designation = designation;
        this.date_debut=date_debut;
        this.nbre_equipes = nbre_equipes;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
     
    }
    
 public Competition(int id, String designation, String date_creation, String date_debut, String nbre_equipes, String idcatg, proprietaire_complexe complexe) {
        this.id = id;
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.idcatg = idcatg;
        this.complexe = complexe;
    }
public Competition(int id, String designation, String date_creation, String date_debut, String nbre_equipes, String idcatg, proprietaire_complexe complexe,String prix_participation) {
        this.id = id;
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.idcatg = idcatg;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }
    public Competition(String designation, String date_creation, String date_debut, String nbre_equipes, String idcatg, proprietaire_complexe complexe, String prix_participation) {
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
        this.idcatg = idcatg;
    }

    public Competition() {
    }

    public Competition(String designation, String date_debut, String nbre_equipes, Categorie categorie, proprietaire_complexe complexe, String prix_participation) {
        this.designation = designation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

    public Competition(String designation, String nbre_equipes, Categorie categorie, proprietaire_complexe complexe, String prix_participation) {
        this.designation = designation;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

    public Competition(String designation, String nbre_equipes, Categorie categorie, proprietaire_complexe complexe) {
       
        this.designation = designation;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
    }

    public Competition(String designation, String date_creation, String date_debut, String nbre_equipes, Categorie categorie, proprietaire_complexe complexe, String prix_participation) {
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

//    public Competition( String designation, String date_creation, String date_debut, String nbre_equipes, String categorie, String complexe) {
//       this.id = id;
//        this.designation = designation;
//        this.date_creation = date_creation;
//        this.date_debut = date_debut;
//        this.nbre_equipes = nbre_equipes;
//        this.categorie = categorie;
//        this.complexe = complexe;
//    }
    public Competition(String designation, String nbre_equipes) {
        this.designation = designation;
        this.nbre_equipes = nbre_equipes;
    }

    

    public Competition(String designation, String nbre_equipes, proprietaire_complexe complexe, String prix_participation) {
        this.designation = designation;
        this.nbre_equipes = nbre_equipes;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

    public Competition(String designation, String date_debut, String nbre_equipes, String complexe1, String prix_participation) {
        this.designation = designation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.complexe2 = complexe1;
        this.prix_participation = prix_participation;
    }

    public Competition(String value1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public Competition(String value1, String value2, String value3, Categorie value4, String value5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Competition(String id, String des, String desc, String e, String g, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

  

    public String getPrix_participation() {
        return prix_participation;
    }

    public void setPrix_participation(String prix_participation) {
        this.prix_participation = prix_participation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getNbre_equipes() {
        return nbre_equipes;
    }

    public void setNbre_equipes(String nbre_equipes) {
        this.nbre_equipes = nbre_equipes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public proprietaire_complexe getComplexe() {
        return complexe;
    }

    public void setComplexe(proprietaire_complexe complexe) {
        this.complexe = complexe;
    }

    public String getIdcatg() {
        return idcatg;
    }

    public void setIdcatg(String idcatg) {
        this.idcatg = idcatg;
    }

    @Override
    public String toString() {
        return "Competition{" + ", designation=" + designation + ", date_creation=" + date_creation + ", date_debut=" + date_debut + ", nbre_equipes=" + nbre_equipes + ", categorie=" + categorie + ", complexe=" + complexe + '}';
    }

    public ObservableList find(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
