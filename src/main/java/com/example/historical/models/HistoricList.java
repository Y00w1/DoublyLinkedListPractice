package com.example.historical.models;

public class HistoricList {
    Historic head;
    Historic current;
    Historic tail;

    public HistoricList() {
        this.head = null;
        this.current = null;
        this.tail = null;
    }

    public void put(Historic historic){
        if(this.tail != null && this.current != this.tail){
            delete_from_current(historic);
            return;
        }
        if(this.tail == null){
            this.head = historic;
            this.current = historic;
            this.tail = historic;
            return;
        }
        this.tail.next = historic;
        historic.prev = this.tail;
        this.tail = historic;
        this.current = historic;
    }
    private void delete_from_current(Historic historic){
        Historic mobile;
        if (this.current == null && this.head != null){
            this.head = historic;
            this.tail = historic;
            this.current = historic;
        }else {
            mobile = this.current.next;
            historic.prev = this.current; // Set the tail to the current element

            while (mobile != null) {
                Historic delete = mobile; // Get the element to be deleted
                mobile = mobile.next; // Move to the next element
                delete = null; // Set the deleted element to null
            }
            this.current.next = historic;
            this.tail = historic;
            this.current = historic;
        }
    }
    public void undo(){
        if (this.current != null && this.current.prev != null){
            this.current = this.current.prev;
        }else if(this.current == this.head){
            this.current = null;
        }
    }
    public void redo(){
        if (this.current != null && this.current.next != null){
            this.current = this.current.next;
        }else if(this.head != null && this.current == null){
            this.current = this.head;
        }
    }

    public void save(){
        Historic mobile = this.head;
        Historic delete;
        while (mobile != null){
            delete = mobile;
            mobile = mobile.next;
            delete = null;
        }
        this.head = null;
        this.current = null;
        this.tail = null;
    }
    public void print(){
        Historic mobile = this.head;
        while (mobile != null){
            System.out.print(mobile.operation+" ");
            mobile = mobile.next;
        }
    }

    public String getAllHistoricText(){
        StringBuilder historicText = new StringBuilder();
        Historic mobile = this.head;
        while (mobile != null){
            historicText.append(mobile.operation).append(" ");
            mobile = mobile.next;
        }
        return historicText.toString();
    }

    public String getToCurrentHistoricText(){
        StringBuilder historicText = new StringBuilder();
        if (this.head != null && this.current == null){
            return "";
        }
        Historic mobile = this.head;
        while (mobile != this.current && mobile != null){
            historicText.append(mobile.operation).append(" ");
            mobile = mobile.next;
        }
        // Include the current historic operation if it exists
        if (mobile != null) {
            historicText.append(mobile.operation);
        }
        return historicText.toString();
    }
}
