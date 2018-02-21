/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Entity.Medecin;
import Entity.User;
import Services.GestionGarderies;
import Services.GestionMedecins;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class ListesDocteursController implements Initializable {
    public static User cu=null;
    ObservableList<Medecin> list1 = FXCollections.observableArrayList();
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
    private ChoiceBox<String> specialité;
    @FXML
    private ChoiceBox<String> régions;
    @FXML
    private TextField nom;
    @FXML
    private Button find;
  ObservableList<String>list=FXCollections.observableArrayList();
  ObservableList<String>list2=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               list.removeAll(list);
               list2.removeAll(list2);
       String a="pédiatre";
         String b="dentiste";
         String c="tunis";
         String d="bizerte";
         list.addAll(a,b);
         list2.addAll(c,d);
         specialité.getItems().addAll(list);
        régions.getItems().addAll(list2);
       
                       
      
       
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
        list1.clear();
           GestionMedecins ga= new GestionMedecins();
       list1=ga.AfficherMedecins2(specialité.getValue(),régions.getValue(),nom.getText());
       tableUser.setItems(list1);
    }

    @FXML
    private void trouver(ActionEvent event) throws IOException {
       
        
    /*    Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
         //  Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        Pane root=loader.load(getClass().getResource("/views/Medecin.fxml").openStream());
      
         Scene scene=new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.show();*/
      
       initCol();
       tableUser.setVisible(true);
        loadData();
        tableUser.setCursor(Cursor.TEXT);
    }

    @FXML
    private void clickItem(MouseEvent event) throws IOException {
            if (event.getClickCount() == 1) //Checking double click
    {
      
         Medecin g=tableUser.getSelectionModel().getSelectedItem();
 
  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Medecin.fxml").openStream());
        MedecinController.cu=cu;
         MedecinController  m =(MedecinController )loader.getController();
        System.out.println(g.getId());
        m.getUser(g.getSpecialite(),g.getAdresse(),g.getNom());
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    
    }
        
    }

   
         
    
    
}
