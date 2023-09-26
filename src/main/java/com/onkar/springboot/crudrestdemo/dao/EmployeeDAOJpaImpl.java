package com.onkar.springboot.crudrestdemo.dao;

import com.onkar.springboot.crudrestdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        //Create Query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee" , Employee.class);
        //Execute Query and get list
        List<Employee> allEmployees = theQuery.getResultList();
        //return list
        return allEmployees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmp = entityManager.find(Employee.class, theId);
        return theEmp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee emp = entityManager.find(Employee.class, theId);
        entityManager.remove(emp);
    }
}
