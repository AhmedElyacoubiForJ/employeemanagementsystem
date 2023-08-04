package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.dto.EmployeeDepartmentCount;
import edu.yacoubi.employeemanagementsystem.dto.GenderAverage;
import edu.yacoubi.employeemanagementsystem.dto.GenderCounter;
import edu.yacoubi.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    String dtoPackage = "edu.yacoubi.employeemanagementsystem.dto";

    // 1. How many male and female employees are there in the organization?
    @Query("SELECT count(e.gender) FROM Employee e " +
            "WHERE e.gender= :gender " +
            "GROUP BY e.gender")
    Long countByGender(@Param(value = "gender") String gender);

    // 1.1 group by gender
    // custom result as dto
    @Query("SELECT new " + dtoPackage + ".GenderCounter(count(*), e.gender) " +
            "FROM Employee AS e " + "GROUP BY e.gender")
    List<GenderCounter> counterGroupByGender();

    // 2. Print the name of all departments in the organization?
    @Query("SELECT distinct(e.department) FROM Employee e")
    List<String> findAllDepartementsByNames();

    // 3.1 What is the average age of male and female employees?
    @Query("SELECT AVG(e.age) FROM Employee e " +
            "WHERE e.gender= :gender " +
            "GROUP BY e.gender")
    Double ageAverageByGender(@Param(value = "gender") String gender);

    // 3.2 What is the average age of male and female employees?
    // custom result as dto
    @Query("SELECT new " + dtoPackage + ".GenderAverage(e.gender, AVG(e.age)) " +
            "FROM Employee AS e " +
            "GROUP BY e.gender")
    List<GenderAverage> ageAverageByGenderCustom();

    // 4. Get the details of highest paid employee in the organization?
    @Query("SELECT e FROM Employee e " +
            "WHERE e.salary IN (select MAX(salary) FROM Employee)")
    Employee findByHighestPaid();

    // 5. Get the names of all employees who have joined after 2015?
    @Query("SELECT e.name FROM Employee e " +
            "WHERE e.yearOfJoining > :year")
    List<String> findByNamesJoinedAfter(@Param(value = "year") int year);

    // 6. Count the number of employees in each department
    @Query("SELECT new " + dtoPackage +  ".EmployeeDepartmentCount(e.department, COUNT(e.department)) "
            + "FROM Employee AS e "
            + "GROUP BY e.department")
    List<EmployeeDepartmentCount> numberOfEmployeeEachDepartment();
}
