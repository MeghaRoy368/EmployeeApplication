package com.example.EmployeeApplication.controller;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.service.DepartmentServiceDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DepartmentController {


    private DepartmentServiceDao departmentService;
    @Autowired
    public DepartmentController(@Qualifier("firstService") DepartmentServiceDao departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> findAll(){
        return departmentService.findAllDepartment();
    }

    @GetMapping("/department/{id}")
    public Optional<Department> findById(@PathVariable int id){
        return departmentService.findById(id);
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getEmployeeByDepartment(@PathVariable int id){
        return departmentService.getEmployeeByDepartment(id);
    }

    @PostMapping("/department")
    public ResponseEntity<?> saveDepartment(@RequestBody Department department) throws UserAlreadyExistException, FieldCanNotBeNullException {
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);

    }

    @PutMapping("/{id}/department")
    public ResponseEntity<?> updateDepartment(@PathVariable int id, @RequestBody  Department department)throws UserNotFoundException{
        return new ResponseEntity<>(departmentService.updateDepartment(id,department), HttpStatus.OK);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable int id)throws UserNotFoundException{
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/departments/count")
    public int findCount(){
        return departmentService.findCount();
    }

    @GetMapping("/count/employee/{id}")
    public int findCountEmployeeByDepartment(@PathVariable int id){
    return departmentService.findCountEmployeeByDepartment(id);
    }


//    @GetMapping("/desc")
//    public List<Department> descendingOrder(){
//        return departmentService.descendingOrder();
//    }

}
