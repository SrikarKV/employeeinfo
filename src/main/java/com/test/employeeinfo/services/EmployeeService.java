package com.test.employeeinfo.services;

import com.test.employeeinfo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public void deleteEmployee(Integer id);
    public Employee updateEmployee(Integer id,Employee employee);
    public Employee getEmployee(Integer id);
    public List<Employee> getAllEmployees();
}
