/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Services.GestionEnfant;
import Services.GestionUser;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author atoufa traore
 */
public class Inscription {
      private int id;
 

    
    private Date date_arriv;
    private String commentaires;
    private String nurserie;
    private String repas;
    private int id_garderie;
    private User user;
    private Enfant enfant;
    
public int getId_garderie() {
        return id_garderie;
    }

    public void setId_garderie(int id_garderie) {
        this.id_garderie = id_garderie;
    }

    public Inscription(String id_enfant, String id_parent, Date date_arriv, String commentaires, String nurserie, String repas, int id_garderie) {
            GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
             System.out.println(u);
        GestionEnfant enfants=new GestionEnfant();
        Enfant e=enfants.rechercherEnfant(id_enfant);
             System.out.println(e);
        this.date_arriv = date_arriv;
        this.commentaires = commentaires;
        this.nurserie = nurserie;
        this.repas = repas;
        this.id_garderie = id_garderie;
        this.enfant=e;
        this.user=u;
    }
  
    public Inscription(String id_enfant, String id_parent, Date date_arriv, String commentaires, String nurserie, String repas) {
GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
             System.out.println(u);
        GestionEnfant enfants=new GestionEnfant();
        Enfant e=enfants.rechercherEnfant(id_enfant);
             System.out.println(e);
        this.date_arriv = date_arriv;
        this.commentaires = commentaires;
        this.nurserie = nurserie;
        this.enfant=e;
        this.user=u;
        this.repas = repas;
    }
     public Inscription() {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
   
        hash = 89 * hash + Objects.hashCode(this.date_arriv);
        hash = 89 * hash + Objects.hashCode(this.commentaires);
        hash = 89 * hash + Objects.hashCode(this.nurserie);
        hash = 89 * hash + Objects.hashCode(this.repas);
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
        final Inscription other = (Inscription) obj;
        if (this.id != other.id) {
            return false;
        }
      
        if (!Objects.equals(this.date_arriv, other.date_arriv)) {
            return false;
        }
        if (!Objects.equals(this.commentaires, other.commentaires)) {
            return false;
        }
        if (!Objects.equals(this.nurserie, other.nurserie)) {
            return false;
        }
        if (!Objects.equals(this.repas, other.repas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id=" + id + ", date_arriv=" + date_arriv + ", commentaires=" + commentaires + ", nurserie=" + nurserie + ", repas=" + repas + ", id_garderie=" + id_garderie + ", user=" + user + ", enfant=" + enfant + '}';
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    
    public Date getDate_arriv() {
        return date_arriv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public void setDate_arriv(Date date_arriv) {
        this.date_arriv = date_arriv;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getNurserie() {
        return nurserie;
    }

    public void setNurserie(String nurserie) {
        this.nurserie = nurserie;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }
    
    
}
