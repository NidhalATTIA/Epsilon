/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Postulation;
import Service.ServicePostulation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Loua
 */
public class AjouterPostulationFXMLController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tffreelancer;
    @FXML
    private TextField tfannonce;
    @FXML
    private TextArea tfcontenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPostulation(ActionEvent event) {
        Postulation p = new Postulation();
        p.setID(Integer.valueOf(tfid.getText()));
        p.setIdFreelancer(Integer.valueOf(tffreelancer.getText()));
        p.setIdAnnonce(Integer.valueOf(tfannonce.getText()));
        p.setContenu(tfcontenu.getText());
        ServicePostulation sp = new ServicePostulation();
        
        try {
            sp.ajouterPostulation(p);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPostulationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
