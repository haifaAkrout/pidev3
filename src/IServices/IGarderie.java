/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Garderie;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public interface IGarderie {
    
    
     public void ajouterGarderie(Garderie G);
     public Garderie  rechercherGarderie(int id);
     public void modifierGarderie(Garderie G,int id);
     public void afficherGarderie();
     public void supprimerGarderie(int id);
      public  Garderie rechercherGarderie2(String adresse);
       public void ajouterRating(int id,int rating);
     
    ObservableList<Garderie> AfficherGarderies();
        public ObservableList<Garderie> AfficherGarderies2(String adresse);
    public  void SelectGarderie();
}
