package pl.med.clinic.service;

import pl.med.clinic.dto.PatientDtoResponse;

public interface PatientService {

    PatientDtoResponse get(Long id);

}
