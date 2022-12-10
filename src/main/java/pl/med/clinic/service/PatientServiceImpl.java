package pl.med.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.PatientDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public List<PatientDtoResponse> getAll() {

        List<PatientEntity> patients = new ArrayList<>(patientRepository.findAll());
        List<PatientDtoResponse> patientsDto=new ArrayList<>();

        patients.forEach(patient->patientsDto.add(new PatientDtoResponse(patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPesel(),
                patient.getGender())));

        return patientsDto;
    }


    @Override
    public int savePatients(List<PatientEntity> newPatients) {
        patientRepository.saveAll(newPatients);
        return 1;
    }

    @Override
    public int updatePatient(Long id, PatientEntity updatedPatient) {

        PatientEntity patientById = patientRepository.getById(id);

        patientById.setFirstName(updatedPatient.getFirstName());
        patientById.setLastName(updatedPatient.getLastName());

        patientRepository.save(patientById);
        return 1;
    }

    @Override
    public int deletePatientById(Long id){
        patientRepository.deleteById(id);
        return 1;
    }
}
