package edu.yacoubi.employeemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int 	id;
    private String 	name;
    private int 	age;
    private String 	gender;
    private String 	department;
    private int	 	yearOfJoining;
    private double 	salary;

    public Employee(
            String name,
            int age,
            String gender,
            String department,
            int yearOfJoining,
            double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

}
