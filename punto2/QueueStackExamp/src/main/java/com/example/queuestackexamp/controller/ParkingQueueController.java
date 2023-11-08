package com.example.queuestackexamp.controller;

import com.example.queuestackexamp.queue.Car;
import com.example.queuestackexamp.queue.CarQueue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ParkingQueueController {
    @FXML
    public TextField tfPlate;
    @FXML
    public Label alert;
    @FXML
    public HBox hbCarQueue;
    @FXML
    public Label lbCarPlate;
    private LandPageController landPageController;
    private Stage stage;

    private CarQueue carQueue;

    public void init(Stage stage, LandPageController landPageController) {
        this.stage = stage;
        this.landPageController = landPageController;
        carQueue = new CarQueue();
    }

    @FXML
    public void openMenu(ActionEvent actionEvent) {
        landPageController.show();
        stage.close();
    }

    @FXML
    public void addCar(ActionEvent actionEvent) {
        String plate = tfPlate.getText();
        if (plate.isEmpty()) {
            alert.setText("Ingrese el numero de la placa");
            return;
        }
        carQueue.enqueue(new Car(tfPlate.getText()));
        tfPlate.setText("");
        showCars();
    }
    @FXML
    public void popCar(ActionEvent actionEvent) {
        carQueue.dequeue();
        showCars();
    }
    @FXML
    public void resetQueue(ActionEvent actionEvent) {
        carQueue.destroy();
        showCars();
    }

    private void showCars(){
        String cars = carQueue.toString();
        lbCarPlate.setText(cars);
    }

}
