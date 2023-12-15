package com.aslam.mycontact.ventors.api.auth.ventor;


import com.aslam.mycontact.ventors.bussinesslayer.auth.ventor.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("auth/ventor")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerVentor(
            @RequestBody RegisterVentorRequest request)
    {

        System.out.println(request.getEmail());

        return ResponseEntity.ok(authService.registerVentor(request));

    }

}
