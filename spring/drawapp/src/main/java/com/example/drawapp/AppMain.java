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
        Canvas canvas1=context.getBean(Canvas.class);
       //  Canvas canvas=  context.getBean("canvas", Canvas.class);
         Shape shape1=canvas1.getShape();
         Shape shape2=context.getBean(Shape.class);
         boolean isShapeSame=shape1==shape2;
         System.out.println("is shapes same?"+isShapeSame);
         Canvas canvas2  = context.getBean(Canvas.class);
         boolean isCanvasSame=canvas1==canvas2;
         System.out.println("is canvas same? "+isCanvasSame);
         context.close();
    }

}
