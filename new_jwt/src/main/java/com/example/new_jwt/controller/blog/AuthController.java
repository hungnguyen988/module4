package com.example.new_jwt.controller.blog;

import com.example.new_jwt.config.JwtUtils;
import com.example.new_jwt.model.AppUser;
import com.example.new_jwt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AppUserRepository appUserRepository;
    // sử dụng jwt
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AppUser user) {
        AppUser userDb = appUserRepository.findByUserName(user.getUserName());

        if (userDb.getUserName() != null && userDb.getEncrytedPassword().equals(user.getEncrytedPassword())) {
            String token = jwtUtils.generateToken(user.getUserName());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("token", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/profile")
    public ResponseEntity<String> getUserProfile() {
        // Lấy thông tin Authentication từ SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Lấy username từ Authentication (đã được bộ lọc JwtAuthFilter xử lý)
        String username = authentication.getName();

        return new ResponseEntity<>(username, HttpStatus.OK);
    }




}
