/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class DesktopController implements Initializable {
    public static  User cu=null;

    @FXML
    private Label Nom;
    @FXML
    private Button Modifier;
    @FXML
    private Button ajouterEnfant;
    @FXML
    private ImageView ImagePro;
    @FXML
    private Button btnCov;
    @FXML
    private Button btnBabysittings;
    @FXML
    private Button btnMedecins;
    @FXML
    private Button btnGarderies;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/views/Modification.fxml").openStream());
        ModificationController modificationController = (ModificationController) loader.getController();
        modificationController.cu=cu;
        modificationController.imageSelect=cu.getPhoto();
        modificationController.SetUser(cu);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void SetName(User u) {
        //this.cu = u;
        Nom.setText(u.getNom() + " " + u.getPrenom());
        if (u.getPhoto()!=null)
        {
        Image im=new Image(u.getPhoto());
        ImagePro.setImage(im);
        }
        
    }

    @FXML
    private void ajoutEnfant(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
         AfficherController.cu = cu;
        Pane root = loader.load(getClass().getResource("/views/Afficher.fxml").openStream());
        System.out.println(cu);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    private void LoadCovoiturages(ActionEvent event) throws IOException {
          Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/AjoutCovoiturage.fxml").openStream());
         AjoutCovoiturageController.cu=cu;
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    

    @FXML
    private void LoadBabysittings(ActionEvent event) {
        /*   Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichageListesMédecins.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();*/
    }

    @FXML
    private void LoadMedecins(ActionEvent event) throws IOException {
           Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/ListesDocteurs.fxml").openStream());
        ListesDocteursController.cu=cu;
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void LoadGarderies(ActionEvent event) throws IOException {
           Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        ListesGarderiesController.cu=cu;
        Pane root=loader.load(getClass().getResource("/views/ListesGarderies.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
