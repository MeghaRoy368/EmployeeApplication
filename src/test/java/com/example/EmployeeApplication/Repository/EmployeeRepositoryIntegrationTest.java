package com.example.EmployeeApplication.Repository;

import com.example.EmployeeApplication.model.Department;
import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeRepositoryIntegrationTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;
    private Employee employee1;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("megha");
        employee.setAge(22);
        employee.setEmpEmail("megha@gmail.com");

    }
    @AfterEach
    public void tearDown() {
        employeeRepository.deleteAll();
        employee = null;
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        employeeRepository.save(employee);
        Employee fetchedEmployee = employeeRepository.findById(employee.getEmpId()).get();
        assertEquals(1, fetchedEmployee.getEmpId());
    }


    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
       // Employee employee = new Employee(1,"megha",22,"megha@gmail.com",);
       // Employee employee1 = new Employee(3,"meghaa",22,"megha@gmail.com",1);
        employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("megha");
        employee.setAge(22);
        employee.setEmpEmail("megha@gmail.com");
        employeeRepository.save(employee);
        employee1 = new Employee();
        employee1.setEmpId(2);
        employee1.setEmpName("megha");
        employee1.setAge(22);
        employee1.setEmpEmail("meghaa@gmail.com");
        employeeRepository.save(employee1);

        List<Employee> blogList = (List<Employee>) employeeRepository.findAll();
        assertEquals("megha", blogList.get(1).getEmpName());
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
       // Blog blog = new Blog(9, "Demo9", "Imneet", "SampleBlog");
       // Blog blog1 = blogRepository.save(blog);
        employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("megha");
        employee.setAge(22);
        employee.setEmpEmail("megha@gmail.com");
       Employee employee2= employeeRepository.save(employee);
        Optional<Employee> optional = employeeRepository.findById(employee2.getEmpId());
        assertEquals(employee2.getEmpId(), optional.get().getEmpId());
        assertEquals(employee2.getEmpName(), optional.get().getEmpName());
        assertEquals(employee2.getAge(), optional.get().getAge());
        assertEquals(employee2.getEmpEmail(), optional.get().getEmpEmail());
    }

    @Test
    public void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
       // Blog blog = new Blog(4, "Demo4", "Imneet", "Sample4");
        employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("megha");
        employee.setAge(22);
        employee.setEmpEmail("megha@gmail.com");
        employeeRepository.save(employee);
        employeeRepository.deleteById(employee.getEmpId());
        Optional optional = employeeRepository.findById(employee.getEmpId());
        assertEquals(Optional.empty(), optional);
    }

}
