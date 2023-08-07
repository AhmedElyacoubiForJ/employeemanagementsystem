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

		System.out.println("********* Query results *********");
		query = "1. How many male and female employees are there in the organization?";
		System.out.println(query);
		testCountGroupByMaleFemale();
		System.out.println();

		query = "2. Print the name of all departments in the organization?";
		System.out.println(query);
		testFindAllDepartementsByNames();
		System.out.println();

		query = "3.2 What is the average age of male and female employees?";
		System.out.println(query);
		testAgeAverageByGenderCustom();
		System.out.println();

		query = "4. Get the details of highest paid employee in the organization?";
		System.out.println(query);
		testFindByHighestPaid();
		System.out.println();

		query = "5. Get the names of all employees who have joined after 2015?";
		System.out.println(query);
		testFindByNamesJoinedAfter2015();
		System.out.println();

		query = "6. Count the number of employees in each department?";
		System.out.println(query);
		testNumberOfEmployeeEachDepartment();
		System.out.println();

		query = "7. What is the average salary of each department?";
		System.out.println(query);
		testAverageSalaryOfEachDepartment();
		System.out.println();

		query = "8. Get the details of the youngest male employee " +
				"in the product development department?";
		System.out.println(query);
		testYoungestEmployee();
		System.out.println();

		query = "9.  Who has the most working experience in the organization?";
		System.out.println(query);
		testMostWorkingExperience();
		System.out.println();

		query = "10. How many male and female employees are there " +
				"in the sales and marketing team?";
		System.out.println(query);
		testHowManyGenderInDepartment();
		System.out.println();

		query = "11. What is the average salary of male and female employees?";
		System.out.println(query);
		testAverageSalaryOfGender();
		System.out.println();

	}

	private void testAverageSalaryOfGender() {
		repository.averageSalaryOfGender()
				.forEach(System.out::println);
	}

	private void testHowManyGenderInDepartment() {
		repository.howManyGenderInDepartment("Sales And Marketing")
				.forEach(System.out::println);
	}

	private void testMostWorkingExperience() {
		System.out.println(repository.mostWorkingExperience());
	}

	private void testYoungestEmployee() {
		System.out.println(repository
				.youngestEmployee("Male", "Product Development")
		);
		System.out.println(repository
				.youngestEmployee("Female", "Product Development")
		);
	}

	private void testAverageSalaryOfEachDepartment() {
		repository.averageSalaryOfEachDepartment()
				.forEach(System.out::println);
	}

	private void testNumberOfEmployeeEachDepartment() {
		repository.numberOfEmployeeEachDepartment()
				.forEach(System.out::println);
	}

	private void testFindByNamesJoinedAfter2015() {
		repository.findByNamesJoinedAfter(2015)
				.forEach(System.out::println);
	}

	private void testFindByHighestPaid() {
		System.out.println(repository.findByHighestPaid());
	}

	private void testAgeAverageByGenderCustom() {
		repository.ageAverageByGenderCustom()
				.forEach(System.out::println);
	}

	private void testFindAllDepartementsByNames() {
		repository.findAllDepartementsByNames()
				.forEach(System.out::println);
	}

	private void testCountGroupByMaleFemale() {
		repository.counterGroupByGender()
				.forEach(System.out::println);
	}
}