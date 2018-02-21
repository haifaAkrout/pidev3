/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ConnexionDB.DataSource;
import Entity.Garderie;
import Services.GestionGarderies;
import Services.GestionMedecins;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableColumnBuilder;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class AffichageController implements Initializable {
    ObservableList<Garderie> list = FXCollections.observableArrayList();
    @FXML 
    private TableView<Garderie>tableUser;
      @FXML 
     private TableColumn<Garderie,String> ColumnName;
      
           @FXML 
     private TableColumn<Garderie,String> ColumnAdresse;
        @FXML 
     private TableColumn<Garderie,String> ColumnId;
        @FXML 
     private TableColumn<Garderie,String>  ColumnPropriétaire;
     
        @FXML 
     private TableColumn<Garderie,String> ColumnEmail;
     private TableColumn<Garderie,Image> ColumnImage;
           @FXML 
     private TableColumn<Garderie,String> ColumnTelephone;
    private ObservableList<Garderie>data;
       private File file;
    private Stage stage;
    private FileChooser fileChooser;
    private int b;
 private Image image;
    private Object AlertMaker;
    private int aa=0;
    @FXML
    private Label HHH;
    @FXML
    private TableColumn<?, ?> langues;
    @FXML
    private TableColumn<?, ?> Date_o;
    @FXML
    private TableColumn<?, ?> Date_f;
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
            ColumnPropriétaire.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
            
             langues.setCellValueFactory(new PropertyValueFactory<>("langues"));
            Date_o.setCellValueFactory(new PropertyValueFactory<>("date_ouverture"));
             Date_f.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
    }
    
    private void loadData() {
        list.clear();
           GestionGarderies ga= new GestionGarderies();
       list=ga.AfficherGarderies();
        
       tableUser.setItems(list);
    }
public void afficherCoordonnees(CellEditEvent editedCell) throws IOException{
 
}
 @FXML
public void clickItem(MouseEvent event) throws IOException
{
    if (event.getClickCount() == 1) //Checking double click
    {
      
         Garderie g=tableUser.getSelectionModel().getSelectedItem();
   aa=g.getId();
  Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/RechercherGarderie.fxml").openStream());
         RechercherGarderieController  m =(RechercherGarderieController )loader.getController();
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

    @FXML
    private void loadAddMember(ActionEvent event) {
    }

    @FXML
    private void loadMemberTable(ActionEvent event) throws IOException {
        System.out.println("jjjjjj");
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichage.fxml").openStream());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void loadBookTable(ActionEvent event) {
    }
    }
   /* @FXML 
    private TableView<Garderie>tableUser;
      @FXML 
     private TableColumn<Garderie,String> ColumnName;
          @FXML 
     private ListView<Garderie> listView;
      
           @FXML 
     private TableColumn<Garderie,String> ColumnAdresse;
        @FXML 
     private TableColumn<Garderie,String> ColumnId;
        @FXML 
     private TableColumn<Garderie,String>  ColumnPropriétaire;
     
        @FXML 
     private TableColumn<Garderie,String> ColumnEmail;
        @FXML 
     private TableColumn<Garderie,Image> ColumnImage;
           @FXML 
     private TableColumn<Garderie,String> ColumnTelephone;
    private ObservableList<Garderie>data;
       private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
  

    @FXML
    private Label HHH;
    @FXML
    private Button btnLoad;
 @FXML
    private ImageView   ImageView1;
  @FXML
    private ImageView   imageView;
    @FXML
    private Button img;
    @FXML
    private TableColumn<?, ?> hhhhh;
  
     @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
   

    @FXML
    private void loadDataFromDatabase(ActionEvent event) throws SQLException, IOException {
     
           System.out.println("hahaha");
        GestionGarderies ga= new GestionGarderies();
        data=ga.AfficherGarderies();
        System.out.println("hahaha4444");
      
  String a=data.get(23).getImage();
          System.out.println("jjjj");
          listView.setCellFactory(new Callback<ListView<Garderie>,ListCell<Garderie>>(){
 
               @Override
               public ListCell<Garderie> call(ListView<Garderie> param) {
ListCell cell =new ListCell<Garderie>(){
    @Override
    protected void updateItem(Garderie g,boolean btn1){
        super.updateItem(g, btn1);
        if(g!=null){
            Image img=new Image(getClass().getResource("/image/module_table_top.png").toExternalForm());
            ImageView imgView1=new ImageView(img);
            setGraphic(imgView1);
        }
        
    }
   
} ;return cell;}
          
          });
           listView.setItems(data);
                   File file = new File(a);
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     
    
            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
            imageView.setImage(image);
   
              ColumnName.setCellValueFactory(new PropertyValueFactory<>("nom"));
       ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         ColumnAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     ;

         ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
          ColumnTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            ColumnPropriétaire.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
             ColumnImage.setCellValueFactory(new PropertyValueFactory<>("imageView"));
             
            
             //final ImageView selectedImage = new ImageView(); 
            
       //   ColumnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tableUser.setItems(null);
        tableUser.setItems(data);
        System.out.println();
    
/* GestionGarderies ga= new GestionGarderies();
        data=ga.AfficherGarderies();
  
          
          
           
 File file = new File('"'+data.get(23).getImage()+'"');
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
      image = new Image(file.getAbsoluteFile().toURI().toString());

    
      // load in the background
  
     /*    aqw.setImage(image);
      
      //Setting the position of the image 
  aqw.setX(50); 
     aqw.setY(25); 
      
      //setting the fit height and width of the image view 
     aqw.setFitHeight(455); 
      aqw.setFitWidth(500); 
        System.out.println("jjjjjj");
      //Setting the preserve ratio of the image view */
     
       /*     Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
       Scene home_page_scene=new Scene(home_page_parent);
       Stage app_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    app_stage.setScene(home_page_scene);
           
    app_stage.show();}*/
    
    /*@FXML
     private void showImg(ActionEvent event) {
        
      GestionGarderies ga= new GestionGarderies();
        data=ga.AfficherGarderies();
  String a=data.get(23).getImage();
          
          
           
 File file = new File(a);
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     
    
            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),ImageView1.getFitWidth(),ImageView1.getFitHeight(),true,true);
           ImageView1.setImage(image);
           ImageView1.setPreserveRatio(true);
        
    }*/
