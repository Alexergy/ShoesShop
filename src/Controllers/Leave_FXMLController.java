package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.ShopTerminal_Driver;
import Back.WorkWithScenes;

public class Leave_FXMLController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goBackButton;

    @FXML
    private Button leaveShopButton;

    @FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
        leaveShopButton.setOnAction(event ->{
            WorkWithScenes.closeWindow(leaveShopButton, "Exit");
        });
        
        goBackButton.setOnAction(event -> {
            WorkWithScenes.closeWindow(goBackButton, "Back");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ChooseAction_FirstWindow_FXML.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(ChooseAction_FirstWindow_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 790, 700));
            stage.show();
        });
    }

}
