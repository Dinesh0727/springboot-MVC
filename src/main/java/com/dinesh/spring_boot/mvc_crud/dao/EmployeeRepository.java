package com.dinesh.spring_boot.mvc_crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.spring_boot.mvc_crud.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
