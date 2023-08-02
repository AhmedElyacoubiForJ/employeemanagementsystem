package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employeeList;

    @BeforeEach
    void setUp() {
        employeeList = employeeRepository.findAll();
    }

    @Test
    void countByGender() {
        assertEquals(employeeList.stream()
                    .filter(employee -> employee.getGender().equals("Female"))
                    .count(),
            employeeRepository.countByGender("Female"));

        assertEquals(employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .count(),
                employeeRepository.countByGender("Male"));
    }

    @Test
    void countEmployeeGroupByGender() {
        Map<String, Long> noOfMaleAndFemaleEmployees =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(
                                                Employee::getGender,
                                                Collectors.counting()
                                        )
                        );

        assertEquals(
                noOfMaleAndFemaleEmployees.get("Female"),
                employeeRepository
                        .counterGroupByGender()
                        .stream()
                        .filter(gCounter ->
                                gCounter.getGender().equals("Female"))
                        .findFirst().get().getCount()
        );

        assertEquals(
                noOfMaleAndFemaleEmployees.get("Male"),
                employeeRepository
                        .counterGroupByGender()
                        .stream()
                        .filter(gCounter ->
                                gCounter.getGender().equals("Male"))
                        .findFirst().get().getCount()
        );
    }
}