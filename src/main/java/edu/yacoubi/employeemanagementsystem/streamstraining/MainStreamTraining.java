package edu.yacoubi.employeemanagementsystem.streamstraining;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import edu.yacoubi.employeemanagementsystem.repository.SampleDataInitializer;

import java.util.List;
import java.util.stream.Collectors;

public class MainStreamTraining {
    public static List<Employee> employees = SampleDataInitializer.generateEmployees();

    public static void main(String[] args) {
        training();

//
//        System.out.println("1. How many male and female employees are there in the organization?");
//        System.out.println("********* Query results *********");
//        Map<String, Long> counterGroupedByGender = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        //System.out.println(counterGroupedByGender.toString());
    }

    private static void training() {
        // employees age greater than 30
        employeesAgeGreaterThan(30);

    }

    public static long employeesAgeGreaterThan(int age) {
        return employees.stream().filter(e -> {
            return e.getAge() > age;
        }).collect(Collectors.toList()).stream().count();
    }
}
