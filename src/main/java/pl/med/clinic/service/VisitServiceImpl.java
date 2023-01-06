package pl.med.clinic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.entity.VisitEntity;
import pl.med.clinic.repository.PatientRepository;
import pl.med.clinic.repository.VisitRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
    public void getVisit(Long visitId) {
        visitRepository.getOrThrow(visitId);
    }

    @Override
    public void createVisit(VisitDtoRequest newVisit, Long patientId) {
        VisitEntity visitEntity = mapToEntity(newVisit);
        addVisitToPatient(visitEntity, patientId);
        visitEntity.setPatient(patientRepository.getOrThrow(patientId));
        visitRepository.save(visitEntity);
    }

    @Override
    public void cancelVisit(Long visitId, Long patientId) {
        if (Objects.equals(visitRepository.getOrThrow(visitId).getPatient().getId(), patientId)) {
            visitRepository.deleteById(visitId);
            deleteVisitFromPatient(visitId, patientId);
        }
    }

    private VisitEntity mapToEntity(VisitDtoRequest dto) {
        return new VisitEntity(
                dto.getVisitDateTime(),
                dto.getPaid(),
                dto.getDescription(),
                dto.getPayment());
    }

    private void addVisitToPatient(VisitEntity visit, Long patientId) {
        patientRepository.getOrThrow(patientId).getVisits().add(visit);
    }

    private void deleteVisitFromPatient(Long visitId, Long patientId) {
        patientRepository.getOrThrow(patientId).getVisits().removeIf(n -> Objects.equals(n.getId(), visitId));
    }
}
