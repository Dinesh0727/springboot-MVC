package com.dinesh.spring_boot.mvc_crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dinesh.spring_boot.mvc_crud.entity.Employee;
import com.dinesh.spring_boot.mvc_crud.service.EmployeeService;






@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        
        List<Employee> theEmployees = employeeService.findAll();

        
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        
        return "redirect:/employees/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model model) {
        Employee theEmployee = employeeService.findById(theId);
        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
    
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId, Model model) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
    
}
