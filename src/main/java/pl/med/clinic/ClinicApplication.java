package pl.med.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.med.clinic.files.CSVImport;
import pl.med.clinic.files.CSVImportScanner;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class ClinicApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ClinicApplication.class, args);

    }

}
