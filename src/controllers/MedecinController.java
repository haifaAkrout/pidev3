/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Entity.Medecin;
import Entity.User;
import Services.GestionMedecins;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.TravelModes;
import static controllers.DesktopController.cu;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class MedecinController implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback   {
    public static User cu=null;
    protected StringProperty from1 = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;
        private GoogleMap map;
    private Text name;
     private Image image;
     private GeocodingService geocodingService;
    private GoogleMapView mapView;
    @FXML
    private Button rdv;
    private int a12=0;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField specialite;
    @FXML
    private TextField adresse;
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private ImageView imgView2;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GoogleMapView mapView2;
    @FXML
    private TextField from;
    @FXML
    private Hyperlink modif;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     mapView2.addMapInializedListener(this);
    }   
    
    public void getUser(String a,String b,String c){
         
        
            GestionMedecins ga= new GestionMedecins();
            String a1=a;
            String a2=b;
            String a3=c;
        Medecin a5= ga.rechercherMedecin(a1,a2,a3);
       // String cc=a5.getImage();
          
          c=a5.getAdresse();
           a12=a5.getId();
File file = new File(a5.getImage());
      
     // String localUrl = file.toURI().toURL().toString();
      // don't load in the background
     

            System.out.println(""+file.getAbsolutePath());
            image=new Image(file.getAbsoluteFile().toURI().toString(),imgView2.getFitWidth(),imgView2.getFitHeight(),true,true);
           imgView2.setImage(image);
          imgView2.setPreserveRatio(true);
           
          nom.setText(a5.getNom());
          prenom.setText(a5.getPrenom());
          adresse.setText(a5.getAdresse());
//          telephone.setText(Integer.toString(a5.getTelephone()));
          email.setText(a5.getEmail());
         specialite.setText(a5.getSpecialite());

          
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
        geocodingService.geocode(adresse.getText(), (GeocodingResult[] results, GeocoderStatus status) -> {

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
    private void rdv(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/Rdv.fxml").openStream());
         RdvController m=(RdvController)loader.getController();
        m.getUser(a12);
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void cherchertrajectoire(ActionEvent event) {
          to.set(adresse.getText());
        from1.set(from.getText());
        DirectionsRequest request = new DirectionsRequest(from1.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView2.getMap(), directionsPane));
    }

    @Override
    public void directionsReceived(DirectionsResult dr, DirectionStatus ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @FXML
    private void apparaitretext(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=loader.load(getClass().getResource("/views/email.fxml").openStream());
        
         System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        EmailController  m =(EmailController )loader.getController();
        System.out.println(cu);
       EmailController.cu=cu;
        m.getUser(email.getText());
        
         Scene scene=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
