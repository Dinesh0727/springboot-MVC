package com.dinesh.spring_mvc.spring_mvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class FormController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @PostMapping("/processFormFinal")
    public String processFormFinal(@RequestParam("studentName") String name, Model model) {
        String upperCase = "Yo1!! " + name.toUpperCase();
        model.addAttribute("result", upperCase);
        return "helloworld";
    }
    
    
}
