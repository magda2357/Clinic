package pl.med.clinic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitDtoResponse;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.entity.PatientEntity;
import pl.med.clinic.entity.VisitEntity;
import pl.med.clinic.exception.ForbiddenException;
import pl.med.clinic.repository.PatientRepository;
import pl.med.clinic.repository.VisitRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    @Override
    public VisitsDtoResponse getPatientsVisits(Long patientId) {
        List<VisitEntity> visits = visitRepository.getVisitEntitiesByPatientId(patientId);
        return new VisitsDtoResponse(visits);
    }

    @Override
    public VisitDtoResponse get(Long patientId, Long visitId) {
        PatientEntity patient = patientRepository.getOrThrow(patientId);
        VisitEntity visit = visitRepository.getOrThrow(visitId);
        if (!patient.getVisits().contains(visit)) {
            throw new ForbiddenException("Visit by id " + visitId + " not available for patient by id " + patientId);
        }
        return new VisitDtoResponse(visit);
    }

    @Override
    public VisitDtoResponse create(Long patientId, VisitDtoRequest newVisit) {
        PatientEntity patientEntity = patientRepository.getOrThrow(patientId);
        VisitEntity visitEntity = mapToEntity(newVisit);

        patientEntity.addVisit(visitEntity);
        visitEntity.setPatient(patientEntity);

        VisitEntity save = visitRepository.save(visitEntity);
        return new VisitDtoResponse(save);
    }

    @Override
    public void cancel(Long patientId, Long visitId) {
        PatientEntity patient = patientRepository.getOrThrow(patientId);
        VisitEntity visit = visitRepository.getOrThrow(visitId);

        if (!patient.getVisits().contains(visit)) {
            throw new ForbiddenException("Visit by id " + visitId + " not available for patient by id " + patientId);
        }

        visitRepository.deleteById(visitId);
        patient.deleteVisit(visit);
    }

    private VisitEntity mapToEntity(VisitDtoRequest dto) {
        return new VisitEntity(
                dto.getVisitDateTime(),
                dto.getPaid(),
                dto.getDescription(),
                dto.getPayment());
    }

}
