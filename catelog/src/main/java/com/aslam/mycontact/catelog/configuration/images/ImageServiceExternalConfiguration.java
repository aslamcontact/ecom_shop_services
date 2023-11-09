package com.aslam.mycontact.catelog.configuration.images;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ImageServiceExternalConfiguration {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()  {
        return new RestTemplate();
    }
}
