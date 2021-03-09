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
public class Penalite {
    private int id;
    private String designation;
    private int nbre_points_retires;
    private int complexe;
     
     

    public Penalite() {
    }

    public Penalite(int id, String designation, int nbre_points_retires, int complexe) {
        this.id = id;
        this.designation = designation;
        this.nbre_points_retires = nbre_points_retires;
        this.complexe = complexe;
    }

  

    public Penalite(int id, String designation, int nbre_points_retires) {
        this.id = id;
        this.designation = designation;
        this.nbre_points_retires = nbre_points_retires;
        this.complexe = complexe;
    }

    public Penalite(int i, String des, int nbrePoint, Complexe c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   

    public int getComplexe() {
        return complexe;
    }

    public String getDesignation() {
        return designation;
    }

    public int getId() {
        return id;
    }

    public int getNbre_points_retires() {
        return nbre_points_retires;
    }

    public void setComplexe(int complexe) {
        this.complexe = complexe;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbre_points_retires(int nbre_points_retires) {
        this.nbre_points_retires = nbre_points_retires;
    }




}


