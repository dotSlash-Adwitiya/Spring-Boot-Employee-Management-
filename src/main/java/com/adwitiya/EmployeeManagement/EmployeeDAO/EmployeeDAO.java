package com.adwitiya.EmployeeManagement.EmployeeDAO;

import com.adwitiya.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    // You can add custom query methods here if needed

    // Added custom Query for Sorting By first name

    // Added custom Query for Sorting By last name
    public List<Employee> findAllByOrderByLastNameAsc();
    public List<Employee> findAllByOrderBySalaryDesc();

    // Added custom Query for Sorting By salary

    // Added custom Query for finding 2nd highest salary
}
