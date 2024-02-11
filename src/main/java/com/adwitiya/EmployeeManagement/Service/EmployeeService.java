package com.adwitiya.EmployeeManagement.Service;

import com.adwitiya.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);

    List<Employee> getAllEmployeesSortedByLastName();

    List<Employee> getAllEmployeesSortedBySalary();
}