package com.example.EmployeeApplication.controller;

import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.service.DepartmentServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class DepartmentController2 {
    private DepartmentServiceDao departmentService;
    @Autowired
    public DepartmentController2(@Qualifier("secondService") DepartmentServiceDao departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments2")
    public List<Department> findAll(){
        return departmentService.findAllDepartment();
    }
}
