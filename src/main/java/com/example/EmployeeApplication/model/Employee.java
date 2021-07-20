package com.example.EmployeeApplication.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "empId")
public class Employee {
    @Id
    private int empId;
    private String empName;
    private int age;
    private String empEmail;
@ManyToOne
@JoinColumn(name = "deptId")
private Department department;

}
