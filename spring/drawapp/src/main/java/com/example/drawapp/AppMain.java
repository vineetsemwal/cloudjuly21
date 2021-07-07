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
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
 //        Canvas canvas=context.getBean(Canvas.class);
         Canvas canvas=  context.getBean("canvas", Canvas.class);
         Shape shape=canvas.getShape();
         System.out.println("is shape in can null "+ shape==null);


    }

}
