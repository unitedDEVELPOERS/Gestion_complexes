/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bezin
 */
public class PenaliteJoueur {
    private int id;
    private String time;
      private joueur joueur;
        private Penalite penalite;
          private int matche;
     private int arbitre;
    

  private int joueur1;
  private int penalite1;
   
    public PenaliteJoueur() {
    }

    public PenaliteJoueur(int id, joueur heure, Penalite penalite, int matche, int arbitre) {
        this.id = id;
        this.joueur = heure;
        this.penalite = penalite;
        this.matche = matche;
        this.arbitre = arbitre;
    }

    public PenaliteJoueur(int id, joueur joueur, Penalite penalite) {
        this.id = id;
        this.joueur = joueur;
        this.penalite = penalite;
    }

    public PenaliteJoueur(int id, int joueur1, int penalite1) {
        this.id = id;
        this.joueur1 = joueur1;
        this.penalite1 = penalite1;
    }

    public PenaliteJoueur(String i, String rs1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PenaliteJoueur(int aInt, equipe e, equipe e1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getId() {
        return id;
    }

  
  
    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(joueur joueur) {
        this.joueur = joueur;
    }

    public Penalite getPenalite() {
        return penalite;
    }

    public int getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(int joueur1) {
        this.joueur1 = joueur1;
    }

    public int getPenalite1() {
        return penalite1;
    }

    public void setPenalite1(int penalite1) {
        this.penalite1 = penalite1;
    }

    public void setPenalite(Penalite penalite) {
        this.penalite = penalite;
    }

    public int getMatche() {
        return matche;
    }

    public void setMatche(int matche) {
        this.matche = matche;
    }

    public int getArbitre() {
        return arbitre;
    }

    public void setArbitre(int arbitre) {
        this.arbitre = arbitre;
    }

    @Override
    public String toString() {
        return "PenaliteJoueur{" + "id=" + id + ", time=" + time + ", joueur=" + joueur + ", penalite=" + penalite + ", matche=" + matche + ", arbitre=" + arbitre + '}';
    }
    
     
     
     
     
     
     
}
