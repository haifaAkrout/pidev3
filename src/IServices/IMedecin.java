/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Garderie;
import Entity.Medecin;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public interface IMedecin {
       public void ajouterMedecin(Medecin m);
     public void modifierMedecin(Medecin m,int id);
     public void afficherMedecin();
     public Medecin rechercherMedecin(String specialite,String adresse,String nom);
     public void supprimerMedecin(int id);
       public ObservableList<Medecin> AfficherMedecins2(String specialite, String adresse, String nom) ;
     
   // ObservableList<Garderie> AfficherGarderies();
        public ObservableList<Medecin>AfficherMedecins();
         public  Medecin rechercherMedecin(int id);
    public  Medecin rechercherMedecin2(String id);
}
