package com.dinesh.spring_boot.mvc_crud.service;

import java.util.List;

import com.dinesh.spring_boot.mvc_crud.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
