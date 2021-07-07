package com.example.drawapp;

public class Canvas {

    private Shape shape;

    public void setShape(Shape shape){
        this.shape = shape;
    }

    public void drawArea(){
        double area= shape.area();
        System.out.println("drawing area is "+area);
    }

}
