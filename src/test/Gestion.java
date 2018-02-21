package test;

import Entity.Garderie;
import Services.GestionGarderies;
import Services.GestionGarderies;
import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Gestion extends Application {

 @FXML
    private ListView<String> listView;
     private ObservableList<Garderie>data;
       private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
 
     
        
           

           

    private Image[] listOfImages=new Image[500];

    @Override
    public void start(Stage primaryStage) throws Exception {

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
    
        ObservableList<String> items =FXCollections.observableArrayList ("hhhh","bbbb","nnn"
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
       
        VBox box = new VBox(listView);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}