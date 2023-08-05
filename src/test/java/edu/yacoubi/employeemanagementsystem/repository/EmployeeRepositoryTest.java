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
    private EmployeeRepository repository;

    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = repository.findAll();
    }

    @Test
    void countByGender() {
        assertEquals(employees.stream()
                        .filter(e -> e.getGender().equals("Female"))
                        .count(),
                repository.countByGender("Female")
        );

        assertEquals(employees.stream()
                        .filter(e -> e.getGender().equals("Male"))
                        .count(),
                repository.countByGender("Male"));
    }

    // TODO delete all, create some data, test, delete all
    @Test
    void countEmployeeGroupByGender() {
        Map<String, Long> noOfMaleAndFemaleEmployees =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                                Employee::getGender,
                                                Collectors.counting()
                                        )
                        );
        //
        assertEquals(
                noOfMaleAndFemaleEmployees.get("Female"),
                repository.counterGroupByGender().stream()
                        .filter(gC -> gC.getGender().equals("Female"))
                        .findFirst().get().getCount()
        );
        //
        assertEquals(
                noOfMaleAndFemaleEmployees.get("Male"),
                repository.counterGroupByGender().stream()
                        .filter(gC -> gC.getGender().equals("Male"))
                        .findFirst().get().getCount()
        );
    }
}