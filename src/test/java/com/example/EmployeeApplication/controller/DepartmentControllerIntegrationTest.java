package com.example.EmployeeApplication.controller;

import com.example.EmployeeApplication.exception.FieldCanNotBeNullException;
import com.example.EmployeeApplication.exception.UserAlreadyExistException;
import com.example.EmployeeApplication.exception.UserNotFoundException;
import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.service.DepartmentServiceDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//@Qualifier("firstService")
@SpringBootTest
public class DepartmentControllerIntegrationTest {

    @Autowired
    private DepartmentServiceDao departmentServiceDao;
    private Department department;
    private List<Department> departmentList;


    @BeforeEach
    public void setUp() {
        department=new Department();
        department.setDeptId(1);
        department.setDeptName("cse");
        department.setDeptHead("Megha");
      //  department.setEmployee(2,"megha",22,"megha@gmail.com");
        departmentList = new ArrayList<>();
        departmentList.add(department);
    }

    @AfterEach
    public void tearDown() {
        department = null;
    }

    @Test
    void givenDepartmentToSave() throws UserAlreadyExistException,FieldCanNotBeNullException {
        Department savedDepartment = departmentServiceDao.saveDepartment(department);
        assertNotNull(savedDepartment);
        assertEquals(department.getDeptId(), savedDepartment.getDeptId());
    }

    @Test
    public void toFindAllDepartments()  {
        List<Department> departmentList = departmentServiceDao.findAllDepartment();
        assertNotNull(departmentList);
    }

//    @Test
//    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws UserNotFoundException {
//        department.setDeptName("ece");
//        departmentServiceDao.updateDepartment(1,department);
//        assertEquals("ece", department.getDeptName());
//    }
}
