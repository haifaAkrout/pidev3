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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AffichageListesMédecinsController implements Initializable {
    ObservableList<Medecin> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Medecin> tableUser;
    @FXML
    private TableColumn<?, ?> ColumnId;
    @FXML
    private TableColumn<?, ?> ColumnName;
    @FXML
    private TableColumn<?, ?> ColumnPrenom;
    @FXML
    private TableColumn<?, ?> ColumnTelephone;
    @FXML
    private TableColumn<?, ?> ColumnSpecialite;
    @FXML
    private TableColumn<?, ?> ColumnEmail;
    @FXML
    private TableColumn<?, ?> ColumnAdresse;
    @FXML
    private Label HHH;
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
        initCol();
        loadData();
        tableUser.setCursor(Cursor.TEXT);
    }

    private void initCol() {
         ColumnName.setCellValueFactory(new PropertyValueFactory<>("nom"));
       ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         ColumnAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     ;

         ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
          ColumnTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            ColumnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            
             ColumnSpecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
  
    }
    
    private void loadData() {
        list.clear();
           GestionMedecins ga= new GestionMedecins();
       list=ga.AfficherMedecins();
       tableUser.setItems(list);
    }
public void afficherCoordonnees(TableColumn.CellEditEvent editedCell) throws IOException{
 
}
 @FXML
public void clickItem(MouseEvent event) throws IOException
{
    if (event.getClickCount() == 1) //Checking double click
    {
      
        Medecin g=tableUser.getSelectionModel().getSelectedItem();
  
  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/RechercherMédecin2.fxml").openStream());
         RechercherMédecin2Controller  m =( RechercherMédecin2Controller )loader.getController();
        System.out.println(g.getId());
        m.getUser(g);
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    
    }
}


    @FXML
    private void loadAddBook(ActionEvent event) {
    }

    
}
