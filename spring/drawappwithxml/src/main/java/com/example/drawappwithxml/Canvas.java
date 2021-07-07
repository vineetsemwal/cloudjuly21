package com.example.drawappwithxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Canvas {

    private Shape shape;

    public void setShape(Shape shape){
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public void drawArea(){
        double area= shape.area();
        System.out.println("drawing area is "+area);
    }



}
