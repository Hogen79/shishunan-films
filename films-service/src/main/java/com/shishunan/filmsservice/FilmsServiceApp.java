package com.shishunan.filmsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FilmsServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(FilmsServiceApp.class,args);
    }
}
