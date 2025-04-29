package com.example.internship.Controller;

import com.example.internship.Dto.LoginDto;
import com.example.internship.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        // Вызов сервиса для аутентификации и получения токенов
        return authService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
