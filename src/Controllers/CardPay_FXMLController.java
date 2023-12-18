package Controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.ShopTerminal_Driver;
import Back.DataBase;
import Back.MoneyAndService;
import Back.WorkWithScenes;

public class CardPay_FXMLController {

    @FXML
    private Button backToBinButton;

    @FXML
    private PasswordField cardCode_field;

    @FXML
    private Text cardInfoText;

    @FXML
    private TextField cardNumber_field;

    @FXML
    private Button goBackButton;

    @FXML
    private Text notCorrectText;

    @FXML
    private Button payButton;
    
    @FXML
    private Text userLoginText;

	@FXML
	void initialize() {
		userLoginText.setText(userLoginText.getText() + ShopTerminal_Driver.currentClient.getUsername());
		
    	backToBinButton.setOnAction(event -> {
            WorkWithScenes.closeWindow(backToBinButton, "backToBin");
            
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
    	
    	goBackButton.setOnAction(event -> {
            WorkWithScenes.closeWindow(goBackButton, "goBackButton");
            
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
    	
    	payButton.setOnAction(event -> {
    		//read data from window
    		String cardNumberText = cardNumber_field.getText().trim();
			String cardCodeText = cardCode_field.getText().trim();
			
			//проверка данных о карте на ввод допустимых значений
			Matcher cardNumberMatcher = maching("\\d{6}", cardNumberText);
			Matcher cardCodeMatcher = maching("\\d{4}", cardCodeText);
			
			if (!(cardNumberMatcher.matches() && cardCodeMatcher.matches())) {
				if(!cardNumberMatcher.matches()) {
					notCorrectText.setText("Неверно введен номер карты! Номер должен состоять из 6 цифр.");
					System.out.println("Неверно введен номер карты! Номер должен состоять из 6 цифр.");
				}
				else if (!cardCodeMatcher.matches()) {
					notCorrectText.setText("Неверно введен пароль от карты! Пароль должен состоять из 4 цифр.");
					System.out.println("Неверно введен пароль от карты! Пароль должен состоять из 4 цифр.");
				}
			}
			else {
				if (!(Integer.parseInt(cardNumberText) == ShopTerminal_Driver.currentClient.getCardNumber() &&
						Integer.parseInt(cardCodeText) == ShopTerminal_Driver.currentClient.getСardCode())) {
					notCorrectText.setText("Неверно введен номер или пароль карты клиенты!");
					System.out.println("Неверно введен номер или пароль карты клиенты!");
				}
				else {
					if (MoneyAndService.moneyCost > ShopTerminal_Driver.currentClient.getMoneyOnCard()) {
						notCorrectText.setText("Недостаточно вредств на карте для оплаты! На карте " + 
								ShopTerminal_Driver.currentClient.getMoneyOnCard() + " рублей.");
						System.out.println("Недостаточно вредств на карте для оплаты! На карте " + 
								ShopTerminal_Driver.currentClient.getMoneyOnCard() + " рублей.");
					}
					else {
						//spent money from client card
						ShopTerminal_Driver.currentClient.setLessMoneyOnCerd(MoneyAndService.moneyCost);
						
						//cell products
			            int sizeOfServices = DataBase.services.size();//ранее была ошибка - изменялся размер сервиса при удалениии элементов
			            for (int i=0; i<sizeOfServices; i++){
			                DataBase.services.remove(0);//ранее в скобках было i - думаю, это ошибка с выводом корзины, когда оставался еще один элемент в корзине
			            }
			            MoneyAndService.moneyCost = 0;
			    		
			    		//go to the next window
			            WorkWithScenes.closeWindow(payButton, "payButton");
			            
			            FXMLLoader loader = new FXMLLoader();
			            loader.setLocation(getClass().getResource("/FXML/Bought_FXML.fxml"));

			            try {
			                loader.load();
			            } catch (IOException ex) {
			                Logger.getLogger(Bought_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
			            }
			            
			            Parent root = loader.getRoot();
			            Stage stage = new Stage();
			            stage.setResizable(false);
			            stage.setScene(new Scene(root, 790, 700));
			            stage.show();
					}
				}
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

