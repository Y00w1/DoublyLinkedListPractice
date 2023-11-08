package com.example.queuestackexamp.queue;

public class CarQueue {
    Car head;
    Car tail;

    //Add a car to the queue
    public void enqueue(Car car) {
        if (head == null) {
            head = car;
            tail = car;
        } else {
            tail.nextCar = car;
            tail = car;
        }
    }

    //Remove a car from the queue
    public Car dequeue() {
        if (head == null) {
            return null;
        } else {
            Car car = head;
            head = head.nextCar;
            if (head == null) {
                tail = null;
            }
            return car;
        }
    }

    //Clear the queue
    public void destroy() {
        head = null;
        tail = null;
    }

    //Return a String representation of the queue separated by spaces printi
    public String toString() {
        StringBuilder result = new StringBuilder();
        Car current = head;
        while (current != null) {
            result.insert(0, current.numberPlate + " ");
            current = current.nextCar;
        }
        return result.toString();
    }
}
