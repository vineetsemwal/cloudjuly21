package com.example.lab3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppMain {

    public static void main(String[]  args){
        AppMain app=new AppMain();
        app.start();
    }

    public  void start(){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        SBU sbu= context.getBean(SBU.class);
        System.out.println(sbu.getSbuCode()+" "+ sbu.getSbuName());
        List<Employee> employees=sbu.getEmployees();
        employees.stream().
                forEach(emp->System.out.println(emp.getEmployeeId()+" "+emp.getEmployeeName()));



    }

}
