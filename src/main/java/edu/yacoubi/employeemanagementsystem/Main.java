package edu.yacoubi.employeemanagementsystem;

import edu.yacoubi.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		callCountGroupByMaleFemale();
		System.out.println();

		query = "2. Print the name of all departments in the organization?";
		System.out.println(query);
		callFindAllDepartementsByNames();
		System.out.println();

		query = "3.2 What is the average age of male and female employees?";
		System.out.println(query);
		callAgeAverageByGenderCustom();
		System.out.println();

		query = "4. Get the details of highest paid employee in the organization?";
		System.out.println(query);
		callFindByHighestPaid();
		System.out.println();

		query = "5. Get the names of all employees who have joined after 2015?";
		System.out.println(query);
		callFindByNamesJoinedAfter2015();
		System.out.println();

		query = "6. Count the number of employees in each department?";
		System.out.println(query);
		callNumberOfEmployeeEachDepartment();
		System.out.println();

		query = "7. What is the average salary of each department?";
		System.out.println(query);
		callAverageSalaryOfEachDepartment();
		System.out.println();

		query = "8. Get the details of the youngest male employee " +
				"in the product development department?";
		System.out.println(query);
		callYoungestEmployee();
		System.out.println();

		query = "9.  Who has the most working experience in the organization?";
		System.out.println(query);
		callMostWorkingExperience();
		System.out.println();

		query = "10. How many male and female employees are there " +
				"in the sales and marketing team?";
		System.out.println(query);
		callHowManyGenderInDepartment();
		System.out.println();

		query = "11. What is the average salary of male and female employees?";
		System.out.println(query);
		callAverageSalaryOfGender();
		System.out.println();

		query = "12. List down the names of all employees in each department?";
		System.out.println(query);
		callNamesInDepartment();
		System.out.println();

		query = "13. What is the average salary and total salary " +
				"of the whole organization?";
		System.out.println(query);
		callSalaryAverageAndTotal();
		System.out.println();
	}

	private void callSalaryAverageAndTotal() {
		System.out.println(repository.salaryAverageAndTotal());
	}

	private void callNamesInDepartment() {
		repository.findAllDepartementsByNames().forEach(depName -> {
			System.out.println(depName + ":");
			System.out.println("--------------");
			repository.namesInDepartment(depName).forEach(name -> {
				System.out.println(name);
			});
			System.out.println("");
		});
	}

	private void callAverageSalaryOfGender() {
		repository.averageSalaryOfGender()
				.forEach(System.out::println);
	}

	private void callHowManyGenderInDepartment() {
		repository.howManyGenderInDepartment("Sales And Marketing")
				.forEach(System.out::println);
	}

	private void callMostWorkingExperience() {
		System.out.println(repository.mostWorkingExperience());
	}

	private void callYoungestEmployee() {
		System.out.println(repository
				.youngestEmployee("Male", "Product Development")
		);
		System.out.println(repository
				.youngestEmployee("Female", "Product Development")
		);
	}

	private void callAverageSalaryOfEachDepartment() {
		repository.averageSalaryOfEachDepartment()
				.forEach(System.out::println);
	}

	private void callNumberOfEmployeeEachDepartment() {
		repository.numberOfEmployeeEachDepartment()
				.forEach(System.out::println);
	}

	private void callFindByNamesJoinedAfter2015() {
		repository.findByNamesJoinedAfter(2015)
				.forEach(System.out::println);
	}

	private void callFindByHighestPaid() {
		System.out.println(repository.findByHighestPaid());
	}

	private void callAgeAverageByGenderCustom() {
		repository.ageAverageByGenderCustom()
				.forEach(System.out::println);
	}

	private void callFindAllDepartementsByNames() {
		repository.findAllDepartementsByNames()
				.forEach(System.out::println);
	}

	private void callCountGroupByMaleFemale() {
		repository.counterGroupByGender()
				.forEach(System.out::println);
	}
}