/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Services.GestionGarderies;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class Affichage2Controller implements Initializable {
    @FXML
    private ListView<String> listView;
     private ObservableList<Garderie>data;
       private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
 
           @FXML
          private  VBox box ;
        
           

           

    private Image[] listOfImages=new Image[500];

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          GestionGarderies ga= new GestionGarderies();
        data=ga.AfficherGarderies();

     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     
    
            
            for(int i=0;i<data.size();i++){
                  String a=data.get(i).getImage();  
   File file = new File(a);
      System.out.println(""+file.getAbsolutePath());
        //listOfImages.add();
      listOfImages[i]=new Image(file.getAbsoluteFile().toURI().toString());
    }
    
        ObservableList<String> items =FXCollections.observableArrayList (
                );
        listView.setItems(items);

        listView.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                  for(int i=0;i<data.size();i++){
                      imageView.setImage(listOfImages[i]);
                    setGraphic(imageView);
                  }
                }
            }
        });
       
    }    
    
}
