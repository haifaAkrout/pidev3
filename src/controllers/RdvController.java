/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Entity.Rdv;
import Services.GestionGarderies;
import Services.GestionRdv;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class RdvController implements Initializable {
    @FXML
    private TextField id_enfant;
    @FXML
    private TextField id_parent;
    @FXML
    private DatePicker date_rdv;
    @FXML
    private Button rdv;
    private int id=0;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
 public void getUser(int a){
     id=a;
 }
 
    @FXML
    private void PrendreRdv(ActionEvent event) throws IOException {
/*               int savedValue = Integer.parseInt(id_enfant.getText());
                int savedValue2 = Integer.parseInt(id_parent.getText());*/
               
java.sql.Date sqlDate = java.sql.Date.valueOf( date_rdv.getValue() );
 System.out.println(id);
  System.out.println(id_parent.getText());
   System.out.println(id_enfant.getText());
    System.out.println(sqlDate);
    GestionRdv ga= new GestionRdv();
    
          Rdv g = new Rdv(id_parent.getText(),id_enfant.getText(),sqlDate,id);
           
        System.out.println(g);
      ga.ajouterRdv(g);
       System.out.println("jjjjjj");
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/RdvInfos.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
      
        
    }
    
}
