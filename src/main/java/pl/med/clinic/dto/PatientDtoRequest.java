package pl.med.clinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.med.clinic.entity.Gender;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PatientDtoRequest {

    @Size(min=4)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Size(min = 11, max=11)
    @Min(value = 0, message = "Pesel have to be positive number")
    private String pesel;

    private Gender gender;

    private LocalDate dateOfBirth;
}
