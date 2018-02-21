/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Garderie;
import Entity.Medecin;
import Entity.Rdv;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public interface IRdv {
       public void ajouterRdv(Rdv r);
  
     public ObservableList<Rdv> AfficherRdv();
 
}
