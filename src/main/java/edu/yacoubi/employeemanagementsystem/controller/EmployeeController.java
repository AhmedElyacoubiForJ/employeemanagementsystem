package edu.yacoubi.employeemanagementsystem.controller;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import edu.yacoubi.employeemanagementsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private EmployeeRepository repository;

    @GetMapping("/showEmployees")
    public ModelAndView showEmployees() {
        ModelAndView modelAndView = new ModelAndView("list-employees");
        List<Employee> employeesList = repository.findAll();
        modelAndView.addObject("employees", employeesList);
        return modelAndView;
    }
}
