/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author atoufa traore
 */
public class Garderie {
    private int id;
    private String nom;
    private String description;
     private Date date_ouverture;
      private Date date_fermeture;
      private String langues;
    private String adresse;
    private int telephone;
    private String proprietaire;
    private String image;
private int cout;
private String repas;
private int rating;
private Time heure_deb;
private Time heure_fin;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Time getHeure_deb() {
        return heure_deb;
    }

    public void setHeure_deb(Time heure_deb) {
        this.heure_deb = heure_deb;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

   
  public Garderie(String nom, String adresse, int telephone, String image,String email,String proprietaire, String description,String langues, Date date_ouverture, Date date_fermeture,int cout) {
        this.nom = nom;
        this.description = description;
        this.date_ouverture = date_ouverture;
        this.date_fermeture = date_fermeture;
        this.langues = langues;
        this.adresse = adresse;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
        this.image = image;
        this.email = email;
        this.cout=cout;
  
    }
   public Garderie(String nom, String adresse, int telephone, String image,String email,String proprietaire, String description,String langues, Date date_ouverture, Date date_fermeture,int cout,Time heure_deb,Time heure_fin) {
        this.nom = nom;
        this.description = description;
        this.date_ouverture = date_ouverture;
        this.date_fermeture = date_fermeture;
        this.langues = langues;
        this.adresse = adresse;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
        this.image = image;
        this.email = email;
        this.cout=cout;
          this.heure_deb=heure_deb;
  this.heure_fin=heure_fin;
  
    }
  
    public Garderie(String nom, String adresse, int telephone, String image,String email,String proprietaire, String description,String langues, Date date_ouverture, Date date_fermeture,int cout,int rating,Time heure_deb,Time heure_fin) {
        this.nom = nom;
        this.description = description;
        this.date_ouverture = date_ouverture;
        this.date_fermeture = date_fermeture;
        this.langues = langues;
        this.adresse = adresse;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
        this.image = image;
        this.email = email;
        this.cout=cout;
  this.rating=rating;
  this.heure_deb=heure_deb;
  this.heure_fin=heure_fin;
    }
   public Garderie(String nom, String adresse, int telephone, String image,String email,String proprietaire, String description,String langues, Date date_ouverture, Date date_fermetures) {
        this.nom = nom;
        this.description = description;
        this.date_ouverture = date_ouverture;
        this.date_fermeture = date_fermeture;
        this.langues = langues;
        this.adresse = adresse;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
        this.image = image;
        this.email = email;
      
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public Date getDate_fermeture() {
        return date_fermeture;
    }

    public void setDate_fermeture(Date date_fermeture) {
        this.date_fermeture = date_fermeture;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }
private String email;

    public String getEmail() {
        return email;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Garderie(int id, String nom, String adresse, int telephone,String proprietaire, String image) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
        this.image = image;
    }
    public Garderie( String nom, String adresse, int telephone, String image,String email,String proprietaire) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
     this.email = email;
        this.image = image;
        this.proprietaire=proprietaire;
    }
 public Garderie( ) {
     
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.adresse);
        hash = 29 * hash + this.telephone;
       
        hash = 29 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Garderie other = (Garderie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (this.telephone != other.telephone) {
            return false;
        }
        if (this.proprietaire != other.proprietaire) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String  getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Garderie{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", proprietaire=" + proprietaire + ", image=" + image + ", email=" + email + '}';
    }
    
   
    
    
}
