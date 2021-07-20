package com.example.EmployeeApplication.controller;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.service.EmployeeServiceDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EmployeeController {



    @Autowired
    private EmployeeServiceDao employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)throws UserAlreadyExistException, FieldCanNotBeNullException {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/employee")
    public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody Employee employee)throws UserNotFoundException{
        return new ResponseEntity<>(employeeService.updateEmployee(id,employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id)throws UserNotFoundException {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/count")
    public int findCountOfEmployee(){
        return employeeService.findCountOfEmployee();
    }

}
