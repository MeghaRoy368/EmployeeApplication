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
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Qualifier("firstService")
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentServiceDao {
    @Autowired
    private DepartmentRepository departmentRepository;
    List<Department> list1;
    List<Employee> list2;

    @Override
    public List<Department> findAllDepartment() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployeeByDepartment(int id) {
        return departmentRepository.getEmployeeByDepartment(id);
    }

    @Override
    public Department saveDepartment(Department department)throws UserAlreadyExistException, FieldCanNotBeNullException {
        if (department.getDeptName() == null || department.getDeptName() == ""||department.getDeptHead() == null||department.getDeptHead()==""||department.getDeptId()<=0) {
            throw new FieldCanNotBeNullException();
        }
        else
        if (departmentRepository.existsById(department.getDeptId())){
            throw new UserAlreadyExistException();
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(int id,Department department)throws UserNotFoundException {
        if (!departmentRepository.existsById(department.getDeptId())){
            throw new UserNotFoundException();
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(int id)throws UserNotFoundException {
        if (!departmentRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public int findCount() {
        list1=(List<Department>) departmentRepository.findAll();
        return list1.size();
    }

    @Override
    public int findCountEmployeeByDepartment(int id) {
        list2=departmentRepository.getEmployeeByDepartment(id);
        return list2.size();
    }

//    @Override
//    public List<Department> findAllOrderByNameAsc() {
//
//        List<Department> department = departmentRepository.findAll(Sort.by("deptId").descending());
//    }

    //    @Override
//    public List<Department> descendingOrder() {
//        list1=(List<Department>) departmentRepository.findAll();
//       list2= Collections.sort(list1, Collections.reverseOrder());
//       return list2;
//            }
//
//    @Override
//    public List<?> ascendingOrder() {
//        list1=(List<Department>) departmentRepository.findAll();
//        list2=Collections.sort(list1);
//        return null;
//    }
}
