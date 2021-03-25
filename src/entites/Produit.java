/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Jawher
 */
public class Produit {
    
    private int id ;
private int reference;
    private String designation ;
   
    private int quantite ;
    private int prix_uni ;
   
    public Produit() {
    }

    public Produit(int reference) {
        this.reference = reference;
    }

    
    

    public Produit(int id,int reference,  String designation, int quantite, int prix_uni) {
        this.id = id;
        this.reference=reference ;
        this.designation = designation;
       
        this.quantite = quantite;
        this.prix_uni = prix_uni;
       
    }

    public Produit(String des, String desc, String e, String ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


 

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

  

    

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_uni() {
        return prix_uni;
    }

    public void setPrix_uni(int prix_uni) {
        this.prix_uni = prix_uni;
    }


    




    
}
