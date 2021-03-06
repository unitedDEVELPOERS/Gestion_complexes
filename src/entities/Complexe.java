/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
public class Complexe {
    private int id;
    private String nom;

    public Complexe(int id) {
        this.id = id;
    }
public Complexe(int id, String nom) {
        this.id = id;
        this.nom=nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    public Complexe() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  nom ;
    }
    
    
    
    
    
}
