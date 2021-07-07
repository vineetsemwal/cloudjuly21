package com.example.drawappwithxml;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;


public class Square  implements Shape{

    private double side;

    public Square(){

    }

    public Square(double side){
        this.side=side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area(){
        return side*side;
    }

}
