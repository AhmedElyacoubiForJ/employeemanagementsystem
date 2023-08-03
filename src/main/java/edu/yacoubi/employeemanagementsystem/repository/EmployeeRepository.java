package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.dto.GenderCounter;
import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // 1. How many male and female employees are there in the organization?
    @Query(value = "SELECT count(e.gender) FROM Employee e " +
                   "WHERE e.gender= :gender " +
                   "GROUP BY e.gender")
    Long countByGender(@Param(value = "gender") String gender);

    // 1.1 group by gender
    // SELECT count(*) , gender FROM employee group by gender
    // custom result as dto
    @Query(value =
            "SELECT new edu.yacoubi.employeemanagementsystem.dto.GenderCounter(count(*), e.gender) " +
                    "FROM Employee AS e " +
                    "GROUP BY e.gender")
    List<GenderCounter> counterGroupByGender();

    // 2. Print the name of all departments in the organization?
    @Query(value = "SELECT distinct(e.department) FROM Employee e")
    List<String> findAllDepartementsByNames();
}
