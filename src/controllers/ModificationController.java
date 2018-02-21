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
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class ModificationController implements Initializable {
  
    GestionUser gu = new GestionUser();
    public static User cu = null;
    public static String imageSelect = null;
    File selectedFile;
    @FXML
    private Button btn;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Email;
    @FXML
    private TextField NumeroTel;
    @FXML
    private TextField Ville;
    @FXML
    private TextField Rue;
    @FXML
    private PasswordField MotDePasse;
    @FXML
    private DatePicker DateNaiss;
    @FXML
    private TextField CodePostal;
    @FXML
    private ComboBox<String> Sexe;
    ObservableList<String> myData = FXCollections
            .observableArrayList("Homme", "Femme");
    @FXML
    private ImageView ImagePro;
    @FXML
    private Button Photo;
    private Image image;

    /**
     * Initializes the controller class.
     */
    public void SetUser(User u) {
        //   this.cu=u;
        Nom.setText(cu.getNom());
        Prenom.setText(cu.getPrenom());
        Email.setText(cu.getEmail());
        CodePostal.setText(String.valueOf(cu.getCodePostal()));
        DateNaiss.setValue(cu.getDateNaiss());
        MotDePasse.setText(cu.getMotDePasse());
        Rue.setText(cu.getRue());
        Ville.setText(cu.getVille());
        NumeroTel.setText(String.valueOf(cu.getTelephone()));
        Sexe.setValue(cu.getSexe());
        image = new Image(cu.getPhoto());
        ImagePro.setImage(image);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Sexe.setItems(myData);
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        if (selectedFile!=null)
        {
            imageSelect=selectedFile.toURI().toURL().toExternalForm();
        }
             User u = new User("Parent", Sexe.getValue(), DateNaiss.getValue(), Rue.getText(), Ville.getText(), Integer.parseInt(CodePostal.getText()), Integer.parseInt(NumeroTel.getText()), cu.getCin(), Nom.getText(), Prenom.getText(), Email.getText(), MotDePasse.getText(), imageSelect, cu.getPeudonyme());
            gu.updateUser(u, cu.getCin());
       
        cu = new User(u.getRole(), u.getSexe(), u.getDateNaiss(), u.getRue(), u.getVille(), u.getCodePostal(), u.getTelephone(), u.getCin(), u.getNom(), u.getPrenom(), u.getEmail(), u.getMotDePasse(),u.getPhoto(),u.getPeudonyme());
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/views/Desktop.fxml").openStream());
        DesktopController desktopController = (DesktopController) loader.getController();
        desktopController.cu = cu;
        desktopController.SetName(cu);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void Upload(ActionEvent event) {
        FileChooser f = new FileChooser();
        selectedFile = f.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                System.out.println(selectedFile.getAbsolutePath());
                Image image = new Image(selectedFile.toURI().toURL().toExternalForm());
                ImagePro.setImage(image);
                ImagePro.setPreserveRatio(true);
            } catch (MalformedURLException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("the file is not valid");

        }
    }
    
}
