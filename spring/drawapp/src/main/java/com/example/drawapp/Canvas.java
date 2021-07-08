package com.example.drawapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Component tells spring to keep bean class object in container
 */
@Component
public class Canvas {

    @Autowired
    private Shape shape;


    /**
     * tells spring that this method can be used for setting dependency
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    @Autowired
    public Canvas(Shape shape) {

    }

    public void drawArea() {
        double area = shape.area();
        System.out.println("drawing area is " + area);
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("inside afterinit of Canvas class " + shape.area());

    }

    @PreDestroy
    public void beforeDestroyed() {
        System.out.println("inside Canvas beforeDestroyed");
    }


}
