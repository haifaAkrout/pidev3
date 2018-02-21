/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Enfant;
import Entity.User;
import Services.GestionEnfant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AfficherController implements Initializable {
   GestionEnfant ge=new GestionEnfant();
    public static User cu = null;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Retour;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField Pseudo;
    @FXML
    private TextField Ag;
    @FXML
    private ComboBox<String> Sex;
    ObservableList<String> myData = FXCollections
            .observableArrayList("Garçon", "Fille");
     ObservableList<Enfant>list = FXCollections.observableArrayList(ge.selectEnfant(cu.getCin()));

    @FXML
    private TableView<Enfant> TableEnfant;
    @FXML
    private TableColumn<Enfant, String> Pseudonyme;
    @FXML
    private TableColumn<Enfant, Integer> Age;
    @FXML
    private TableColumn<Enfant, String> Sexe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sex.setValue("Sexe");
        Sex.setItems(myData);
        Pseudonyme.setCellValueFactory(new PropertyValueFactory("Pseudonyme"));
        Age.setCellValueFactory(new PropertyValueFactory("Age"));
        Sexe.setCellValueFactory(new PropertyValueFactory("Sexe"));
        TableEnfant.setItems(list);
         TableEnfant.setEditable(true);
        Age.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>(){

        @Override
        public String toString(Integer object) {
            return object.toString();
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }

    }));
        Sexe.setCellFactory(TextFieldTableCell.forTableColumn());

    }

  
    @FXML
    public void changerAge(TableColumn.CellEditEvent edditedCell) {
        Enfant EnfantSelect = TableEnfant.getSelectionModel().getSelectedItem();
        EnfantSelect.setAge(Integer.parseInt(edditedCell.getNewValue().toString()));
         ge.updateAge(Integer.parseInt(edditedCell.getNewValue().toString()),EnfantSelect.getPseudonyme());
    }

    @FXML
    public void changerSexe(TableColumn.CellEditEvent edditedCell) {
        Enfant EnfantSelect = TableEnfant.getSelectionModel().getSelectedItem();
        EnfantSelect.setSexe(edditedCell.getNewValue().toString());
        ge.updateSexe(edditedCell.getNewValue().toString(), EnfantSelect.getPseudonyme());
    }
   

    @FXML
    private void AjouterEnfant(ActionEvent event) {
       Enfant e=new Enfant(cu.getCin(),Integer.parseInt(Ag.getText()), Pseudo.getText(), Sex.getValue());
        ge.insererEnfant(e);
        Pseudo.setText("");
        Ag.setText("");
        Sex.setValue("Sexe");
        TableEnfant.getItems().add(e);
       
    }

    @FXML
    private void Retour(ActionEvent event) {
        
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        
    }
    @FXML
    private void deleteEnfant(MouseEvent event) {
      
        ge.deleteEnfant(TableEnfant.getSelectionModel().getSelectedItem().getPseudonyme());
         TableEnfant.getItems().removeAll(TableEnfant.getSelectionModel().getSelectedItem());

    }
}
