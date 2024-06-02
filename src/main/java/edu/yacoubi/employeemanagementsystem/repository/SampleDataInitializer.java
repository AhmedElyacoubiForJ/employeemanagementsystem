package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SampleDataInitializer {
    @Autowired
    private EmployeeRepository repository;

    public static List<Employee> generateEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee("Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee("Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee("Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee("Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee("Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee("Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee("Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee("Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee("Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee("Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee("Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee("Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee("Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee("Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee("Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee("Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee("Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }

    public void saveAll() {
        repository.saveAll(generateEmployees());
    }
}
