package com.aslam.mycontact.catelog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;

@SpringBootApplication(exclude={MongoAutoConfiguration.class, MongoReactiveAutoConfiguration.class})
public class CatelogAppication {
    public static  void  main(String[] args) {
        SpringApplication.run(CatelogAppication.class,args);
    }
}
