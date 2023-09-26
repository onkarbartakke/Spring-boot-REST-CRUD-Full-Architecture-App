package com.onkar.springboot.crudrestdemo.service;

import com.onkar.springboot.crudrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
