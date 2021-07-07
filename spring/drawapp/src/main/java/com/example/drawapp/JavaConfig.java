package com.example.drawapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.drawapp")
@Configuration
public class JavaConfig {


    @Bean
    public Square  square( ){
        return new Square(10);
    }

}
