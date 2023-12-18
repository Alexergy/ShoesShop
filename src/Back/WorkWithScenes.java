package Back;

//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import javafxmlapplication.Controllers.Enter_FXMLController;

public class WorkWithScenes {
    public static void closeWindow(Button btn, String text){
        System.out.println(text);//выводим на экран информацию, какую кнопку нажали - для отслеживания действий
        //закрываем окно
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
    
}
