package pl.med.clinic.service;

import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {

    PatientDtoResponse get(Long id);

    List<PatientDtoResponse> getAll();

    void savePatient(PatientDtoRequest newPatient);

    PatientDtoResponse updatePatient(Long id, PatientDtoRequest newPatient);

    void deletePatientById(Long id);

}
