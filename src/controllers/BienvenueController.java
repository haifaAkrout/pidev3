/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Services.GestionGarderies;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class BienvenueController implements Initializable {

    /**
     * Initializes the controller class.
     */
 private Garderie g;
 

    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private TextField dateamodifier;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
       public void getUser(String a,String b,int c){
           GestionGarderies a2=new GestionGarderies();
           g=a2.rechercherGarderie(c);
           System.out.println(g);

           
       
         
}


    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
