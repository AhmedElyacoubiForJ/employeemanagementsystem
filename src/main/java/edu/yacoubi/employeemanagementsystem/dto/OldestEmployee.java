package edu.yacoubi.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class OldestEmployee {
    private String name;
    private int age;
    private String department;
}
