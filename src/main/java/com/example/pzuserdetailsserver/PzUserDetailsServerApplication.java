package com.example.pzuserdetailsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients

public class PzUserDetailsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PzUserDetailsServerApplication.class, args);
    }

}
