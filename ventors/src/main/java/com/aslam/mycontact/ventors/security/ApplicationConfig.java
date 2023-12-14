package com.aslam.mycontact.ventors.security;

import com.aslam.mycontact.ventors.daolayer.VentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationConfig {
    @Autowired
    private VentorRepository  ventorRepository;

    @Bean
    public UserDetailsService userDetailsService()
    {
        return email -> ventorRepository.findByemail(email).orElseThrow(
                ()->   new UsernameNotFoundException("ventor not found")
        )
                ;
    }

}
