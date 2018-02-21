/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class MedecinController2 implements Initializable {
    @FXML
    private Button modifier;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ChoiceBox<?> specialite;
    @FXML
    private TextField adresse;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private ImageView imgView2;
    @FXML
    private Button Supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadAddBook(ActionEvent event) {
    }

    @FXML
    private void loadAddMember(ActionEvent event) {
    }

    @FXML
    private void loadMemberTable(ActionEvent event) {
    }

    @FXML
    private void loadBookTable(ActionEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) {
        
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }
    
}
