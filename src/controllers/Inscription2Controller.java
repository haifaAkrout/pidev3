/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Inscription;
import Entity.User;
import Services.GestionInscription;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class Inscription2Controller implements Initializable {
    public static User cu = null;
    
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Hyperlink modif;
    @FXML
    private DatePicker dateamodifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void apparaitretext(ActionEvent event) {
              dateamodifier.setVisible(true);
            
    }

    @FXML
    private void supprimeredv(ActionEvent event) {
          GestionInscription a = new GestionInscription();
           System.out.println(cu.getCin());
           Inscription h = a.rechercherInscription(cu.getCin());
           a.annulerInscription(h.getUser().getCin());
           
    }

    @FXML
    private void modifier(ActionEvent event) {
             GestionInscription a = new GestionInscription();
             System.out.println(cu.getCin());
              Inscription h = a.rechercherInscription(cu.getCin());
        System.out.println(h);
         java.sql.Date datearemplacer = java.sql.Date.valueOf( dateamodifier.getValue() );
         System.out.println(datearemplacer);
       
        a.modifierInscription(datearemplacer,h.getUser().getCin());
         /*String f=date2;
         System.out.println(f);*/
         /*Date k=Date.valueOf(date2);
         System.out.println(k);*/
     /*  Inscription h = a.RechercherInscription(1);
        System.out.println(h);
        int b = h.getIdr();
         System.out.println(b);
          System.out.println("bonjour iheb");
        Timestamp datearemplacer = Timestamp .valueOf(dateamodifier.getText());
         System.out.println(datearemplacer);
        a.modifierRdv(h, b,datearemplacer);
        System.out.println(h.getDate_rdv().toString());
          lb3.setText("votre rendez vous est le " + dateamodifier.getText() + "et votre consultation concerne le" + v+ "de votre animal");
        //v=dateamodifier.getText().toString();*/
    }
    
}
