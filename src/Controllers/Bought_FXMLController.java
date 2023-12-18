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

public class Bought_FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goToTheBegginingButton;//кнопка выхода к меню с выбором действий

    @FXML
    private Button leaveShopButton;//кнопка выхода из магазина

    @FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
        goToTheBegginingButton.setOnAction(event -> {
            WorkWithScenes.closeWindow(goToTheBegginingButton, "BackToTheBeggining");
            
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
        
        leaveShopButton.setOnAction(event -> {
            WorkWithScenes.closeWindow(leaveShopButton, "Exit");
        });
    }

}
