package edu.yacoubi.employeemanagementsystem.dto;

import lombok.Getter;

@Getter
public class GenderCounter {
    private Long count;
    private String gender;


    public GenderCounter(Long count, String gender) {
        this.count = count;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GenderCounter{" +
                "count=" + count +
                ", gender='" + gender + '\'' +
                '}';
    }
}
