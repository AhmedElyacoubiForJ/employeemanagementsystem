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
		// 1. How many male and female employees are there in the organization?
		testCountGroupByMaleFemale();
	}

	private void testCountGroupByMaleFemale() {
		repository
				.counterGroupByGender()
				.forEach(gCounter -> {
					System.out.println(gCounter);
				});
	}
}
