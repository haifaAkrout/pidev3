/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.User;
import Services.GestionUser;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class LoginController implements Initializable {
    @FXML
    private TextField Email;
    @FXML
    private Button login;
    @FXML
    private PasswordField MotDePasse;
    @FXML
    private Label Text;
    @FXML
    private Button Inscription;
    @FXML
    private Button Facebook;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Connection(ActionEvent event) throws IOException {
        GestionUser Gu = new GestionUser();
        if (Gu.isConncected(Email.getText(), MotDePasse.getText())) {
            User u = Gu.selectUser(Email.getText());
            User cu = new User(u.getRole(), u.getSexe(), u.getDateNaiss(), u.getRue(), u.getVille(), u.getCodePostal(), u.getTelephone(), u.getCin(), u.getNom(), u.getPrenom(), u.getEmail(), u.getMotDePasse(), u.getPhoto(), u.getPeudonyme());
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/views/Desktop.fxml").openStream());
            DesktopController desktopController = (DesktopController) loader.getController();
            DesktopController.cu = cu;
            desktopController.SetName(cu);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            Text.setText("Connexion réussie");
            System.out.println(u);
        } else {
            Text.setText("email ou mot de passe incorrect !");
        }
    }

    @FXML
    private void Inscription(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/views/SignUp.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ConnexionFb(ActionEvent event) {
/*        Browser facebookBrowser = new Browser("458871741206567", "fccc2ef88b4fa915290bb1d6f9e9a003");
        Scene fbloginwindow;
        fbloginwindow = new Scene(facebookBrowser, 900, 600, Color.web("#666970"));
        Stage st = new Stage();
        st.setScene(fbloginwindow);
        st.show();
        facebookBrowser.showLogin(st);*/

    }

}
