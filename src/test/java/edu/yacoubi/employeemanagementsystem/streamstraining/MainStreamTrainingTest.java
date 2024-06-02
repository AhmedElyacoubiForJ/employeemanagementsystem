package edu.yacoubi.employeemanagementsystem.streamstraining;

import edu.yacoubi.employeemanagementsystem.entity.Employee;
import edu.yacoubi.employeemanagementsystem.repository.SampleDataInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainStreamTrainingTest {

    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = SampleDataInitializer.generateEmployees();
    }

    @Test
    public void itShouldGiveTheCorrectAgeGreaterThan() {
        long expected = 6L;
        long greaterThan = MainStreamTraining.employeesAgeGreaterThan(30);
        assertThat(greaterThan).isEqualTo(expected);

        expected = 1;
        greaterThan = MainStreamTraining.employeesAgeGreaterThan(38);
        assertThat(greaterThan).isEqualTo(expected);

        expected = 17;
        greaterThan = MainStreamTraining.employeesAgeGreaterThan(1);
        assertThat(greaterThan).isEqualTo(expected);
    }

    @Test
    public void itShouldWork() {
        List<String> seasons = Arrays.asList("spring", "summer", "fall", "winter");
        List<String> numbers =
                Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        // group numbers, length
        Map<Integer, List<String>> numbersGroupedByLength =
                numbers.stream().collect(Collectors.groupingBy(String::length));

        numbersGroupedByLength.get(3);
        assertThat(numbersGroupedByLength.get(3).size()).isEqualTo(3);

    }
}