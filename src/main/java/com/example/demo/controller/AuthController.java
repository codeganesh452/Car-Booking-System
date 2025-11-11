package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtill;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtill jwtUtill;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, JwtUtill jwtUtill, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtill = jwtUtill;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        String role = req.getRole() == null ? "ROLE_USER" : req.getRole();
        User u = userService.register(req.getUsername(), req.getPassword(), role);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
          
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );

            String token = jwtUtill.generateToken(req.getUsername());

            User user = userService.findByUsername(req.getUsername()).orElseThrow();
            return ResponseEntity.ok(new JwtResponse(token, user.getUsername(), user.getRole()));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }
}

