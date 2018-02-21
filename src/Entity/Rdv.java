/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Services.GestionEnfant;
import Services.GestionMedecins;
import Services.GestionUser;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author atoufa traore
 */
public class Rdv {
    private int id;
private User parent;
private Medecin medecin;
private Enfant enfant;

private Date date_rdv;
public Rdv() {
        
    }
    public Rdv(int id,String id_parent,int id_medecin,String id_enfant, Date date_rdv) {
        this.id = id;
        GestionMedecins medecins=new GestionMedecins();
        Medecin m=medecins.rechercherMedecin(id_medecin);
        GestionEnfant enfants=new GestionEnfant();
        Enfant e=enfants.rechercherEnfant(id_enfant);
        GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
     
        this.date_rdv = date_rdv;
    }
     public Rdv(String id_parent,String id_enfant, Date date_rdv,int id_medecin) {
      
        GestionMedecins medecins=new GestionMedecins();
        Medecin m=medecins.rechercherMedecin(id_medecin);
         System.out.println(m);
         System.out.println("jjjjjjjjjjzsnsns");
            GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
             System.out.println(u);
        GestionEnfant enfants=new GestionEnfant();
        Enfant e=enfants.rechercherEnfant(id_enfant);
             System.out.println(e);
    
             this.enfant=e;
             this.parent=u;
             this.medecin=m;
     
        this.date_rdv = date_rdv;
    }
     
     
              public Rdv( String id_parent,int age,String Sexe, Date date_rdv,String specialite) {
      GestionMedecins medecins=new GestionMedecins();
        Medecin m=medecins.rechercherMedecin2(specialite);
         System.out.println(m);
   
         System.out.println("jjjjjjjjjjzsnsns");
            GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
             System.out.println(u);
      
             this.parent=u;
            
     
        this.date_rdv = date_rdv;
    }
      public Rdv(String id_parent,String id_enfant,int age,String Sexe, Date date_rdv,int id_medecin) {
      
        GestionMedecins medecins=new GestionMedecins();
        Medecin m=medecins.rechercherMedecin(id_medecin);
         System.out.println(m);
         System.out.println("jjjjjjjjjjzsnsns");
            GestionUser parents=new GestionUser();
        User u=parents.rechercherUser(id_parent);
             System.out.println(u);
        GestionEnfant enfants=new GestionEnfant();
        Enfant e=enfants.rechercherEnfant(id_enfant);
             System.out.println(e);
    
             this.enfant=e;
             this.parent=u;
             this.medecin=m;
     
        this.date_rdv = date_rdv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public Date getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(Date date_rdv) {
        this.date_rdv = date_rdv;
    }

    @Override
    public String toString() {
        return "Rdv{" + "id=" + id + ", parent=" + parent + ", medecin=" + medecin + ", enfant=" + enfant + ", date_rdv=" + date_rdv + '}';
    }




   
}
