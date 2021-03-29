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
public class Complexe extends Proprietaire_complexe {
    private int id;
    private String raison_sociale ;
    private int matricule_fiscale;
    private int id_utilisateur;
   
    public Complexe() {
    }

    public Complexe(int id, String raison_sociale, int matricule_fiscale, int id_utilisateur) {
        super(id,raison_sociale,matricule_fiscale,id_utilisateur);
        this.id = id;
        this.raison_sociale = raison_sociale;
        this.matricule_fiscale = matricule_fiscale;
        this.id_utilisateur = id_utilisateur;
    }

    public Complexe(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
