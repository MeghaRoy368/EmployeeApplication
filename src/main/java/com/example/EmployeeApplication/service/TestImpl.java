package com.example.EmployeeApplication.service;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Qualifier("secondService")
//@Service
@AllArgsConstructor
public class TestImpl implements DepartmentServiceDao{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAllDepartment() {
        return null;
    }

    @Override
    public Optional<Department> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getEmployeeByDepartment(int id) {
        return null;
    }

    @Override
    public Department saveDepartment(Department department) throws UserAlreadyExistException, FieldCanNotBeNullException {
        return null;
    }

    @Override
    public Department updateDepartment(int id, Department department) throws UserNotFoundException {
        return null;
    }

    @Override
    public void deleteDepartment(int id) throws UserNotFoundException {

    }

    @Override
    public int findCount() {
        return 0;
    }

    @Override
    public int findCountEmployeeByDepartment(int id) {
        return 0;
    }
}
