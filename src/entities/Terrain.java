/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author ahmed
 */
public class Terrain {
    private int id;
    private String designation;
    private String description;
    private String adresse;
    private String image;
    private boolean disponible = true;
    private float prix_location;
    private Complexe complexe;
    private Categorie categorie;
    private String heure_ouverture;
    private String heure_fermeture;
//    private Time heure_ouverture;
//    private Time heure_fermeture;
    private LocalDateTime cree_a;
    private LocalDateTime modifie_a;
    private LocalDateTime supprimer_a;
    
    public Terrain(int id, String des, String desc) {
        this.id = id;
        this.designation=des;
        this.description=desc;
    }

    public Terrain() {
    }
    public Terrain(String designation, String description, String adresse, String image, float prix_location, Complexe complexe, Categorie categorie, String heure_ouverture, String heure_fermeture) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
    }

     public Terrain(int id, String designation, String description, String adresse, String image, float prix_location, Complexe complexe, Categorie categorie, String heure_ouverture, String heure_fermeture) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        
    }

    /*public Terrain(int id, String designation, String description, String adresse, String image, boolean disponible, float prix_location, Complexe complexe, Categorie categorie, Time heure_ouverture, Time heure_fermeture) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.disponible = disponible;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
    }

    public Terrain(int id, String designation, String description, String adresse, String image, boolean disponible, float prix_location, Complexe complexe, Categorie categorie, Time heure_ouverture, Time heure_fermeture, LocalDateTime cree_a, LocalDateTime modifie_a, LocalDateTime supprimer_a) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.disponible = disponible;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.cree_a = cree_a;
        this.modifie_a = modifie_a;
        this.supprimer_a = supprimer_a;
    }*/

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImage() {
        return image;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public float getPrix_location() {
        return prix_location;
    }

    public Complexe getComplexe() {
        return complexe;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public LocalDateTime getCree_a() {
        return cree_a;
    }

    public LocalDateTime getModifie_a() {
        return modifie_a;
    }

    public LocalDateTime getSupprimer_a() {
        return supprimer_a;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrix_location(float prix_location) {
        this.prix_location = prix_location;
    }

    public void setComplexe(Complexe complexe) {
        this.complexe = complexe;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public void setCree_a(LocalDateTime cree_a) {
        this.cree_a = cree_a;
    }

    public void setModifie_a(LocalDateTime modifie_a) {
        this.modifie_a = modifie_a;
    }

    public void setSupprimer_a(LocalDateTime supprimer_a) {
        this.supprimer_a = supprimer_a;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terrain other = (Terrain) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
//    public String toString() {
//        return "Terrain{" + "id=" + id + ", designation=" + designation + ", description=" + description + ", adresse=" + adresse + ", image=" + image + ", disponible=" + disponible + ", prix_location=" + prix_location + ", complexe=" + complexe + ", categorie=" + categorie + ", heure_ouverture=" + heure_ouverture + ", heure_fermeture=" + heure_fermeture + ", cree_a=" + cree_a + ", modifie_a=" + modifie_a + ", supprimer_a=" + supprimer_a + '}';
//    }

    public String toString() {
        return  designation ;
    }
    
    
    
}
