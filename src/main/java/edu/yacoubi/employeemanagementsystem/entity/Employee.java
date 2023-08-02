package edu.yacoubi.employeemanagementsystem.entity;

import lombok.Data;

@Data
public class Employee {
    private int 	id;
    private String 	name;
    private int 	age;
    private String 	gender;
    private String 	department;
    private int	 	yearOfJoining;
    private double 	salary;
}
