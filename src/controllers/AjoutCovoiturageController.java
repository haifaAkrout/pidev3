/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Covoiturage;
import Entity.User;
import Services.GestionCovoiturage;
import static controllers.DesktopController.cu;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AjoutCovoiturageController implements Initializable {
   public static User cu;
    @FXML
    private Button btnAjout;
    @FXML
    private TextField nbrPlacesTxt;
    @FXML
    private DatePicker datecovoiturageTxt;
    @FXML
    private TextField heureDepartTxt;
    @FXML
    private TextArea adresseDepartTxt;
    @FXML
    private TextArea adresseDestinationTxt;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutCovoiturage(ActionEvent event) throws IOException {
        int nbr_places=Integer.parseInt(nbrPlacesTxt.getText());
        java.sql.Time heure_dep=java.sql.Time.valueOf(heureDepartTxt.getText());
        int cin=cu.getCin();
        
        java.sql.Date ladate = java.sql.Date.valueOf( datecovoiturageTxt.getValue() );
		String depart=adresseDepartTxt.getText();
		String destination=adresseDestinationTxt.getText();
	
		Covoiturage C=new Covoiturage(ladate,nbr_places,heure_dep,depart,destination,cu);
       GestionCovoiturage G=new GestionCovoiturage();
       
       G.AjouterCovoiturage(C);
	  
	   Alert alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Information Dialogs");
        alerte.setHeaderText(null);
		alerte.setContentText("Ajout effectué avec succès");

        alerte.showAndWait();
         
		
    }

    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
              Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        System.out.println(cu);
  
        Pane root=loader.load(getClass().getResource("/views/Desktop.fxml").openStream());
       
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void AfficherMesCovoiturage(ActionEvent event) throws IOException {
              Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        System.out.println(cu);
  
        Pane root=loader.load(getClass().getResource("/views/ListeCovoiturages.fxml").openStream());
              ListeCovoituragesController  m =(ListeCovoituragesController  )loader.getController();
      m.setUser(cu);
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
