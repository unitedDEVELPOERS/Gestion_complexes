/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author bezin
 */
public class matche {
    private int id;
  
    private String date_creation;
    private String date_match;
    private equipe equipe1;
    private equipe equipe2;
   

   
    private int resultat_eq1;
    private int resultat_eq2;
    private boolean valide;
    private int terrain;
    private int arbitre;
    private int niveau_competition;
    private String id1;
    
    
    
    
 public matche(int id, equipe equipe1, equipe equipe2) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }
    public matche() {
    }
 private String equipe11;
     private String equipe22;
    public matche(int id, equipe equipe1, equipe equipe2, int resultat_eq1, int resultat_eq2) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.resultat_eq1 = resultat_eq1;
        this.resultat_eq2 = resultat_eq2;
    }

    public matche(int id, String date_creation, String date_match, equipe equipe1, equipe equipe2, int resultat_eq1, int resultat_eq2, boolean valide, int terrain, int arbitre, int niveau_competition) {
        this.id = id;
        this.date_creation = date_creation;
        this.date_match = date_match;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.resultat_eq1 = resultat_eq1;
        this.resultat_eq2 = resultat_eq2;
        this.valide = valide;
        this.terrain = terrain;
        this.arbitre = arbitre;
        this.niveau_competition = niveau_competition;
        
        
    }

    public matche(int id, equipe equipe1, equipe equipe2, int resultat_eq1, int resultat_eq2, int terrain) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.resultat_eq1 = resultat_eq1;
        this.resultat_eq2 = resultat_eq2;
        this.terrain = terrain;
    }

    public matche(String id1, String equipe11, String equipe22, String resultat_eq22, String resultat_eq11) {
        this.id1 = id1;
        this.equipe11 = equipe11;
        this.equipe22 = equipe22;
        this.resultat_eq22 = resultat_eq22;
        this.resultat_eq11 = resultat_eq11;
    }

    public matche(String id1, String resultat_eq22, String resultat_eq11) {
        this.id1 = id1;
        this.resultat_eq22 = resultat_eq22;
        this.resultat_eq11 = resultat_eq11;
    }

    
    
    private String resultat_eq22;
    private String resultat_eq11;
    
    

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

    public equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public equipe getEquipe2() {
        return equipe2;
    }

    public String getResultat_eq22() {
        return resultat_eq22;
    }

    public void setResultat_eq22(String resultat_eq22) {
        this.resultat_eq22 = resultat_eq22;
    }

    public String getResultat_eq11() {
        return resultat_eq11;
    }

    public void setResultat_eq11(String resultat_eq11) {
        this.resultat_eq11 = resultat_eq11;
    }
    

    public void setEquipe2(equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public int getResultat_eq1() {
        return resultat_eq1;
    }

    public void setResultat_eq1(int resultat_eq1) {
        this.resultat_eq1 = resultat_eq1;
    }

    public int getResultat_eq2() {
        return resultat_eq2;
    }

    public void setResultat_eq2(int resultat_eq2) {
        this.resultat_eq2 = resultat_eq2;
    }

    public boolean isValide() {
        return valide;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getEquipe11() {
        return equipe11;
    }

    public void setEquipe11(String equipe11) {
        this.equipe11 = equipe11;
    }

    public String getEquipe22() {
        return equipe22;
    }

    public void setEquipe22(String equipe22) {
        this.equipe22 = equipe22;
    }
    

    public void setValide(boolean valide) {
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

    public matche(int resultat_eq1, int resultat_eq2, String id1, String equipe11, String equipe22) {
        this.resultat_eq1 = resultat_eq1;
        this.resultat_eq2 = resultat_eq2;
        this.id1 = id1;
        this.equipe11 = equipe11;
        this.equipe22 = equipe22;
    }

    
    

    
}
