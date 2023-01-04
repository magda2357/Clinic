package pl.med.clinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Gender;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PatientDtoRequest {

    private String firstName;
    private String lastName;
    private String pesel;
    private Gender gender;
    private LocalDate dateOfBirth;
}
