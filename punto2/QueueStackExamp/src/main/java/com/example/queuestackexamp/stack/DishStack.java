package com.example.queuestackexamp.stack;

public class DishStack {
    Dish head;
    Dish mobile;

    public Dish getHead() {
        return head;
    }

    public Dish getMobile() {
        return mobile;
    }

    //initialize the stack
    public DishStack() {
        head = null;
        mobile = null;
    }
    //Insert a Dish to the stack
    public void push(Dish dish) {
        if (head == null) {
            head = dish;
            mobile = dish;
        } else {
            mobile.next = dish;
            mobile = dish;
        }
    }
    //delete a Dish from the stack
    public Dish pop() {
        if (head == null) {
            return null;
        } else {
            Dish dish = head;
            head = head.next;
            if (head == null) {
                mobile = null;
            }
            return dish;
        }
    }
    //destroy the stack
    public void destroy() {
        head = null;
        mobile = null;
    }

    //Return a String representation of the stack separated by new lines
    public String toString() {
        StringBuilder result = new StringBuilder();
        Dish current = head;
        while (current != null) {
            result.append(current.name).append("\n");
            current = current.next;
        }
        return result.toString();
    }
}
