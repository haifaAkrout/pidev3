/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Entity.User;
import Services.GestionGarderies;
import static controllers.DesktopController.cu;
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
import javafx.scene.control.Button;
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
public class ListesGarderiesController implements Initializable {
    public static User cu=null;
       ObservableList<Garderie> list = FXCollections.observableArrayList();
    private TextField nom;
      private int aa=0;
    @FXML
    private Button find;
    @FXML
    private TextField adresse;
    @FXML
    private TableView<Garderie> tableUser;
    @FXML
    private TableColumn<?, ?> ColumnId;
    @FXML
    private TableColumn<?, ?> ColumnName;
    @FXML
    private TableColumn<?, ?> ColumnAdresse;
    @FXML
    private TableColumn<?, ?> ColumnTelephone;
    @FXML
    private TableColumn<?, ?> ColumnPropriétaire;
    @FXML
    private TableColumn<?, ?> ColumnEmail;
    @FXML
    private TableColumn<?, ?> langues;
    @FXML
    private TableColumn<?, ?> Date_o;
    @FXML
    private TableColumn<?, ?> Date_f;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(cu.getCin());
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
            ColumnPropriétaire.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
            
             langues.setCellValueFactory(new PropertyValueFactory<>("langues"));
            Date_o.setCellValueFactory(new PropertyValueFactory<>("date_ouverture"));
             Date_f.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
    }
    
    private void loadData() {
        list.clear();
           GestionGarderies ga= new GestionGarderies();
       list=ga.AfficherGarderies2(adresse.getText());
        
       tableUser.setItems(list);
    }

    @FXML
    private void trouver(ActionEvent event) throws IOException {
        
         initCol();
         tableUser.setVisible(true);
        loadData();
         
    }

    @FXML
    private void clickItem(MouseEvent event) throws IOException {
        /*   Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Garderie.fxml").openStream());
          GarderieController m=(GarderieController)loader.getController();
          System.out.println(nom.getText());
          System.out.println(adresse.getText());
        m.getUser(nom.getText(),adresse.getText());
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();*/
        if (event.getClickCount() == 1) //Checking double click
    {
      
         Garderie g=tableUser.getSelectionModel().getSelectedItem();
   aa=g.getId();
  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Garderie.fxml").openStream());
         GarderieController  m =(GarderieController )loader.getController();
         GarderieController.cu=cu;
        System.out.println(g.getId());
        m.getUser(g.getAdresse());
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    
    }
    }
        
    
}
