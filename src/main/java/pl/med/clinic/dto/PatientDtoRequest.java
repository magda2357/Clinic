package pl.med.clinic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.med.clinic.entity.Gender;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PatientDtoRequest {

    @Min(5)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Min(11)
    @Max(11)
    private String pesel;

    private Gender gender;

    private LocalDate dateOfBirth;
}
