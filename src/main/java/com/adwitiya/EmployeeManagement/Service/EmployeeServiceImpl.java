package com.adwitiya.EmployeeManagement.Service;

import com.adwitiya.EmployeeManagement.EmployeeDAO.EmployeeDAO;
import com.adwitiya.EmployeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeDAO.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public  List<Employee> getAllEmployeesSortedByLastName(){
        return employeeDAO.findAllByOrderByLastNameAsc();
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalary() {
        return employeeDAO.findAllByOrderBySalaryDesc();
    }
}