package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Back.WorkWithScenes;

public class HelloWindow_FXMLController implements Initializable {

    @FXML
    private Button enterAtShopButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enterAtShopButton.setOnAction(event ->{
            WorkWithScenes.closeWindow(enterAtShopButton, "Enter");
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/Enter_FXML.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(Enter_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 790, 700));
            stage.show();
        });
    } 
}
