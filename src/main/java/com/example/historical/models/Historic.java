package com.example.historical.models;

public class Historic {
    Historic prev;
    String operation;
    Historic next;

    public Historic(String operation) {
        this.operation = operation;
    }
}
