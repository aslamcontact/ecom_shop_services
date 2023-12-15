package com.aslam.mycontact.ventors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VentorApplication {
    public static void main(String[] args) {
        SpringApplication.run(VentorApplication.class, args);
    }

}
