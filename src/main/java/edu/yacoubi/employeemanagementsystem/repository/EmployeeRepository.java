package edu.yacoubi.employeemanagementsystem.repository;

import edu.yacoubi.employeemanagementsystem.dto.*;
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
            "GROUP BY e.gender"
    )
    Long countByGender(@Param(value = "gender") String gender);

    // 1.1 group by gender
    // custom result as dto
    @Query("SELECT new " + dtoPackage + ".GenderCounter(e.gender, count(*)) " +
            "FROM Employee AS e " +
            "GROUP BY e.gender"
    )
    List<GenderCounter> counterGroupByGender();

    // 2. Print the name of all departments in the organization?
    @Query("SELECT distinct(e.department) FROM Employee e")
    List<String> findAllDepartementsByNames();

    // 3.1 What is the average age of male and female employees?
    @Query("SELECT AVG(e.age) FROM Employee e " +
            "WHERE e.gender= :gender " +
            "GROUP BY e.gender"
    )
    Double ageAverageByGender(@Param(value = "gender") String gender);

    // 3.2 What is the average age of male and female employees?
    // custom result as dto
    @Query("SELECT new " + dtoPackage + ".GenderAverage(e.gender, AVG(e.age)) " +
            "FROM Employee AS e " +
            "GROUP BY e.gender"
    )
    List<GenderAverage> ageAverageByGenderCustom();

    // 4. Get the details of highest paid employee in the organization?
    @Query("SELECT e FROM Employee e " +
            "WHERE e.salary IN (SELECT MAX(salary) FROM Employee)"
    )
    Employee findByHighestPaid();

    // 5. Get the names of all employees who have joined after 2015?
    @Query("SELECT e.name FROM Employee e " +
            "WHERE e.yearOfJoining > :year"
    )
    List<String> findByNamesJoinedAfter(@Param(value = "year") int year);

    // 6. Count the number of employees in each department
    // custom result as dto
    @Query("SELECT new " + dtoPackage +
            ".EmployeeDepartmentCount(e.department, COUNT(e.department)) " +
            "FROM Employee AS e " +
            "GROUP BY e.department"
    )
    List<EmployeeDepartmentCount> numberOfEmployeeEachDepartment();

    // 7.1 What is the average salary of each department?
    // custom result as dto
    @Query("SELECT new " + dtoPackage +
            ".SalaryDepartmentAverage(e.department, AVG(e.salary)) " +
            "FROM Employee AS e " +
            "GROUP BY e.department"
    )
    List<SalaryDepartmentAverage> averageSalaryOfEachDepartment();

    // 8. Get the details of the youngest male employee
    //    in the product development department?
    @Query("SELECT e FROM Employee e " +
            "WHERE e.age = (" +
                "SELECT MIN(e.age) FROM Employee e " +
                "WHERE e.gender = :gender " +
                "AND e.department = :department" +
            ") " +
            "AND e.gender = :gender " +
            "AND e.department = :department"
    ) // TODO optimization
    List<Employee> youngestEmployee(
            @Param(value = "gender") String gender,
            @Param(value = "department") String department
    );

    // 9.  Who has the most working experience in the organization?
    @Query("SELECT e FROM Employee e " +
            "ORDER BY e.yearOfJoining ASC limit 1"
    )
    Employee mostWorkingExperience();

    // 10. How many male and female employees are there
    //     in the sales and marketing team?
    @Query("SELECT new " + dtoPackage + ".GenderCounter(e.gender, count(*)) " +
            "FROM Employee e " +
            "WHERE e.department = :department " +
            "GROUP BY e.gender"
    )
    List<GenderCounter> howManyGenderInDepartment(
            @Param(value = "department") String department
    );

    // 11. What is the average salary of male and female employees?
    @Query("SELECT new " + dtoPackage +
            ".GenderSalaryAverage(e.gender, AVG(e.salary)) " +
            "FROM Employee e " +
            "GROUP BY e.gender"
    )
    List<GenderSalaryAverage> averageSalaryOfGender();

    // 12. List down the names of all employees in each department?
    @Query("SELECT e.name FROM Employee e " +
            "WHERE e.department = :department " +
            "ORDER BY e.name"
    )
    List<String> namesInDepartment(
            @Param(value = "department") String department
    );

    // 13. What is the average salary and total salary of the whole organization?
    @Query("SELECT new " + dtoPackage +
            ".SalaryTotalAndAverage(SUM(e.salary), AVG(e.salary)) " +
            "FROM Employee e"
    )
    SalaryTotalAndAverage salaryAverageAndTotal();

    // 14.1 Separate the employees who are younger or equal to 25 years
    //     from those employees who are older than 25 years.
    @Query("SELECT e.name FROM Employee e " +
            "WHERE e.age <= :age")
    List<String> youngerThanEqual(@Param(value = "age") int  age);

    // 14.2 older than 25 years
    @Query("SELECT e.name FROM Employee e " +
            "WHERE e.age > :age")
    List<String> olderThan(@Param(value = "age") int  age);

    // 15. Who is the oldest employee in the organization?
    //     What is his age and which department he belongs to?
    @Query("SELECT new " + dtoPackage +
            ".OldestEmployee(e.name, e.age, e.department) " +
                "FROM Employee e " +
                "WHERE e.age IN (SELECT MAX(age) FROM Employee )"
    )
    OldestEmployee oldest();
}