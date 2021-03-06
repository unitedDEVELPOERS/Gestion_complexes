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
public class Penalite {
    private int id;
    private String designation;
    private int nbre_points_retires;
    private Complexe complexe;

    public Penalite() {
    }

    public Penalite(int id, String designation, int nbre_points_retires) {
        this.id = id;
        this.designation = designation;
        this.nbre_points_retires = nbre_points_retires;
    }

    
    public Penalite(int id, String designation, int nbre_points_retires, Complexe complexe) {
        this.id = id;
        this.designation = designation;
        this.nbre_points_retires = nbre_points_retires;
        this.complexe = complexe;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public int getNbre_points_retires() {
        return nbre_points_retires;
    }

    public Complexe getComplexe() {
        return complexe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setNbre_points_retires(int nbre_points_retires) {
        this.nbre_points_retires = nbre_points_retires;
    }

    public void setComplexe(Complexe complexe) {
        this.complexe = complexe;
    }

    @Override
    public String toString() {
        return id +" "+ designation +" "+ nbre_points_retires +" "+ complexe;
    }
    
    
}
