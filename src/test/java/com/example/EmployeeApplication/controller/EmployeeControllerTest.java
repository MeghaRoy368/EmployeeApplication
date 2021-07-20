package com.example.EmployeeApplication.controller;

import com.example.EmployeeApplication.model.Employee;
import com.example.EmployeeApplication.service.EmployeeServiceDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    private MockMvc mockMvc;
    @Mock
    EmployeeServiceDao employeeService;
    @InjectMocks
    private EmployeeController employeeController;

    private Employee employee;
    private List<Employee> employeeList;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        employee=new Employee();
        employee.setEmpId(1);
        employee.setEmpName("megha");
        employee.setAge(22);
        employee.setEmpEmail("megha@gmail.com");
       // employee.setDepartment(1,"cse","megha");
        employeeList = new ArrayList<>();
        employeeList.add(employee);
    }

    @AfterEach
    public void tearDown() {
        employee = null;
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() throws Exception {
        when(employeeService.saveEmployee(any())).thenReturn(employee);
        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
        verify(employeeService).saveEmployee(any());
    }

    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() throws Exception {
        when(employeeService.findAll()).thenReturn(employeeList);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employee)))
                .andDo(MockMvcResultHandlers.print());
        verify(employeeService).findAll();
        verify(employeeService, times(1)).findAll();

    }

//    @Test
//    void givenBlogIdThenShouldReturnRespectiveBlog() throws Exception {
//        when(employeeService.findById(employee.getEmpId())).thenReturn(java.util.Optional.ofNullable(employee));
//        mockMvc.perform(get("/employee/1"))
//                .andExpect(MockMvcResultMatchers.status()
//                        .isFound())
//                .andDo(MockMvcResultHandlers.print());
//
//    }

//    @Test
//    public void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() throws Exception {
//        when(employeeService.deleteEmployee(employee.getEmpId()));
//        mockMvc.perform(delete("/api/v1/blog/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(employee)))
//                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//    }

//    @Test
//    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws Exception {
//        when(employeeService.updateEmployee(employee.getEmpId(),employee)).thenReturn(employee);
//        mockMvc.perform(put("/1/employee").contentType(MediaType.APPLICATION_JSON).content(asJsonString(employee)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}