package com.test.employeeinfo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Departments")
public class Department {
  // need to handle the case where department is deleted and employees are still there
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    @Column(name = "department_name", nullable = false)
    private String departmentName;

}

