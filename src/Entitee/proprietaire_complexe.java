/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitee;

/**
 *
 * @author user
 */
public class proprietaire_complexe {
     
      private int id;
      private String raison_sociale;

    public proprietaire_complexe() {
    }
      

    public proprietaire_complexe(int id, String raison_sociale) {
        this.id = id;
        this.raison_sociale = raison_sociale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    @Override
    public String toString() {
        return raison_sociale ;
    }
    
    
}
