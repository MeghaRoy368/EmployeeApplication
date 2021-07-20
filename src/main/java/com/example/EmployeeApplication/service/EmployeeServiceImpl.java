package com.example.EmployeeApplication.service;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceDao {
    @Autowired
    private EmployeeRepository employeeRepository;

List<Employee> list1;
    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee)throws UserAlreadyExistException, FieldCanNotBeNullException {
        if (employee.getEmpName()==null||employee.getEmpName()==""||employee.getEmpEmail()==null||employee.getEmpEmail()==""||employee.getEmpId()<=0||employee.getDepartment()==null){
            throw new FieldCanNotBeNullException();
        }
        else if (employeeRepository.existsById(employee.getEmpId())){
            throw new UserAlreadyExistException();
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id,Employee employee)throws UserNotFoundException {
        if (!employeeRepository.existsById(employee.getEmpId())){
            throw new UserNotFoundException();
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id)throws UserNotFoundException {
        if (!employeeRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public int findCountOfEmployee() {
        list1=(List<Employee>) employeeRepository.findAll();
        return list1.size();
    }
}
