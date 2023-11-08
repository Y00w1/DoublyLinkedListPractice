package com.example.queuestackexamp.controller;

import com.example.queuestackexamp.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandPageController {
    private Stage stage;

    @FXML
    private void openDishStack(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dish-stack.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();

        stage.setScene(scene);

        // Disable window resizing
        stage.setResizable(false);

        stage.setTitle("Dish Stack");

        DishStackController dishController = fxmlLoader.getController();
        dishController.init(stage, this);

        stage.show();
        this.stage.close();
    }

    @FXML
    private void openParkingQueue(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("parking-queue.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();

        stage.setScene(scene);

        // Disable window resizing
        stage.setResizable(false);

        stage.setTitle("Parking Queue");

        ParkingQueueController parkingController = fxmlLoader.getController();
        parkingController.init(stage, this);

        stage.show();
        this.stage.close();
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public void show(){
        stage.show();
    }
}
