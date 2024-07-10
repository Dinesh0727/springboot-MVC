package com.dinesh.spring_boot.spring_security.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        System.err.println("Hello Dinesh!!!");
        return "home";
    }

    @GetMapping("/leaders")
    public String showManagerPage() {
        return "manager";
    }

    @GetMapping("/systems")
    public String showSystemsPage() {
        return "admin";
    }
    
    
}
