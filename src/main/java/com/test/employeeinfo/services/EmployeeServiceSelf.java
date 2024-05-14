package com.test.employeeinfo.services;

import com.test.employeeinfo.model.Department;
import com.test.employeeinfo.model.Employee;
import com.test.employeeinfo.repositories.DepartmentRepository;
import com.test.employeeinfo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceSelf implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Autowired
    public EmployeeServiceSelf(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;

    }
    @Override
    public Employee addEmployee(Employee employee) {
        Optional<Department> department = departmentRepository.findByDepartmentName(employee.getDepartment().getDepartmentName());
        if (department.isPresent()) employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee updateEmployee(Integer id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            if (employeeDetails.getFirstName() != null) existingEmployee.setFirstName(employeeDetails.getFirstName());
            if (employeeDetails.getLastName() != null) existingEmployee.setLastName(employeeDetails.getLastName());
            if (employeeDetails.getEmail() != null) existingEmployee.setEmail(employeeDetails.getEmail());
            if (employeeDetails.getPhone() != null) existingEmployee.setPhone(employeeDetails.getPhone());
            if (employeeDetails.getDepartment() != null) existingEmployee.setDepartment(employeeDetails.getDepartment());
            if (employeeDetails.getPosition() != null) existingEmployee.setPosition(employeeDetails.getPosition());
            if (employeeDetails.getDateOfJoining() != null) existingEmployee.setDateOfJoining(employeeDetails.getDateOfJoining());
            if (employeeDetails.getStatus() != null) existingEmployee.setStatus(employeeDetails.getStatus());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;// need to throw exception with message
        }
    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            return null; // need to throw exception with message
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
