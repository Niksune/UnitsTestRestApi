package net.niksune.UnitsTestRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitsTestRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitsTestRestApiApplication.class, args);

		/*PatientRecord pr = new PatientRecord();
		pr.setAge(14);
		System.out.println(pr);*/

		/*
		NotFoundException nfe = new NotFoundException("Patient with ID " + 5 + " does not exist.");
		System.out.println(nfe.getMessage());
		*/

	}

}
