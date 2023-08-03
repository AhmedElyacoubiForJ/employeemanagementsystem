package edu.yacoubi.employeemanagementsystem;

import edu.yacoubi.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String query;

		query = "1. How many male and female employees are there in the organization?";
		System.out.println(query);
		testCountGroupByMaleFemale();

		query = "2. Print the name of all departments in the organization?";
		System.out.println(query);
		testFindAllDepartementsByNames();

		query = "3. What is the average age of male and female employees?";
		System.out.println(query);
		testAgeAverageByGenderCustom();

	}

	private void testAgeAverageByGenderCustom() {
		repository.ageAverageByGenderCustom()
				.forEach(System.out::println);
	}

	private void testFindAllDepartementsByNames() {
		repository
				.findAllDepartementsByNames()
				.forEach(System.out::println);
	}

	private void testCountGroupByMaleFemale() {
		repository
				.counterGroupByGender()
				.forEach(System.out::println);
	}
}