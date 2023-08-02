package edu.yacoubi.employeemanagementsystem.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void countByGender() {
        assertEquals(employeeRepository.findAll().stream()
                    .filter(employee -> employee.getGender().equals("Female"))
                    .count(),
            employeeRepository.countByGender("Female"));

        assertEquals(employeeRepository.findAll().stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .count(),
                employeeRepository.countByGender("Male"));
    }

    @Test
    void countEmployeeOrderByGender() {
        employeeRepository
                .counterOrderByGender()
                .forEach(genderCounter -> {System.out.println(genderCounter);});
    }
}