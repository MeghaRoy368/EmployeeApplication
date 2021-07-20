package com.example.EmployeeApplication.repository;

import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {
    @Query("select employee from Department d where d.deptId = ?1")
    List<Employee> getEmployeeByDepartment(int id);
}
