package pl.med.clinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import pl.med.clinic.entity.Gender;
import pl.med.clinic.entity.PatientEntity;

import java.time.LocalDate;

@Getter
public class PatientDtoResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final Gender gender;
    private final LocalDate dateOfBirth;

    public PatientDtoResponse(PatientEntity patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.pesel = patient.getPesel();
        this.gender = patient.getGender();
        this.dateOfBirth = patient.getDateOfBirth();
    }
}
