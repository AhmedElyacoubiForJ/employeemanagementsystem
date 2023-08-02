package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // 1. How many male and female employees are there in the organization?
    @Query(value = "SELECT count(e.gender) FROM Employee e " +
                   "WHERE e.gender= :gender " +
                   "GROUP BY e.gender")
    Long countByGender(@Param(value = "gender") String gender);

    // 1.1 order by gender
}