package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
