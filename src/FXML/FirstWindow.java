/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Back.WorkWithScenes;
import Back.WorkWithScenes;
import main.ShopTerminal_Driver;
import main.ShopTerminal_Driver;

/**
 *
 * @author kiki-
 */
public class FirstWindow {
    public static void createFirstWindow(Stage stage) throws FileNotFoundException{
            Group root = new Group();
        Scene scene = new Scene(root, 800, 700, Color.SALMON);//задаем размер и цвет экрана
        stage.setScene(scene);
        stage.show();
        
        //записываем путь к начальной картинке
        FileInputStream fis1 = new FileInputStream("D:\\VIP\\ПОЛИКЕК\\Политех ДЗ\\5 сем\\Сис подход в разработке ПО (Нестеров)\\проект_5 сем\\firstPicture.png");
        
        //создаем картинку
        Image firstPicture = new Image(fis1);
        ImageView firstPictureView = new ImageView(firstPicture);
        //задаем размеры картинки
        firstPictureView.setPreserveRatio(true);
        firstPictureView.setFitWidth(400);
        //задаем начальные координаты картинки (по центру)
        firstPictureView.setLayoutX(200);
        firstPictureView.setLayoutY(40);
        
        //задаем кнопки для работы - купить, починить и покинуть магазин
        TilePane pane = new TilePane();
        Button buy = new Button ("Купить новую обувь");
//        buy.setStyle("-fx-background-color: green"); //смена цвета кнопки
        buy.setPrefWidth(200);//задаем желательную ширину кнопки
        Button fix = new Button ("Починить обувь");
        fix.setPrefWidth(200);//задаем желательную ширину кнопки
        Button exit = new Button ("Покинуть магазин");
        exit.setPrefWidth(200);//задаем желательную ширину кнопки
        pane.getChildren().addAll(buy,fix,exit);
        pane.setOrientation(Orientation.VERTICAL); //делаем кнопки по вертикали
        pane.setVgap(15);//задаем расстояние между кнопками (высоту)
        
        pane.setCenterShape(true);//располагаем кнопки повередине
        //задаем начальные координаты кнопок
        pane.setLayoutX(300);
        pane.setLayoutY(440);
        
        //добавляем картинку и кнопки на экран
        root.getChildren().addAll(firstPictureView, pane);
        firstPictureView.toBack();//отправляем картинку на задний план
        
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                WorkWithScenes.closeWindow(exit, "Exit");
            }
        });
        
        buy.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                WorkWithScenes.closeWindow(buy, "Buy");                
                
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Enter_FXML.fxml"));
                    
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(ShopTerminal_Driver.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
        });
        
        fix.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                WorkWithScenes.closeWindow(fix,"Fix");
                                
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Enter_FXML.fxml"));
                    
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(ShopTerminal_Driver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
