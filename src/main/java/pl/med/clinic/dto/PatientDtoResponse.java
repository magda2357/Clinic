package pl.med.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.PatientEntity;

@Getter
@AllArgsConstructor
public class PatientDtoResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String gender;

    public PatientDtoResponse(PatientEntity patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.pesel = patient.getPesel();
        this.gender = patient.getGender();
    }
}
