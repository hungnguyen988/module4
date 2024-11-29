package com.example.demojwt.controller;

import com.example.demojwt.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {
    @Autowired
    private JwtUtils jwtUtils;


//    @GetMapping
//    public ResponseEntity<String> getProtectedResource(@RequestHeader("Authorization") String authHeader) {
//        String token = authHeader.substring(7); // Bỏ "Bearer "
//        if (jwtUtils.validateToken(token)) {
//            String username = jwtUtils.extractUsername(token);
//            return ResponseEntity.ok("Hello, " + username + "! This is a protected resource.");
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token.");
//    }
}
