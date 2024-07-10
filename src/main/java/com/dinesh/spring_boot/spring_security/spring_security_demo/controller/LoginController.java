package com.dinesh.spring_boot.spring_security.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;






@Controller
public class LoginController {

    @GetMapping("/showLoginForm")
    public String showLoginForm() {
        return "fancy-login";
    }
    
    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "access-denied";
    }
    
}
