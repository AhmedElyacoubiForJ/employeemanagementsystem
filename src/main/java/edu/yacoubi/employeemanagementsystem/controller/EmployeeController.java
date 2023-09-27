package edu.yacoubi.employeemanagementsystem.controller;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import edu.yacoubi.employeemanagementsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        repository.save(employee);
        return "redirect:/showEmployees";
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int employeeId) {
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Optional<Employee> optionalEmployee = repository.findById(employeeId);
        modelAndView.addObject("employee", optionalEmployee.get());
        return modelAndView;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int employeeId) {
        repository.deleteById(employeeId);
        return "redirect:/showEmployees";
    }
}
