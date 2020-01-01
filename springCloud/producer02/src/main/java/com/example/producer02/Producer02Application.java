package com.example.producer02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Producer02Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer02Application.class, args);
    }

}
