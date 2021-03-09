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
public class Arbitre extends Utilisateurs{
    private int id;
    private String nom;
    private String prenom;
   private int categorie;
   private int complexe;
   private int id_utilisateur;

    public Arbitre() {
    }

    public Arbitre(int id, String nom, String prenom, int categorie) {
        super(id, nom, prenom, nom);
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.categorie = categorie;
    }

    

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCategorie() {
        return categorie;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getComplexe() {
        return complexe;
    }

    public void setComplexe(int complexe) {
        this.complexe = complexe;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "Arbitre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", categorie=" + categorie + ", complexe=" + complexe + ", id_utilisateur=" + id_utilisateur + '}';
    }

   
    
    
}
