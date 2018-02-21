 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import ConnexionDB.DataSource;
import Entity.Garderie;
import Services.GestionGarderies;
import com.jfoenix.controls.JFXButton;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.*;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AjoutGarderieController implements Initializable {

    @FXML
    private TextField inputName;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Telephone;
    private File file;
    private Stage stage;
    private FileChooser fileChooser;
    private Image image;

    @FXML
    private TextField propriétaire;
    @FXML
    private TextField email;
    @FXML
    private ImageView ImageView1;
    private FileInputStream fils;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button img;

    ObservableList<String> cursors = FXCollections.observableArrayList("oui", "non");
    private GoogleMap map;

    private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();
    @FXML
    private TextArea descriptif;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    private TextField langues;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;

    private String m1;
    private ChoiceBox<String> ch1;
    @FXML
    private TextField cout;
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
    @FXML
    private TextField heure_deb;
    @FXML
    private TextField heure_fin;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void newPersonButtonPushed(ActionEvent event) throws IOException, SQLException {
        int savedValue = Integer.parseInt(Telephone.getText());
        int savedValue2 = Integer.parseInt(cout.getText());

        java.sql.Date sqlDate = java.sql.Date.valueOf(date_deb.getValue());
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(date_fin.getValue());

        ToggleGroup toggleGroup = new ToggleGroup();

        r1.setToggleGroup(toggleGroup);
        r2.setToggleGroup(toggleGroup);

// listen to changes in selected toggle
        if (r1.isSelected()) {
            m1 = "French";
        } else {
            m1 = "English";

        }
        String aaa = heure_deb.getText();
        String ccc = heure_fin.getText();
        System.out.println(aaa);
        Time f = Time.valueOf(aaa);
        Time f1 = Time.valueOf(ccc);
        Garderie g = new Garderie(inputName.getText(), Adresse.getText(), savedValue, file.getAbsoluteFile().toString(), propriétaire.getText(), email.getText(), descriptif.getText(), m1, sqlDate, sqlDate1, savedValue2, 0, f, f1);
        System.out.println(inputName.getText());
        GestionGarderies ga = new GestionGarderies();
        ga.ajouterGarderie(g);
        System.out.println("hhh");
        Parent tableView = FXMLLoader.load(getClass().getResource("/views/affichage.fxml"));

        Scene tableViewScene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    private void showImg(ActionEvent event) {

        stage = (Stage) anchorPane.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(stage);
        System.out.println("hhhhh");
        if (file != null) {
            System.out.println("" + file.getAbsolutePath());
            image = new Image(file.getAbsoluteFile().toURI().toString(), ImageView1.getFitWidth(), ImageView1.getFitHeight(), true, true);
            ImageView1.setImage(image);
            ImageView1.setPreserveRatio(true);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loadAddBook(ActionEvent event) {
    }

    private void loadMemberTable(ActionEvent event) throws IOException {
        System.out.println("jjjjjj");
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/views/affichage.fxml").openStream());

        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(date_deb.getValue());
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(date_fin.getValue());
        if (sqlDate.compareTo(sqlDate1) > 0) {
            Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Information Dialogs");

            alerte.setHeaderText(null);
            alerte.setContentText("date_deb > date_fin");
            alerte.showAndWait();
        }
    }

}
