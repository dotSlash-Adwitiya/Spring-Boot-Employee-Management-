package com.adwitiya.EmployeeManagement.Controller;

import com.adwitiya.EmployeeManagement.Service.EmployeeService;
import com.adwitiya.EmployeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("list-employees");
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        return modelAndView;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "add-employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.saveEmployee(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/ByLastName")
    public String sortByLastName(Model theModel){
        List<Employee> employeeList = employeeService.getAllEmployeesSortedByLastName();
        theModel.addAttribute("employees", employeeList);
        return "ByLastName";
    }

    @GetMapping("/BySalaryDesc")
    public String sortBySalary(Model theModel){
        List<Employee> employeeList = employeeService.getAllEmployeesSortedBySalary();
        theModel.addAttribute("employees", employeeList);
        return "BySalaryDesc";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") long employeeId, Model theModel) {
        // Retrieve the employee from the service based on the ID
        Employee theEmployee = employeeService.getEmployeeById(employeeId);

        // Add the employee to the model
        theModel.addAttribute("employee", theEmployee);

        // Send to the employee update form
        return "employee-update-form";
    }

}
