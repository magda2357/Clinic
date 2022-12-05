package pl.med.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatientDtoResponse {

    private Long id;
    private String name;

}
