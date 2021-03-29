/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.Date;

/**
 *
 * @author fachr
 */
public class matche {
    
    
    public int id ;
    public String date_creation, date_match;
    public int equipe1,equipe2;
    public int resulat_eq1,resulat_eq2,valide,terrain,arbitre,niveau_competition;
    
    public matche(int id,String date_creation,String date_match,int equipe1,int equipe2,int resulat_eq1,int resulat_eq2,int valide ,int terrain,int arbitre,int niveau_competition){
       this.id=id;
       this.date_creation=date_creation;
       this.date_match=date_match;
       this.equipe1=equipe1;
       this.equipe2=equipe2;
       this.resulat_eq1=resulat_eq1;
       this.resulat_eq2=resulat_eq2;
       this.valide=valide;
       this.arbitre=arbitre;
       this.niveau_competition=niveau_competition;
       this.terrain=terrain;
       
    }

    @Override
    public String toString() {
        return "matche{" + "id=" + id + ", date_creation=" + date_creation + ", date_match=" + date_match + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + ", valide=" + valide + ", terrain=" + terrain + '}';
    }
     public matche(int id,String date_creation,String date_match,int equipe1,int equipe2,int valide,int terrain ){
       this.id=id;
       this.date_creation=date_creation;
       this.date_match=date_match;
       this.equipe1=equipe1;
       this.equipe2=equipe2;
       this.terrain=terrain;
  
       this.valide=valide;
      
      
       
    }
     
    public matche(int id,String date_creation,String date_match){
       this.id=id;
       this.date_creation=date_creation;
       this.date_match=date_match;
      
       
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDate_match() {
        return date_match;
    }

    public void setDate_match(String date_match) {
        this.date_match = date_match;
    }

    public int getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(int equipe1) {
        this.equipe1 = equipe1;
    }

    public int getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(int equipe2) {
        this.equipe2 = equipe2;
    }

    public int getResulat_eq1() {
        return resulat_eq1;
    }

    public void setResulat_eq1(int resulat_eq1) {
        this.resulat_eq1 = resulat_eq1;
    }

    public int getResulat_eq2() {
        return resulat_eq2;
    }

    public void setResulat_eq2(int resulat_eq2) {
        this.resulat_eq2 = resulat_eq2;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public int getTerrain() {
        return terrain;
    }

    public void setTerrain(int terrain) {
        this.terrain = terrain;
    }

    public int getArbitre() {
        return arbitre;
    }

    public void setArbitre(int arbitre) {
        this.arbitre = arbitre;
    }

    public int getNiveau_competition() {
        return niveau_competition;
    }

    public void setNiveau_competition(int niveau_competition) {
        this.niveau_competition = niveau_competition;
    }
}
