package pl.med.clinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientDtoRequest {

    private String firstName;
    private String lastName;
    private String pesel;
    private String gender;
}
