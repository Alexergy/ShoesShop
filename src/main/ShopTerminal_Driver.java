/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Back.Client;
import Back.DataBase;

/**
 *
 * @author kiki-
 */
public class ShopTerminal_Driver extends Application {
	
    public static Client currentClient;
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/HelloWindow_FXML.fxml"));
        
        stage.setTitle("Магазин женской обуви");//подпись экрана
        stage.setResizable(false);
        stage.setScene(new Scene(root, 790, 700));
        stage.show();
        
        DataBase.clientsDataBase();
        DataBase.detailsDataBase();
        DataBase.shoesDataBase();
        DataBase.fixingDataBase();
       // FirstWindow.createFirstWindow(stage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    	
        launch(args);
    }
    
}
