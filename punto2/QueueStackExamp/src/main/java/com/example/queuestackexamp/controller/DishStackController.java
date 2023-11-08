package com.example.queuestackexamp.controller;

import com.example.queuestackexamp.stack.Dish;
import com.example.queuestackexamp.stack.DishStack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class DishStackController {
    @FXML
    public VBox vbDish;
    @FXML
    public Label lbDish;
    private LandPageController landPageController;
    private Stage stage;
    private DishStack dishStack;

    public void init(Stage stage, LandPageController landPageController) {
        this.stage = stage;
        this.landPageController = landPageController;
        dishStack = new DishStack();
    }

    @FXML
    void openMenu(ActionEvent actionEvent){
        landPageController.show();
        stage.close();
    }

    @FXML
    public void addDish(ActionEvent actionEvent) {
        dishStack.push(new Dish());
        showDishes();
    }

    @FXML
    public void washDish(ActionEvent actionEvent) {
        dishStack.pop();
        showDishes();
    }

    @FXML
    public void resetStack(ActionEvent actionEvent) {
        dishStack.destroy();
        showDishes();
    }
    private void showDishes(){
        String dishes = dishStack.toString();
        lbDish.setText(dishes);
    }

    //TODO: Implement this method
    /*
    private void showDishes(){
        vbDish.getChildren().clear();

        Dish current = dishStack.getHead();
        while(current != null){
            ImageView dishIV = current.getImageView();
            dishIV.setFitHeight(50);
            dishIV.setFitWidth(100);

            vbDish.getChildren().add(dishIV);
            current = current.getNext();
        }

    }*/
}