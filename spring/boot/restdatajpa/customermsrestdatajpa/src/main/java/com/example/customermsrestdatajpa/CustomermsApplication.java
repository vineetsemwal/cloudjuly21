package com.example.customermsrestdatajpa;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CustomermsApplication {

    private static final Logger Log = LoggerFactory.getLogger(CustomermsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CustomermsApplication.class, args);
        Log.debug("***i am debugged in main");
        Log.info("***i am info in main");
        Log.error("***i am error in main");
    }


    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.customermsrestdatajpa"))
                .build();
        return docket;
    }


    public ApiInfo apiInfo() {
        ApiInfo info = new ApiInfoBuilder()
                   .title("Customer Management Application")
                .description("rest api for customer management")
                .build();
        return info;

    }


}
