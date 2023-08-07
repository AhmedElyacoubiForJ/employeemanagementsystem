package edu.yacoubi.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class GenderSalaryAverage {
    private String gender;
    private double 	salary;
}
