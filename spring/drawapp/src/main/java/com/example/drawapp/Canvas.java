package com.example.drawapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component tells spring to keep bean class object in container
 */
@Component
public class Canvas {

    private Shape shape;

    /**
     * tells spring that this method can be used for setting dependency
     */
    @Autowired
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
