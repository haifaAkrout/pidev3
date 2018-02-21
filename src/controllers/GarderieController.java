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
import com.jfoenix.controls.JFXButton;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.TravelModes;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import static controllers.DesktopController.cu;
import java.io.File;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.controlsfx.control.Rating;


/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class GarderieController implements Initializable, MapComponentInitializedListener , DirectionsServiceCallback {
       
        
     public static User cu=null;
@FXML
    private TextField from;
    protected StringProperty from1 = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;
    String c;
 private GeocodingService geocodingService;
  private Garderie g;
    @FXML
    private GoogleMapView mapView2;
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
 private Image image;
   private GoogleMap map;
   Garderie a6;
   @FXML
    private ImageView imgView2;
    @FXML
    private Rating rating;
    @FXML
    private JFXButton inscription;
    
    private TextField toTextField;
    @FXML
    private JFXButton inscrit;
    

   
    /**
     * Initializes the controller class.
     */
       @Override
    public void initialize(URL url, ResourceBundle rb) {
         mapView2.addMapInializedListener(this);
       
    }
     public void getUser(String a){
              mapView2.addMapInializedListener(this);
 
            GestionGarderies ga= new GestionGarderies();
            String a1=a;
         
           
         a6= ga.rechercherGarderie2(a1);
    //    String cc=a6.getImage();
          
          c=a6.getAdresse();
         
File file = new File(a6.getImage());
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     

            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),imgView2.getFitWidth(),imgView2.getFitHeight(),true,true);
           imgView2.setImage(image);
          imgView2.setPreserveRatio(true);
           
         inputName2.setText(a6.getNom());
         System.out.println(a6.getAdresse());
          Adresse2.setText(a6.getAdresse());
          Telephone2.setText(Integer.toString(a6.getTelephone()));
          email2.setText(a6.getEmail());
          propriétaire2.setText(a6.getProprietaire());
               String m=a6.getAdresse();
      
                            
            rating.ratingProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

           
            GestionGarderies g=new GestionGarderies();
            g.ajouterRating(a6.getId(),(newValue.intValue()));
                 System.out.println(newValue);}
        });
           
          
    }
    

    

    

    @Override
    public void mapInitialized() {
        geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.606189, -122.335842))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(12);

        map = mapView2.createMap(mapOptions);
        MarkerOptions markerOptions = new MarkerOptions();
        directionsService = new DirectionsService();
        directionsPane = mapView2.getDirec();

        markerOptions.position(new LatLong(47.6, -122.3))
                .visible(Boolean.TRUE).title("My Marker");

        Marker marker = new Marker(markerOptions);

        map.addMarker(marker);
        geocodingService.geocode(Adresse2.getText(), (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }

            map.setCenter(latLong);

        });

    }

    @FXML
    private void Inscrire(ActionEvent event) throws IOException {
          System.out.println("jjjjjj");
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Inscription.fxml").openStream());
         InscriptionController  m =(InscriptionController )loader.getController();
        System.out.println(a6.getId());
        m.getUser(a6.getId(),a6.getDate_ouverture(),a6.getDate_fermeture());
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

     @FXML
    private void cherchertrajectoire(ActionEvent event) {

        to.set(Adresse2.getText());
        from1.set(from.getText());
        DirectionsRequest request = new DirectionsRequest(from1.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView2.getMap(), directionsPane));

    }

    @Override
    public void directionsReceived(DirectionsResult dr, DirectionStatus ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void inscrit2(ActionEvent event) throws IOException {
         System.out.println("jjjjjj");
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/inscription2.fxml").openStream());
        Inscription2Controller.cu=cu;
/*         InscriptionController  m =(InscriptionController )loader.getController();
        System.out.println(a6.getId());
        m.getUser(a6.getId(),a6.getDate_ouverture(),a6.getDate_fermeture());*/
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
   

    
    
}
