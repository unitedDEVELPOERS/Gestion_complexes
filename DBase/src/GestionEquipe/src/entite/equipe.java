/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author fachr
 */
public class equipe {
    public int id;
    public String nom;
    public int nbre_joueur;



    public int getCapitain() {
        return capitain;
    }

    public void setCapitain(int capitain) {
        this.capitain = capitain;
    }
    public String logo;
 public int capitain;
    public void setId(int id) {
        this.id = id;
    }
      public equipe(int id,String nom , int nbre_joueur,String logo){
          this.id=id;
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
        this.logo=logo;
    }
       public equipe(int id,String nom , int nbre_joueur,String logo,int capitain){
          this.id=id;
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
        this.logo=logo;
        this.capitain=capitain;
    }
    public equipe(String nom , int nbre_joueur,String logo,int capitain){
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
        this.logo=logo;
        this.capitain=capitain;
    }

    public int getId() {
        return id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbre_joueur() {
        return nbre_joueur;
    }

    public void setNbre_joueur(int nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }

    @Override
    public String toString() {
        return "equipe{" + "id=" + id + ", nom=" + nom + ", nbre_joueur=" + nbre_joueur + ",logo="+logo+'}';
    }
   
    
}
