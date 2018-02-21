/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Garderie;
import Entity.Inscription;
import java.sql.Date;

/**
 *
 * @author atoufa traore
 */
public interface INscription {
         public void ajouterInscription(Inscription G);
public  Inscription rechercherInscription(int id) ;
 public void modifierInscription(Date G,int id) ;
   public void annulerInscription(int id);
    
}
