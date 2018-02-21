/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Enfant;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public interface InterfaceEnfant {
    public  void insererEnfant(Enfant e);
    public  void updateEnfant(Enfant e,String pseudonyme);
    public  void deleteEnfant(String pseudonyme);
    public  List<Enfant> selectEnfant(int cin);
    public void updateAge(int age,String Pseudonyme);
    public void updateSexe(String sexe,String Pseudonyme);
     public  Enfant rechercherEnfant(String a) ;
    
    
}
