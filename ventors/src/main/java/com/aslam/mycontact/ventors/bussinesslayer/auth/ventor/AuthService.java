package com.aslam.mycontact.ventors.bussinesslayer.auth.ventor;

import com.aslam.mycontact.ventors.api.auth.ventor.AuthResponse;
import com.aslam.mycontact.ventors.api.auth.ventor.RegisterVentorRequest;
import com.aslam.mycontact.ventors.daolayer.Ventor;
import com.aslam.mycontact.ventors.daolayer.VentorRepository;
import com.aslam.mycontact.ventors.daolayer.VentorRoles;
import com.aslam.mycontact.ventors.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final VentorRepository ventorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService(VentorRepository ventorRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager) {
        this.ventorRepository = ventorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse registerVentor(RegisterVentorRequest request) {

        var ventor=new Ventor();
        ventor.setVentorName(request.getVentorName());
       // ventor.setPassword(passwordEncoder.encode(request.));
        //user.setPassword(passwordEncoder.encode(request.getPassword()));
        ventor.setRoles(VentorRoles.VENTOER);
        ventorRepository.save(ventor);
        var jwtToken=jwtService.generateToken(ventor);

        return new AuthResponse(jwtToken);
    }
}
