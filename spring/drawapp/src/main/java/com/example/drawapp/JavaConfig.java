package com.example.drawapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:app.properties")
@ComponentScan("com.example.drawapp")
@Configuration
public class JavaConfig {


}
