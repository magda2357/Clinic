package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.PatientDtoRequest;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDtoResponse get(Long id) {

        PatientEntity byId = patientRepository.getOrElseThrow(id);
        return new PatientDtoResponse(byId);
    }

    @Override
    public List<PatientDtoResponse> getAll() {

        return patientRepository.findAll().stream()
                .map(PatientDtoResponse::new)
                .collect(toList());
    }

    @Override
    public void savePatient(PatientDtoRequest newPatient) {

        PatientEntity patientEntity =new PatientEntity(newPatient);
        patientRepository.save(patientEntity);
    }

    @Override
    public PatientDtoResponse updatePatient(Long id, PatientEntity updatedPatient) {

        PatientEntity patientById = patientRepository.getOrElseThrow(id);
        BeanUtils.copyProperties(updatedPatient, patientById);
        PatientEntity updatedEntity = patientRepository.save(patientById);
        return new PatientDtoResponse(updatedEntity);
    }

    @Override
    public void deletePatientById(Long id) {

        patientRepository.deleteById(id);
    }
}
