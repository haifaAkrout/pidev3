/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Enfant;
import Entity.Garderie;
import Entity.Medecin;
import Entity.Rdv;
import Entity.User;
import Services.GestionGarderies;
import Services.GestionRdv;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class RdvInfosController implements Initializable {
     ObservableList<Rdv> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Rdv> tableUser;
    @FXML
    private TableColumn<?, String> nomP;
    @FXML
    private TableColumn<?, ?> Age;
    @FXML
    private TableColumn<?, String> Sexe;
    @FXML
    private TableColumn<?, Medecin> Médecin;
    @FXML
    private TableColumn<?, Date> date_rdv;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
    //    loadData();
   
    }

    private void initCol() {
            list.clear();
           GestionRdv ga= new GestionRdv();
       list=ga.AfficherRdv();
      tableUser.setItems(list);
        
         
      
          nomP.setCellValueFactory(new PropertyValueFactory<>("nom"));
         
          
       //nomP.setCellValueFactory(new PropertyValueFactory<>();
        // System.out.println("haifa");
    Age.setCellValueFactory(new PropertyValueFactory<>("age"));
         Sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
     ;

        Médecin.setCellValueFactory(new PropertyValueFactory<>("specialite"));
         date_rdv.setCellValueFactory(new PropertyValueFactory<>("date_rdv"));
      
    }
    
    private void loadData() {
        list.clear();
           GestionRdv ga= new GestionRdv();
       list=ga.AfficherRdv();
  //    tableUser.setItems(list);
       
    }
    
}
