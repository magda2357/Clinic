package pl.med.clinic.service;

import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;

import java.util.List;

public interface PatientService {

    PatientDtoResponse get(Long id);
    List<PatientDtoResponse> getAll();
    int savePatients(List<PatientEntity> newPatients);
    int updatePatient(Long id, PatientEntity newPatient);
    int deletePatientById(Long id);

}
