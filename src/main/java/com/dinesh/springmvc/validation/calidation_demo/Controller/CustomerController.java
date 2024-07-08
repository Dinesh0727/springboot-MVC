package com.dinesh.springmvc.validation.calidation_demo.Controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dinesh.springmvc.validation.calidation_demo.model.Customer;

import jakarta.validation.Valid;



@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String customerForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/customer-confirmation")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer theCustomer, 
    BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        return "customer-confirmation";
    }
    
    
}
