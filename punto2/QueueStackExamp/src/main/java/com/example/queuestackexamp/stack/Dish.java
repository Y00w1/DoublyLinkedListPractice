package com.example.queuestackexamp.stack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dish {
    String name;
    boolean isClean;
    //ImageView imageView;
    Dish next;

    public Dish() {
        this.name = "Plato";
        this.isClean = false;
        //Image dish = new Image(getClass().getResourceAsStream("src/main/java/com/example/queuestackexamp/img/dirtyDish.png"));
        //this.imageView.setImage(dish);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    /*
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }*/

    public Dish getNext() {
        return next;
    }

    public void setNext(Dish next) {
        this.next = next;
    }
}
