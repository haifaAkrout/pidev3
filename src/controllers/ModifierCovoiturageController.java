/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Covoiturage;
import Entity.User;
import Services.GestionCovoiturage;
import static controllers.AjoutCovoiturageController.cu;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class ModifierCovoiturageController implements Initializable {
   
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
	private Button btnModif;
	
	Covoiturage Covoit;
	@FXML
	private TextField cinTxt;
	@FXML
	private Button btnSupp;
private Covoiturage Cov; 
	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	public void getUser(Covoiturage C){
		System.out.println(C);
		this.Cov=C;
		
		GestionCovoiturage G=new GestionCovoiturage();
		Covoiturage R=G.RechercheCovoiturage2(Cov.getDate());
            System.out.println(R);
        
		nbrPlacesTxt.setText(String.valueOf(R.getNbr_places()));
		heureDepartTxt.setText(String.valueOf(R.getHeure_dep()));
		datecovoiturageTxt.setValue(R.getDate().toLocalDate());
		adresseDepartTxt.setText(R.getLieu_dep());
		adresseDepartTxt.setText(R.getLieu_dep());
		adresseDestinationTxt.setText(R.getLieu_dest());
		int cin =R.getCovoitureur().getCin();
		cinTxt.setText(String.valueOf(cin));
		
	//	cinTxt.setText(value);
	}	

	@FXML
	private void ModifierCovoiturage(ActionEvent event) throws IOException {
		
		GestionCovoiturage ga= new GestionCovoiturage();
        int nbr_places=Integer.parseInt(nbrPlacesTxt.getText());
        //int heure_dep=Integer.parseInt(heureDepartTxt.getText());
            java.sql.Time heure_dep=java.sql.Time.valueOf(heureDepartTxt.getText());
        int cin=Integer.parseInt(cinTxt.getText());
        java.sql.Date ladate = java.sql.Date.valueOf( datecovoiturageTxt.getValue() );
		String depart=adresseDepartTxt.getText();
		String destination=adresseDestinationTxt.getText();
                

         
      Covoiturage C=new Covoiturage(ladate,nbr_places,heure_dep,depart,destination,Cov.getCovoitureur());
       GestionCovoiturage G=new GestionCovoiturage();
	   G.ModifierCovoiturage(C,Cov.getId());
		/* Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Debut Modif");
        alert.showAndWait();*/
		////////////////
		
		
		//Covoiturage Cov=(Covoiturage) btnModif.getUserData();
		
     //  G.AjouterCovoiturage(C);
	     
	  
	    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setContentText("Covoiturage modifié avec succès");
        alert1.showAndWait();
		
		Parent list_page_parent = FXMLLoader.load(getClass().getResource("/views/ListeCovoiturages.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); 
                app_stage.setScene(list_page_scene);
                app_stage.show(); 
	    
	}

	@FXML
	private void SupprimerCovoiturage(ActionEvent event) throws IOException {
		
		 Alert alert =new Alert (AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Voulez vous vraiment supprimer ce Covoiturage ?");
        Optional <ButtonType> action=alert.showAndWait();
        if (action.get()==ButtonType.OK){
         GestionCovoiturage GC= new GestionCovoiturage();
		 System.out.println(Cov);
        GC.SupprimerCovoiturage(Cov.getId());
		  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setContentText("Covoiturage supprimé avec succès");
        alert1.showAndWait();
		////
		Parent list_page_parent = FXMLLoader.load(getClass().getResource("/views/ListeCovoiturages.fxml"));
        Scene list_page_scene = new Scene(list_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                app_stage.hide(); 
                app_stage.setScene(list_page_scene);
                app_stage.show(); 
       
		}
	}
    
}
