package edu.yacoubi.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class GenderAverage {
    private String gender;
    private double average;
}
