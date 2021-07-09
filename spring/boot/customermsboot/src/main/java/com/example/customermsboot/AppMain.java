package com.example.customermsboot;

import com.example.customermsboot.ui.AppUi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootApplication annotation is equivalent to below three annotations
 * @Configuration
 * @ComponentScan
 * @AutoConfigure
 */
@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppMain.class, args);
        AppUi appUi = context.getBean(AppUi.class);
        appUi.runUi();
    }


}
