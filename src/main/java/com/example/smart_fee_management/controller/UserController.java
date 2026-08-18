package com.example.smart_fee_management.controller;

import com.example.smart_fee_management.model.User;
import com.example.smart_fee_management.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(
            @RequestBody User user,
            HttpServletRequest request,
            HttpServletResponse response) {

        User loggedInUser = userService.login(
                user.getUsername(),
                user.getPassword());

        if (loggedInUser == null) {
            return ResponseEntity.status(401).build();
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                loggedInUser.getUsername(),
                null,
                java.util.Collections.emptyList());

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        HttpSessionSecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

        securityContextRepository.saveContext(context, request, response);

        return ResponseEntity.ok(loggedInUser);
    }
}
