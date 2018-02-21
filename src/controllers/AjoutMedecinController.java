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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AjoutMedecinController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ChoiceBox<String> specialite;
    @FXML
    private TextField adresse;
    @FXML
    private TextField telephone;
    @FXML
    private Button img;
    @FXML
    private ImageView ImageView1;
    @FXML
    private TextField email;
    private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
   @FXML
    private AnchorPane anchorPane;
 
   ObservableList<String>list=FXCollections.observableArrayList();
  ObservableList<String>list2=FXCollections.observableArrayList();
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
       list.removeAll(list);
       String a="pédiatre";
         String b="dentiste";
         String c="tunis";
         String d="bizerte";
         list.addAll(a,b);
     
         specialite.getItems().addAll(list);
    }    

    @FXML
    private void showImg(ActionEvent event) {
             
        stage=(Stage)anchorPane.getScene().getWindow(); 
    FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open Resource File");
file=fileChooser.showOpenDialog(stage);
        System.out.println("hhhhh");
      if(file!=null){
            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),ImageView1.getFitWidth(),ImageView1.getFitHeight(),true,true);
           ImageView1.setImage(image);
           ImageView1.setPreserveRatio(true);
        }
    }

    @FXML
    private void newPersonButtonPushed(ActionEvent event) throws IOException {
         int savedValue = Integer.parseInt(telephone.getText());
      //   String nom, String prenom, String specialite, int telephone, String adresse, String email, String image
            Medecin g = new Medecin(nom.getText(),prenom.getText(),specialite.getValue(),savedValue,adresse.getText(),email.getText(),file.getAbsoluteFile().toString());
            

            GestionMedecins ga= new GestionMedecins();
      ga.ajouterMedecin(g);
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichageListesMédecins.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void loadAddBook(ActionEvent event) {
    }

    
}
