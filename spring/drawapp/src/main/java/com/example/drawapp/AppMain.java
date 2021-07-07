package com.example.drawapp;

public class AppMain {

    public static void main(String args[]){
        Shape shape = new Circle(10);
        Canvas canvas = new Canvas();
        canvas.setShape(shape);
        canvas.drawArea();
    }
}
