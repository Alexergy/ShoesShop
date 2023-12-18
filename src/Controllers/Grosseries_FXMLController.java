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
import Back.DataBase;
import Back.MoneyAndService;
import Back.WorkWithScenes;

public class Grosseries_FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteServiceButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button putIntoBinButton;

    @FXML
    private Text whatWeChose;

    @FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
        whatWeChose.setText(whatWeChose.getText()+"\n"+
                DataBase.services.get(DataBase.services.size()-1).typeOfService+" - "
                + DataBase.services.get(DataBase.services.size()-1).priceOfService +"\n");
        
        goBackButton.setOnAction(event ->{
            MoneyAndService.moneyCost -= DataBase.services.get(DataBase.services.size()-1).priceOfService;
            DataBase.services.remove(DataBase.services.size()-1);
            
            WorkWithScenes.closeWindow(goBackButton, "Back");
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ChooseToFix_FXML.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(ChooseToFix_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 790, 700));
            stage.show();
        });
        
        putIntoBinButton.setOnAction(event ->{
            WorkWithScenes.closeWindow(putIntoBinButton, "PutIntoBin");
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/Bin_FXML.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(Bin_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 790, 700));
            stage.show();
        });
        
        deleteServiceButton.setOnAction(event ->{
            MoneyAndService.moneyCost -= DataBase.services.get(DataBase.services.size()-1).priceOfService;
            DataBase.services.remove(DataBase.services.size()-1);
            
            WorkWithScenes.closeWindow(deleteServiceButton, "deleteLastService");
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/Bin_FXML.fxml"));
            
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(Bin_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 790, 700));
            stage.show();
        });
    }

}
