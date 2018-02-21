/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.CurrentUser;
import Entity.Enfant;
import Services.GestionEnfant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class GererEnfantController implements Initializable {
  CurrentUser cu;

    void SetUser(CurrentUser cu) {

        this.cu = cu;

    }
    GestionEnfant ge = new GestionEnfant();

    @FXML
    private TableView<Enfant> table;
    private ObservableList<Enfant> data;
    @FXML
    private TableColumn<Enfant, String> Pseudonyme;
    @FXML
    private TableColumn<Enfant, Integer> Age;
    @FXML
    private TableColumn<Enfant, String> Sexe;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    public void changerAge(CellEditEvent edditedCell) {
        Enfant EnfantSelect = table.getSelectionModel().getSelectedItem();
        EnfantSelect.setAge(Integer.parseInt(edditedCell.getNewValue().toString()));
    }

    public void changerSexe(CellEditEvent edditedCell) {
        Enfant EnfantSelect = table.getSelectionModel().getSelectedItem();
        EnfantSelect.setSexe(edditedCell.getNewValue().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ge = new GestionEnfant();
        System.out.println("test");

        ObservableList<Enfant> list = FXCollections.observableArrayList(ge.selectEnfant(cu.getCin()));
        System.out.println("hhhhhhhhhhhhhhh");
        Pseudonyme.setCellValueFactory(new PropertyValueFactory("Pseudonyme"));
        Age.setCellValueFactory(new PropertyValueFactory("Age"));
        Sexe.setCellValueFactory(new PropertyValueFactory("Sexe"));
        table.setItems(list);
        // Transformation bouh :
        // table.setEditable(true);
        /*Age.setCellFactory(TextFieldTableCell.forTableColumn());
        Sexe.setCellFactory(TextFieldTableCell.forTableColumn());*/
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    /*    @FXML
    private void changerAge(CellEditEvent<S, T> event) {
    }

    @FXML
    private void changerSexe(CellEditEvent<S, T> event) {
    }*/
}
