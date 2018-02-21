/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Entity.Inscription;
import Services.GestionGarderies;
import Services.GestionInscription;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class InscriptionController implements Initializable {
     private Garderie g2;
    @FXML
    private TextField id_enf;
    @FXML
    private TextField id_p;
    @FXML
    private DatePicker jour_arriv;
    @FXML
    private TextArea commentaire;
    @FXML
    private ChoiceBox<String> nurserie;
    @FXML
    private ChoiceBox<String> repas;
    @FXML
    private Button btn;
    private int g1;
    private Date a1;
    private Date a5;
    @FXML
    private Text a2;
    ObservableList<String>list=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       list.removeAll(list);
       String a="oui";
         String b="non";
         list.addAll(a,b);
         nurserie.getItems().addAll(list);
         repas.getItems().addAll(list);
                 
                 
    }    
public void getUser(int i,Date v,Date b){
          
          this. g1=i;
          this.a1=v;
          this.a5=b;
          a2.setText("ATTENTION : LA GARDERIE EST OUVERTE  LES SEMAINES: "+a1.toString()+" JUSQU'A "+a5.toString());
        
          System.out.println(g1);
        
      //  System.out.println(b);
         
}
    @FXML
    private void inscription(ActionEvent event) throws IOException {
  
java.sql.Date sqlDate = java.sql.Date.valueOf( jour_arriv.getValue() );
      System.out.println(g1+"hhhhhhhhhhh");
        
        Inscription g = new Inscription(id_enf.getText(),id_p.getText(),sqlDate,commentaire.getText(),nurserie.getValue(),repas.getValue(),g1);
           
          GestionInscription ga= new GestionInscription();
      ga.ajouterInscription(g);
      Alert alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Information Dialogs");
           GestionGarderies a2=new GestionGarderies();
           g2=a2.rechercherGarderie(g1);
        alerte.setHeaderText(null);
		alerte.setContentText("Mr/Mrs:   "+id_p.getText()+"     Votre demande d'inscription de votre enfant    "+id_enf.getText()+ "   à la garderie   "+g2.getNom()+"  a étè acceptée");

        alerte.showAndWait();
     /*  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Bienvenue.fxml").openStream());
       BienvenueController m =(BienvenueController )loader.getController();
       
        m.getUser(id_enf.getText(),id_p.getText(),g1);
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();*/
      /*  Parent tableView = FXMLLoader.load(getClass().getResource("/views/affichage.fxml"));
        
        
        Scene tableViewScene= new Scene(tableView);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();*/
    }
    
}
