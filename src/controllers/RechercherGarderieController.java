/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Garderie;
import Services.GestionGarderies;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
public class RechercherGarderieController implements Initializable, MapComponentInitializedListener {
    @FXML
    private ImageView imgView2;
    private TextArea descriptif2;
    private TextField ouverture;
        private File file;
    private Stage stage;
    private FileChooser fileChooser;
 private Image image;
  private GeocodingService geocodingService;
  private Garderie g;
    private GoogleMapView mapView;
     private StringProperty address = new SimpleStringProperty();
    private int b=0;
     
    private GoogleMap map;
    @FXML
    private Button delete;
    @FXML
    private TextField inputName;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField propriétaire;
    @FXML
    private TextField email;
    @FXML
    private TextField Telephone;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField inputName1;
    @FXML
    private TextField Adresse1;
    @FXML
    private TextField propriétaire1;
    @FXML
    private TextField email1;
    @FXML
    private TextField Telephone1;
    @FXML
    private DatePicker date_deb1;
    @FXML
    private DatePicker date_fin1;
    @FXML
    private TextField inputName2;
    @FXML
    private TextField Adresse2;
    @FXML
    private TextField propriétaire2;
    @FXML
    private TextField email2;
    @FXML
    private TextField Telephone2;
    @FXML
    private TextArea descriptif;
    @FXML
    private DatePicker date_deb2;
    @FXML
    private DatePicker date_fin2;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private Button modifier;
    private String m1;
    private String m11;
    @FXML
    private TextField cout;
    @FXML
    private TextField heure_deb;
    @FXML
    private TextField heure_fin;
    
    /**
     * Initializes the controller class.
     */
      public void getUser(Garderie i){
          
          this. g=i;
//             mapView.addMapInializedListener(this);
      //  System.out.println(b);
          GestionGarderies ga= new GestionGarderies();
        Garderie a= ga.rechercherGarderie(g.getId());
                       
              
        
          System.out.println(a.getHeure_deb());
           
 File file = new File(a.getImage());
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     

            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),imgView2.getFitWidth(),imgView2.getFitHeight(),true,true);
           imgView2.setImage(image);
          imgView2.setPreserveRatio(true);
       
        email2.setText(a.getEmail());
        inputName2.setText(a.getNom());
       Adresse2.setText(a.getAdresse());
        propriétaire2.setText(a.getProprietaire());
        Telephone2.setText(Integer.toString(a.getTelephone()));
        date_deb2.setValue(a.getDate_ouverture().toLocalDate());
        date_fin2.setValue(a.getDate_ouverture().toLocalDate());
      descriptif.setText(a.getDescription());
      cout.setText(Integer.toString(a.getCout()));
      heure_deb.setText(a.getHeure_deb().toString());      
      heure_fin.setText(a.getHeure_fin().toString());
      if (g.getLangues()=="French")
   {
   r2.setSelected(true);
  
   }
        else
{
   r1.setSelected(true);

    
}    
        
       //   address.bind(addressTextField.textProperty());  
        
    }

    @Override
    public void mapInitialized() {
          geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapView.createMap(mapOptions);
        geocodingService.geocode(g.getAdresse(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            
            map.setCenter(latLong);

        });
           
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
    }
    public void addressTextFieldAction(ActionEvent event) {
       
    }

    @FXML
    private void onDelete(ActionEvent event) throws IOException {
         GestionGarderies ga= new GestionGarderies();
       ga.supprimerGarderie(g.getId());
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichage.fxml").openStream());
       
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
         GestionGarderies ga= new GestionGarderies();
         java.sql.Date sqlDate = java.sql.Date.valueOf( date_deb2.getValue() );
java.sql.Date sqlDate1 = java.sql.Date.valueOf( date_fin2.getValue() );

ToggleGroup toggleGroup = new ToggleGroup();

r1.setToggleGroup(toggleGroup);
r2.setToggleGroup(toggleGroup);
if (r1.isSelected())
   {
    m11="French";
    
   }
        else
{
    m11="English";
    
}    
int savedValue = Integer.parseInt(Telephone2.getText());
int savedValue2 = Integer.parseInt(cout.getText());
// listen to changes in selected toggle
 Time f=Time.valueOf(heure_deb.getText());
   Time f1=Time.valueOf(heure_fin.getText());
    
          Garderie g2 = new Garderie(inputName2.getText(),Adresse2.getText(),savedValue,g.getImage(),propriétaire2.getText(),email2.getText(),descriptif.getText(),m11,sqlDate,sqlDate1,savedValue2,f,f1);
       ga.modifierGarderie(g2, g.getId());
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/affichage.fxml").openStream());
       
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
