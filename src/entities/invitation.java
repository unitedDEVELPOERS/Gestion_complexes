/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author fachr
 */
public class invitation {
    int id,equipe,utilisateur,valide=0;
    String type;
    
    public invitation(int equipe,int utilisateur,String type){
        this.equipe=equipe;
        this.utilisateur=utilisateur;
        this.type=type;
        
    }
  public invitation(int id,String type,int equipe,int utilisateur,int valide){
      this.id=id;
        this.equipe=equipe;
        this.utilisateur=utilisateur;
        this.type=type;
        this.valide=valide;
        
    }

    @Override
    public String toString() {
        return "invitation{" + "id=" + id + ", type=" + type + ", equipe=" + equipe + ", utilisateur=" + utilisateur + ", valide=" + valide + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
