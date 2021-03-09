/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import java.sql.Date;
import java.time.*;

/**
 *
 * @author Onsa Bezzine
 */
public class Match {
    private int id;
    private Date date_creation;
    private Date date_match;
    private int equipe1;
    private int equipe2;
    private int resultat_eq1;
    private int resultat_eq2;
    private boolean valide;
    private int terrain;
    private int arbitre;
    private int niveau_competition;

    public Match() {
    }

    public Match(int id, Date date_creation, Date date_match, int equipe1, int equipe2, int resultat_eq1, int resultat_eq2, boolean valide, int terrain, int arbitre, int niveau_competition) {
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

    public Match(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getArbitre() {
        return arbitre;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public Date getDate_match() {
        return date_match;
    }

    public int getEquipe1() {
        return equipe1;
    }

    public int getEquipe2() {
        return equipe2;
    }

    public int getId() {
        return id;
    }

    public int getNiveau_competition() {
        return niveau_competition;
    }

    public int getResultat_eq1() {
        return resultat_eq1;
    }

    public int getResultat_eq2() {
        return resultat_eq2;
    }

    public int getTerrain() {
        return terrain;
    }

    public void setArbitre(int arbitre) {
        this.arbitre = arbitre;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public void setEquipe1(int equipe1) {
        this.equipe1 = equipe1;
    }

    public void setEquipe2(int equipe2) {
        this.equipe2 = equipe2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNiveau_competition(int niveau_competition) {
        this.niveau_competition = niveau_competition;
    }

    public void setResultat_eq1(int resultat_eq1) {
        this.resultat_eq1 = resultat_eq1;
    }

    public void setResultat_eq2(int resultat_eq2) {
        this.resultat_eq2 = resultat_eq2;
    }

    public void setTerrain(int terrain) {
        this.terrain = terrain;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", date_creation=" + date_creation + ", date_match=" + date_match + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + ", resultat_eq1=" + resultat_eq1 + ", resultat_eq2=" + resultat_eq2 + ", valide=" + valide + ", terrain=" + terrain + ", arbitre=" + arbitre + ", niveau_competition=" + niveau_competition + '}';
    }
    
    
    
    
}
