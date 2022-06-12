package com.example.parkinglot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyParkingLotApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyParkingLotApplication.class, args);
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.neha.parkinglot")).build();
//    }

}
