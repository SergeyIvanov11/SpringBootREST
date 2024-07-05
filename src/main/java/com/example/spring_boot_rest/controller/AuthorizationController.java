package com.example.spring_boot_rest.controller;

import com.example.spring_boot_rest.exception.InvalidCredentials;
import com.example.spring_boot_rest.exception.UnauthorizedUser;
import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.service.Authorities;
import com.example.spring_boot_rest.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

