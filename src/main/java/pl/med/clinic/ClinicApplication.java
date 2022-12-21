package pl.med.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.service.PatientService;
import pl.med.clinic.service.PatientServiceImpl;

@SpringBootApplication
public class  ClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);

	}

}
