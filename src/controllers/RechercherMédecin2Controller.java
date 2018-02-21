/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Entity.Medecin;
import Services.GestionGarderies;
import Services.GestionMedecins;
import com.jfoenix.controls.JFXButton;
import java.io.File;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class RechercherMédecin2Controller implements Initializable {
    
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField specialite;
    @FXML
    private TextField adresse;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private ImageView imgView2;
    private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
 private String c;
 private int a12;
    @FXML
    private Button modifier;
    @FXML
    private Button Supprimer;
    private Medecin m;
    @FXML
    private VBox vbox;
    @FXML
    private JFXButton liste;
    @FXML
    private JFXButton liste1;
    @FXML
    private JFXButton liste11;
    @FXML
    private JFXButton liste12;
    @FXML
    private JFXButton liste13;
    @FXML
    private JFXButton liste14;
    @FXML
    private JFXButton liste16;
    @FXML
    private JFXButton liste17;
    @FXML
    private JFXButton liste18;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void getUser(Medecin C){
            GestionMedecins ga= new GestionMedecins();
             m=ga.rechercherMedecin(C.getId());
            nom.setText(m.getNom());
                    adresse.setText(m.getAdresse());
                    
          c=m.getAdresse();
         

          
 File file = new File(m.getImage());
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     

            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),imgView2.getFitWidth(),imgView2.getFitHeight(),true,true);
           imgView2.setImage(image);
          imgView2.setPreserveRatio(true);
       
           
          nom.setText(m.getNom());
          prenom.setText(m.getPrenom());
       
          telephone.setText(Integer.toString(m.getTelephone()));
          email.setText(m.getEmail());
          specialite.setText(m.getSpecialite());
         
      } 

    @FXML
    private void loadAddBook(ActionEvent event) {
    }


    @FXML
    private void Modifier(ActionEvent event) throws IOException {
          GestionMedecins ga= new GestionMedecins();
          int savedValue = Integer.parseInt(telephone.getText());
        /* java.sql.Date sqlDate = java.sql.Date.valueOf( date_deb2.getValue() );
java.sql.Date sqlDate1 = java.sql.Date.valueOf( date_fin2.getValue() );

ToggleGroup toggleGroup = new ToggleGroup();
*/

// listen to changes in selected toggle

                Medecin g = new Medecin(nom.getText(),prenom.getText(),specialite.getText(),
                        savedValue,adresse.getText(),email.getText(),
                            "jjjjjj");

       ga.modifierMedecin(g, m.getId());
       Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichageListesMédecins.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
          GestionMedecins ga= new GestionMedecins();
       ga.supprimerMedecin(m.getId());
      Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichageListesMédecins.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
}
