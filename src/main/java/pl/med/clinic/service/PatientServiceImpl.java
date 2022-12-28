package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDtoResponse get(Long id) {
        return new PatientDtoResponse(patientRepository.getOrThrow(id));
    }

    @Override
    public List<PatientDtoResponse> getAll() {
        return patientRepository.findAll().stream()
                .map(PatientDtoResponse::new)
                .collect(toList());
    }

    @Override
    public void savePatient(PatientDtoRequest newPatient) {
        PatientEntity patientEntity = new PatientEntity();
        copyProperties(newPatient, patientEntity);
        patientRepository.save(patientEntity);
    }

    @Override
    public PatientDtoResponse updatePatient(Long id, PatientDtoRequest updatedPatient) {
        PatientEntity patientById = patientRepository.getOrThrow(id);
        copyProperties(updatedPatient, patientById);
        PatientEntity updatedEntity = patientRepository.save(patientById);
        return new PatientDtoResponse(updatedEntity);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
