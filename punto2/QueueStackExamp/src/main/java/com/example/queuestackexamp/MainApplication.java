package com.example.queuestackexamp;

import com.example.queuestackexamp.controller.DishStackController;
import com.example.queuestackexamp.controller.LandPageController;
import com.example.queuestackexamp.controller.ParkingQueueController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("land-page.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);

        // Disable window resizing
        stage.setResizable(false);

        stage.setTitle("MENU");
        stage.setScene(scene);

        //Initialize the controller
        LandPageController landingController = fxmlLoader.getController();
        //Set the stage for the controller
        landingController.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}