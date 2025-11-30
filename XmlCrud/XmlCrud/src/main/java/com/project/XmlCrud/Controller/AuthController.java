package com.project.XmlCrud.Controller;

import com.project.XmlCrud.Model.Account;
import com.project.XmlCrud.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Account account) {

        return authService.login(account.getEmail(), account.getPassword());
    }
}
