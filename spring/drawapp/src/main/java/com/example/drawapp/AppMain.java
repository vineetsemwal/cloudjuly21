package com.example.drawapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

    public static void main(String args[]) {
        AppMain aap = new AppMain();
        aap.start();
    }

    public void start() {
        //
        // ApplicationContext is the interface, AnnotationConfigApplicationContext is one concrete implementation of ApplicationContext
        // application context used for setting up container/BeanFactory
        // AnnotationConfigApplicationContext is the type of ApplicationContext
        //
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Canvas canvas=context.getBean(Canvas.class);
        Shape shape= canvas.getShape();
        boolean isCircle=shape instanceof Circle;
        System.out.println("is circle?"+ isCircle);
    }

}
