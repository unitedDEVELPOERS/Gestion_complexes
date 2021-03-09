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
public class Proprietaire_complexe {
      private int id ;
   private String raison_sociale ;
    private int matricule_fiscale;
    private int id_utilisateur;

    public Proprietaire_complexe() {
    }

    public Proprietaire_complexe(int id, String raison_sociale, int matricule_fiscale, int id_utilisateur) {
        this.id = id;
        this.raison_sociale = raison_sociale;
        this.matricule_fiscale = matricule_fiscale;
        this.id_utilisateur = id_utilisateur;
    }

    public int getId() {
        return id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getMatricule_fiscale() {
        return matricule_fiscale;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setMatricule_fiscale(int matricule_fiscale) {
        this.matricule_fiscale = matricule_fiscale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    @Override
    public String toString() {
        return "Proprietaire_complexe{" + "id=" + id + ", raison_sociale=" + raison_sociale + ", matricule_fiscale=" + matricule_fiscale + ", id_utilisateur=" + id_utilisateur + '}';
    }
    
    
}
