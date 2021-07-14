package com.example.customermsrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class CustomermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermsApplication.class, args);
	}

}
