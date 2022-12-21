package pl.med.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Gender;
import pl.med.clinic.entity.PatientEntity;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PatientDtoResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private Gender gender;
    private LocalDate dateOfBirth;

    public PatientDtoResponse(PatientEntity patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.pesel = patient.getPesel();
        this.gender = patient.getGender();
        this.dateOfBirth=patient.getDateOfBirth();
    }
}
