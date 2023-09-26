package com.onkar.springboot.crudrestdemo.dao;

import com.onkar.springboot.crudrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
