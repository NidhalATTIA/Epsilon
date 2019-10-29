
package com.lynden.gmapsexampleapp;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
//import com.lynden.gmapsfx.javascript.object.MapType;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.PhongMaterial.MapType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class FXMLController implements Initializable, MapComponentInitializedListener {
    
    
    @FXML
    private GoogleMapView mapView;
    
    private GoogleMap map;
    @FXML
    private Button BcontactUs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }    

    @Override
    public void mapInitialized() {
           LatLong SmartStart = new LatLong(36.899296, 10.189640);
    
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(36.899296, 10.189640))
  //              .mapType(MapType.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
                   
        map = mapView.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(SmartStart);
              
      
    }   

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUs.getScene().setRoot(root);
    }
    
}