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
public class Client {
    private int id;
    int nom;

    public int getId() {
        return id;
    }

    public int getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + '}';
    }
       
}
