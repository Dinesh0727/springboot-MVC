package com.dinesh.spring_mvc.spring_mvc_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dinesh.spring_mvc.spring_mvc_demo.model.Student;




@Controller
public class StudentController {

    @Value("${countries}")
    public List<String> countries;

    @Value("${languages}")
    public List<String> languages;

    @Value("${operatingSystems}")
    public List<String> operatingSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }
    
    @PostMapping("/processStudentForm")
    public String studentConfirmation(@ModelAttribute("student") Student theStudent) {
        
        System.out.println("Student : "+ theStudent.getFirstName() + " " + theStudent.getLastName() + 
        theStudent.getCountry());
        
        return "student-confirmation";
    }
    
}
