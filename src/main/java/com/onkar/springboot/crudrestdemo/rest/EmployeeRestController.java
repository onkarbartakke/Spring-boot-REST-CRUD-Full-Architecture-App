package com.onkar.springboot.crudrestdemo.rest;

import com.onkar.springboot.crudrestdemo.dao.EmployeeDAO;
import com.onkar.springboot.crudrestdemo.entity.Employee;
import com.onkar.springboot.crudrestdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
         employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);

        if(emp == null){
            throw new RuntimeException("Employee ID not found : "+employeeId);
        }

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        emp.setId(0);
        Employee dbEmp = employeeService.save(emp);
        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        Employee dbEmp = employeeService.save(emp);
        return dbEmp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee emp = employeeService.findById(employeeId);

        if(emp == null){
            throw  new RuntimeException("Employee ID not found : " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Employee with Id "+employeeId+" Deleted..!!";
    }
}
