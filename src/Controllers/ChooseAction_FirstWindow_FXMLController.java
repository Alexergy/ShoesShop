package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.ShopTerminal_Driver;
import Back.MoneyAndService;
import Back.WorkWithScenes;

public class ChooseAction_FirstWindow_FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

//    @FXML
//    private Button buyNewButton;//кнопка для перехода в раздел покупки

    @FXML
    private Button fixButton;//кнопка для перехода в раздел починки обуви

    @FXML
    private Button goBackButton;//кнопка для возврата назад

    @FXML
    private Button leaveButton;//кнопка выхода

    @FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
        goBackButton.setOnAction(event ->{
            WorkWithScenes.closeWindow(goBackButton, "Back");
            
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
        
        leaveButton.setOnAction(event ->{
            WorkWithScenes.closeWindow(leaveButton, "Exit");
            
            if (MoneyAndService.moneyCost == 0){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/Leave_FXML.fxml"));

                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(Leave_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root, 790, 700));
                stage.show();
            }
            else {
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
            }
        });
        
//        buyNewButton.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                WorkWithScenes.closeWindow(buyNewButton, "Buy");                
//                
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("/FXML/Enter_FXML.fxml"));
//
//                try {
//                    loader.load();
//                } catch (IOException ex) {
//                    Logger.getLogger(Enter_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                Parent root = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setResizable(false);
//                stage.setScene(new Scene(root, 790, 700));
//                stage.show();
//        
//            }
//        });
        
        fixButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                WorkWithScenes.closeWindow(fixButton,"Fix");
                                
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
            }
        });
    }

}
