/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Covoiturage;
import Entity.Garderie;
import Entity.User;
import Services.GestionCovoiturage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class ListeCovoituragesController implements Initializable {
 
    ObservableList<Covoiturage> listCov = FXCollections.observableArrayList();
    @FXML
    private TableView<Covoiturage> tableCovoiturages;
    @FXML
    private TableColumn<?, ?> idCov;
    @FXML
    private TableColumn<?, ?> dateCov;
    @FXML
    private TableColumn<?, ?> nbrPlaces;
    @FXML
    private TableColumn<?, ?> heurDep;
    @FXML
    private TableColumn<?, ?> lieuDep;
    @FXML
    private TableColumn<?, ?> lieuDest;
    @FXML
    private TableColumn<?, ?> covoitureur;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnSupp;
    private User cu1;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    
     public void setUser(User u)
    {
        this.cu1=u;
         initColumns();
		loadCovList();
    }

    @FXML
    private void SelectIdCov(MouseEvent event) throws IOException {
        if (event.getClickCount() == 1) //Checking double click
    {
      
         Covoiturage g=tableCovoiturages.getSelectionModel().getSelectedItem();

  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/ModifierCovoiturage.fxml").openStream());
         ModifierCovoiturageController  m =(ModifierCovoiturageController )loader.getController();
      System.out.println(g.getId());
        System.out.println("jkjkjk");
        m.getUser(g);
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    
    }
    }

    @FXML
    private void PageAjout(ActionEvent event) {
    }

    @FXML
    private void SupprimerCovoiturage(ActionEvent event) {
    }
    private void initColumns(){
	 
		idCov.setCellValueFactory(new PropertyValueFactory<>("id"));
		dateCov.setCellValueFactory(new PropertyValueFactory<>("date"));
		nbrPlaces.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));
		heurDep.setCellValueFactory(new PropertyValueFactory<>("heure_dep"));
		lieuDep.setCellValueFactory(new PropertyValueFactory<>("lieu_dep"));
		lieuDest.setCellValueFactory(new PropertyValueFactory<>("lieu_dest"));
		covoitureur.setCellValueFactory(new PropertyValueFactory<>("covoitureur"));		
	}
	 private void loadCovList() {
        //listCov.clear();
        GestionCovoiturage GC=new GestionCovoiturage();
       listCov=GC.ListerCovoiturages(cu1.getCin());
       tableCovoiturages.setItems(listCov);

    }	
    
}
