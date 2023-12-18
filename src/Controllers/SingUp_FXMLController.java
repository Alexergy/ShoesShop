package Controllers;

import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import Back.Client;
import Back.DataBase;
import Back.WorkWithScenes;

public class SingUp_FXMLController {


    @FXML
    private PasswordField cardCode_field;

    @FXML
    private Text cardInfoText;

    @FXML
    private TextField cardNumber_field;

    @FXML
    private Button goBackButton;//кнопка для выхода на предыдущее окно

    @FXML
    private TextField login_field;

    @FXML
    private TextField moneyOnCard_field;

    @FXML
    private TextField name_field;

    @FXML
    private Text notCorrectText;

    @FXML
    private PasswordField passward_field;

    @FXML
    private Text personalInfoText;

    @FXML
    private TextField sername_field;

    @FXML
    private Button singUpButton;

	@FXML
	void initialize() {
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

		singUpButton.setOnAction(event -> {
			String loginText = login_field.getText().trim();
			String paswardText = passward_field.getText().trim();
			String sernameText = sername_field.getText().trim();
			String nameText = name_field.getText().trim();
			
			String cardNumberText = cardNumber_field.getText().trim();
			String cardCodeText = cardCode_field.getText().trim();
			String moneyOnCardText = moneyOnCard_field.getText().trim();

			//проверка личной информации о человеке
			Matcher sernameMatcher = maching("^([А-Я]{1}[а-яё]{0,23}|[A-Z]{1}[a-z]{0,23})$", sernameText);
			Matcher nameMatcher = maching ("^([А-Я]{1}[а-яё]{0,23}|[A-Z]{1}[a-z]{0,23})$", nameText);
			Matcher loginMatcher = maching ("\\w{6,20}", loginText);
			Matcher passwardMatcher = maching("\\d{6}", paswardText);
			
			//проверка данных о карте
			Matcher cardNumberMatcher = maching("\\d{6}", cardNumberText);
			Matcher cardCodeMatcher = maching("\\d{4}", cardCodeText);
			Matcher moneyOnCardMatcher = maching("\\d{4,}.?\\d*", moneyOnCardText);

			if (!(loginMatcher.matches() && passwardMatcher.matches() && sernameMatcher.matches() && nameMatcher.matches()
					&& cardNumberMatcher.matches() && cardCodeMatcher.matches() && moneyOnCardMatcher.matches())){
				if (!nameMatcher.matches()) {
					notCorrectText.setText("Неверно введено имя пользователя! Введите от 1 до 23 буквенных символов, "
							+ "начиная с заглавной буквы.");
					System.out.println("Неверно введено имя пользователя! Введите от 1 до 23 буквенных символов, "
							+ "начиная с заглавной буквы.");
				}
				else if(!(sernameMatcher.matches())) {
					notCorrectText.setText("Неверно введена фамилия пользователя! Введите от 1 до 23 буквенных символов, "
							+ "начиная с заглавной буквы.");
					System.out.println("Неверно введена фамилия пользователя! Введите от 1 до 23 буквенных символов, "
							+ "начиная с заглавной буквы.");
				}
				else if (!loginMatcher.matches()) {
					notCorrectText.setText("Неверно введен логин! Введите от 6 до 20 латинских символов.");
					System.out.println("Неверно введен логин! Введите от 6 до 20 латинских символов.");
				}
				else if (!passwardMatcher.matches()) {
					notCorrectText.setText("Неверно введен пароль! Пароль должен состоять из 6 цифр.");
					System.out.println("Неверно введен пароль! Пароль должен состоять из 6 цифр.");
				}
				else if(!cardNumberMatcher.matches()) {
					notCorrectText.setText("Неверно введен номер карты! Номер должен состоять из 6 цифр.");
					System.out.println("Неверно введен номер карты! Номер должен состоять из 6 цифр.");
				}
				else if (!cardCodeMatcher.matches()) {
					notCorrectText.setText("Неверно введен пароль от карты! Пароль должен состоять из 4 цифр.");
					System.out.println("Неверно введен пароль от карты! Пароль должен состоять из 4 цифр.");
				}
				else if (!moneyOnCardMatcher.matches()) {
					notCorrectText.setText("Неверно введена денежная сумма! На карту можно внести не меньше 1000.0 рублей.");
					System.out.println("Неверно введена денежная сумма! На карту можно внести не меньше 1000.0 рублей.");
				}
				//System.out.println("лох");
			}
			else{
				//add new client to the DB
				Client client = new Client(sernameText, nameText, Integer.parseInt(paswardText), loginText, 
						Integer.parseInt(cardNumberText), Integer.parseInt(cardCodeText), Integer.parseInt(moneyOnCardText));
				DataBase.clients.add(client);
				
				//remember info about currentClient
				ShopTerminal_Driver.currentClient = client;

				WorkWithScenes.closeWindow(singUpButton, "SingUp");

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
	}
	
	Matcher maching (String checkRegul, String checkText) {
		//String checkPasswardRegul = "\\d{6}";
		Pattern pattern = Pattern.compile(checkRegul);
		Matcher matcher = pattern.matcher(checkText);
		
		return matcher;
	}

}
