package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:app.properties")
@ComponentScan("com.example.lab3")
@Configuration
public class JavaConfig {
   @Autowired
    private ApplicationContext applicationContext ;

  //  @Autowired
   // private Environment environment;

    @Bean
    public SBU sbu() {
        SBU sbu = new SBU();
        List<Employee> employees = employees();
        sbu.setEmployees(employees);
        return sbu;
    }

    public List<Employee> employees() {
        List<Employee> list = new ArrayList<Employee>();
        Employee emp1 = employee("emp1");
        list.add(emp1);
        Employee emp2 = employee("emp2");
        list.add(emp2);
        Employee emp3 = employee("emp3");
        list.add(emp3);
        return list;
    }

    Employee employee(String prefix){
        Environment environment = applicationContext.getEnvironment();
       int id= environment.getProperty(prefix+".id", Integer.class);
       String name=environment.getProperty(prefix+".name");
       double salary=environment.getProperty(prefix+".salary",Double.class);
       Employee employee=new Employee(id,name,salary);
       return employee;
    }


}
