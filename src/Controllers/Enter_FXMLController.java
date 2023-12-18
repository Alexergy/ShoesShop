package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.ShopTerminal_Driver;
import Back.DataBase;
import Back.WorkWithScenes;

public class Enter_FXMLController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button loginSingUpButton;//кнопка для регистрации

	@FXML
	private TextField login_field;//поле для ввода логина (имени пользователя)

	@FXML
	private PasswordField passward_field;//поле для ввода пароля

	@FXML
	private Button singInButton;//кнопка входа - ввода данных

	@FXML
	private Button goBackButton;//кнопка для выхода на предыдущее окно

	@FXML
	private Text notCorrectText;

	@FXML
	void initialize() {
		loginSingUpButton.setOnAction(event -> {            
			WorkWithScenes.closeWindow(loginSingUpButton, "SingUp");

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXML/SingUp_FXML.fxml"));

			try {
				loader.load();
			} catch (IOException ex) {
				Logger.getLogger(SingUp_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root, 790, 700));
			stage.show();
		});

		singInButton.setOnAction(event -> {
			System.out.println("Enter");
			String loginText = login_field.getText().trim();
			String paswardText = passward_field.getText().trim();
			boolean checkIfCorrect = false;

			int i;
			for (i=0; i<DataBase.clients.size(); i++){
				if (loginText.equals(DataBase.clients.get(i).getUsername())){
					if (paswardText.equals(String.valueOf(DataBase.clients.get(i).getCode()))){
						checkIfCorrect = true;
						break;
					}
				}
			}

			if (!checkIfCorrect){
				notCorrectText.setText("Неверно введен логин или пароль!");
				System.out.println("Неверно введен логин или пароль!");
			}
			else{
				//remember info about currentClient
				ShopTerminal_Driver.currentClient = DataBase.clients.get(i);

				WorkWithScenes.closeWindow(singInButton, "SingIn");

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
			}
		});

		goBackButton.setOnAction(event ->{
			WorkWithScenes.closeWindow(goBackButton, "Back");

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/FXML/HelloWindow_FXML.fxml"));

			try {
				loader.load();
			} catch (IOException ex) {
				Logger.getLogger(HelloWindow_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root, 790, 700));
			stage.show();
		});

	}

}
