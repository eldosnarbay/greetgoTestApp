package kz.eldos.eSchoolGreetgo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("")
public class AuthController {
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        System.err.println("good " + principal);
        return principal;
    }

}
