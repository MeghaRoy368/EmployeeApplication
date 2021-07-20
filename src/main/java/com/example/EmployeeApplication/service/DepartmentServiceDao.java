package com.example.EmployeeApplication.service;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.model.Employee;
import java.util.List;
import java.util.Optional;

public interface DepartmentServiceDao {
    List<Department> findAllDepartment();

    Optional<Department> findById(int id);

    List<Employee> getEmployeeByDepartment(int id);

    Department saveDepartment(Department department)throws UserAlreadyExistException, FieldCanNotBeNullException;

    Department updateDepartment(int id,Department department) throws UserNotFoundException;

    void deleteDepartment(int id) throws UserNotFoundException;

    int findCount();

    int findCountEmployeeByDepartment(int id);
  //  public List<Department> findAllOrderByNameAsc();

//    List<Department> descendingOrder();
//
//    List<?> ascendingOrder();

}
