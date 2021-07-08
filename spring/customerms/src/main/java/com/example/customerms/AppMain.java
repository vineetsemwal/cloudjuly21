package com.example.customerms;

import com.example.customerms.entities.Customer;
import com.example.customerms.service.ICustomerService;
import com.example.customerms.ui.AppUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {


    public static void main(String args[]) {
        AppMain app = new AppMain();
        app.start();
    }

    public void start() {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        AppUi ui=context.getBean(AppUi.class);
        ui.runUi();
    }


}
