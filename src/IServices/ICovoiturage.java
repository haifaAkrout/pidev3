/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Covoiturage;
import java.sql.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public interface ICovoiturage {
    
	 public void AjouterCovoiturage(Covoiturage C);
     public void ModifierCovoiturage(Covoiturage C,int id);
     public void SupprimerCovoiturage(int id);
     public void AfficherCovoiturage(int nbr);
//	 public  ObservableList<Covoiturage> ListerCovoiturages();
     public List ListCovoiturages();
	 public Covoiturage RechercheCovoiturage(int id);
	 public Covoiturage ReserverCovoiturage();
	 public Covoiturage AnnulerReservationCovoiturage();
         public  ObservableList<Covoiturage> ListerCovoiturages(int cin1) ;
         public Covoiturage RechercheCovoiturage2(Date date1) ;
	
    
}
