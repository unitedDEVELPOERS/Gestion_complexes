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
public class Categorie {
    private int id;
    private String designation;

    public Categorie() {
    }

    public Categorie(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return  designation ;
    }
//    public String toString() {
//        return "Categorie{" + "id=" + id + ", designation=" + designation + '}';
//    }
    
    
    
}
