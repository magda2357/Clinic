package pl.med.clinic.service;

import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.controller.SimplePageForPagingAndSorting;

public interface PatientService {

    PatientDtoResponse get(Long id);

    SimplePageForPagingAndSorting<PatientDtoResponse> getAllPaged(Integer pageNo, Integer pageSize, String sortBy);

    PatientDtoResponse savePatient(PatientDtoRequest newPatient);

    PatientDtoResponse updatePatient(Long id, PatientDtoRequest newPatient);

    void deletePatientById(Long id);

}
