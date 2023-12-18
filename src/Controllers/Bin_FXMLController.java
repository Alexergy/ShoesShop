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

public class Bin_FXMLController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button deleteAndLeaveButton;

	@FXML
	private Button goBackButton;

	@FXML
	private Button backToCatalogButton;

	@FXML
	private Text howMuchMoneyButton;

	@FXML
	private Button payButton;
	
	@FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
		String text = howMuchMoneyButton.getText();
		howMuchMoneyButton.setText(text+MoneyAndService.moneyCost+"\n");

		//System.out.println("text - " + text);
		//System.out.println("howMuchMoneyButton - " + howMuchMoneyButton.getText());

		for (int i=0; i<DataBase.services.size(); i++){
			howMuchMoneyButton.setText(howMuchMoneyButton.getText()+(i+1)+") "+DataBase.services.get(i).typeOfService+
					" - "+ DataBase.services.get(i).priceOfService +"\n");
			//System.out.println("howMuchMoneyButton - " + howMuchMoneyButton.getText());
		}

		backToCatalogButton.setOnAction(event ->{
			WorkWithScenes.closeWindow(backToCatalogButton, "BackToCatalog");

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

		payButton.setOnAction(event ->{
			WorkWithScenes.closeWindow(payButton, "Pay");

			//go to the next window - card info and pay
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXML/CardPay_FXML.fxml"));

			try {
				loader.load();
			} catch (IOException ex) {
				Logger.getLogger(CardPay_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root, 790, 700));
			stage.show();
		});

		deleteAndLeaveButton.setOnAction(event ->{
			//clean info into clientInfo
			int sizeOfServices = DataBase.services.size();
			for (int i=0; i<sizeOfServices; i++){
				String serviceType = DataBase.services.get(i).typeOfService;
				//add back all things from bin
				for (int j = 0; j < DataBase.fixing.length; j++) {
					if (serviceType.equals(DataBase.fixing[j].getType())
							&& DataBase.fixing[j].getNeedsDetails().equals(DataBase.details[j].getType())) {

						DataBase.details[j].setCount(1);//увеличиваем кол-во деталей
					}
				}

				DataBase.services.remove(0);//ранее в скобках было i - думаю, это ошибка с выводом корзины, когда оставался еще один элемент в корзине
			}
			MoneyAndService.moneyCost = 0;

			WorkWithScenes.closeWindow(deleteAndLeaveButton, "Exit");
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

		});
	}

}
