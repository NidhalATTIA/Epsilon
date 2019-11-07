/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceAuthentification;
import Entite.Postulation;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Loua
 */
public class SeeMoreFXMLController implements Initializable {

    @FXML
    private Button forumb;
    @FXML
    private Button fluxrss;
    @FXML
    private Text nomAcceuil;
    @FXML
    private ImageView ImageFreelancer;
    @FXML
    private Button jobs;
    @FXML
    private Button Subscription;
    @FXML
    private Button jobsforS;
    @FXML
    private Button adsbtn;
    @FXML
    private Button Complaintsbtn;
    @FXML
    private Button more;
    @FXML
    private TextField aa;
    private Connection con = DataSource.getInstance().getConnection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            // TODO
            afficher();
            calculer();
        } catch (SQLException ex) {
            Logger.getLogger(SeeMoreFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

    @FXML
    private void goforum(ActionEvent event) {
    }

    @FXML
    private void showFluxRSS(ActionEvent event) {
    }

    @FXML
    private void goprofiln(MouseEvent event) {
    }

    @FXML
    private void goprofilp(MouseEvent event) {
    }

    @FXML
    private void Jobsbtn(ActionEvent event) {
    }

    @FXML
    private void Subscriptionbtn(ActionEvent event) {
    }

    @FXML
    private void jobsBySkill(ActionEvent event) {
    }

    @FXML
    private void Adsbtn(ActionEvent event) {
    }

    @FXML
    private void Complaintsbtn(ActionEvent event) {
    }

    @FXML
    private void seeMore(ActionEvent event) {
    }

    public String calculer() throws SQLException {
        String req = "SELECT COUNT(idAnnonce) FROM postulation WHERE idFreelancer=" + ServiceAuthentification.idf;
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            String postulation= rst.getString("COUNT(idAnnonce)");
            System.out.println(postulation);
            return (postulation);
             
        }

        return (null);

    }

    private void afficher() throws SQLException {
         aa.setText(calculer());
    }
    
}
