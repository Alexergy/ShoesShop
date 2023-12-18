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
import Back.DataBase;
import Back.MoneyAndService;
import Back.WorkWithScenes;

public class ChooseToFix_FXMLController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text notHaveEnough;

	@FXML
	private Button fixHeelButton;//кнопка для выбора починки каблука

	@FXML
	private Button goBackButton;//кнопка перехода на предыдущее окно

	@FXML
	private Button fixBaseButton;//кнопка для выбора починки подошвы

	@FXML
	private Button varnishButton;//кнопка для выбора лакировки

	@FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		

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

		fixBaseButton.setOnAction(event ->  {
			getService(fixBaseButton);
		});

		fixHeelButton.setOnAction(event ->  {
			getService(fixHeelButton);
		});

		varnishButton.setOnAction(event ->  {
			getService(varnishButton);
		});

	}

	private void getService(Button btn) {
		String fixing = btn.getText();
		MoneyAndService service = new MoneyAndService();

		for (int i = 0; i < DataBase.fixing.length; i++) {
			if (fixing.equals(DataBase.fixing[i].getType())
					&& DataBase.fixing[i].getNeedsDetails().equals(DataBase.details[i].getType())) {
				if (DataBase.details[i].getCount() > 0) {
					service.priceOfService = DataBase.fixing[i].getPrice();//записываем цену услуги
					service.typeOfService = fixing;//записываем название услуги
					MoneyAndService.moneyCost += DataBase.fixing[i].getPrice();//увеличиваем общую сумму всех услуг
					DataBase.details[i].setCount(-1);//уменьшаем кол-во деталей

					DataBase.services.add(service);

					//переходим в окно-уведомление
					WorkWithScenes.closeWindow(btn, "Back");

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/FXML/Grosseries_FXML.fxml"));

					try {
						loader.load();
					} catch (IOException ex) {
						Logger.getLogger(Grosseries_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
					}

					Parent root = loader.getRoot();
					Stage stage = new Stage();
					stage.setResizable(false);
					stage.setScene(new Scene(root, 790, 700));
					stage.show();
				} else {
					System.out.println(fixing);
					btn.disableProperty();
					System.out.println("Деталей для услуги нет");
					notHaveEnough.setText("Деталей для услуги нет");
				}
			}
		}

	}
}