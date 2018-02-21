/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.User;
import Services.GestionUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class SignUpController implements Initializable {
     
   File selectedFile;
    int cin,tel,codep;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Ville;
    @FXML
    private DatePicker DateNaiss;
    @FXML
    private TextField Rue;
    @FXML
    private TextField CIN;
    @FXML
    private PasswordField MotDePasse;
    @FXML
    private ComboBox<String> Sexe;
    @FXML
    private TextField NumeroTelephone;
    @FXML
    private TextField CodePostal;
    @FXML
    private Button btnInscri;
    @FXML
    private Button btnAnnul;
     ObservableList<String> myData = FXCollections
            .observableArrayList("Homme", "Femme");
    @FXML
    private TextField Pseudonyme;
    @FXML
    private Button btnphoto;
    @FXML
    private ImageView Img;
    private Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Sexe.setValue("Je suis...");
         Sexe.setItems(myData);
    }    

    @FXML
    private void AddPerson(ActionEvent event) throws MalformedURLException {
        GestionUser gu= new GestionUser();
      
        
      User Parent = new User("Parent",Sexe.getValue(),DateNaiss.getValue(),Rue.getText(),Ville.getText(),Integer.parseInt(CodePostal.getText()),Integer.parseInt(NumeroTelephone.getText()),Integer.parseInt(CIN.getText()),Nom.getText(),Prenom.getText(),Email.getText(),MotDePasse.getText(),selectedFile.toURI().toURL().toExternalForm(),Pseudonyme.getText());
      try{ 
         gu.insererUser(Parent);
          ((Node)event.getSource()).getScene().getWindow().hide();

          Stage primaryStage=new Stage();
          FXMLLoader loader=new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/views/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
      } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      }

    @FXML
    private void Prenom(ContextMenuEvent event) {
    }

    @FXML
    private void btnAnnul(ActionEvent event) {
        try{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/views/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();} catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btnPhoto(ActionEvent event) {
         FileChooser f=new FileChooser();
     selectedFile=f.showOpenDialog(null);
        
        if (selectedFile!=null)
        {
            try{
            image = new Image(selectedFile.toURI().toURL().toExternalForm());
            Img.setImage(image);
            Img.setPreserveRatio(true);
            }catch (MalformedURLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }else{
            System.out.println("the file is not valid");
            
        }
    }
    
}
