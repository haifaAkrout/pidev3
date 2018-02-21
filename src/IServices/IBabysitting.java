/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Babysitting;
import java.util.List;

/**
 *
 * @author atoufa traore
 */
public interface IBabysitting {
     public void AjouterBabysitting(Babysitting B);
     public void ModifierBabysitting(Babysitting B,int id);
     public void SupprimerBabysitting(int id);
     public void AfficherBabysitting(int id);
     public List ListerBabysittings();
	 public Babysitting RechercheBabysitting(int id);
	 public Babysitting ReserverBabysitting();
	 public Babysitting AnnulerReservationBabysitting();
    
}
