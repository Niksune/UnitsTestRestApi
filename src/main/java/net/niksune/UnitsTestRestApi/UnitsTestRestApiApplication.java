package net.niksune.UnitsTestRestApi;

import net.niksune.UnitsTestRestApi.entities.PatientRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitsTestRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitsTestRestApiApplication.class, args);
		PatientRecord pr = new PatientRecord();
		pr.setAge(14);
		System.out.println(pr);
	}

}
