package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.repository.PatientRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDtoResponse get(Long id) {
        PatientEntity patientById = patientRepository.getById(id);
        return new PatientDtoResponse(patientById.getId(),
                                        patientById.getFirstName(),
                                        patientById.getLastName(),
                                        patientById.getPesel(),
                                        patientById.getGender());
    }

    @Override
    public PatientEntity saveToDatabase(PatientEntity newPatient) {
        patientRepository.save(newPatient);
        return newPatient;
    }
}
