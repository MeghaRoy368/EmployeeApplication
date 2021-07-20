package com.example.EmployeeApplication.service;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceDao {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    Employee saveEmployee(Employee employee)throws UserAlreadyExistException, FieldCanNotBeNullException;

    Employee updateEmployee(int id,Employee employee)throws UserNotFoundException;

    void deleteEmployee(int id) throws UserNotFoundException;

    int findCountOfEmployee();
}
