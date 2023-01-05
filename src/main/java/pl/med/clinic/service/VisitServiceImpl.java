package pl.med.clinic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.VisitDto;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.entity.VisitEntity;
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
    public VisitDto getVisit(Long visitId) {
        return new VisitDto(visitRepository.getOrThrow(visitId));
    }

    @Override
    public VisitDto createVisit(VisitDtoRequest newVisit, Long patientId) {
        VisitEntity visitEntity = mapToEntity(newVisit);
        visitEntity.setPatient(patientRepository.getOrThrow(patientId));
        return new VisitDto(visitRepository.save(visitEntity));
    }

    @Override
    public void cancelVisit(Long visitId, Long patientId) {
        if (visitRepository.getOrThrow(visitId).getPatient().getId() == patientId) {
            visitRepository.deleteById(visitId);
        }
    }

    private VisitEntity mapToEntity(VisitDtoRequest dto) {
        return new VisitEntity(
                dto.getVisitDateTime(),
                dto.getPaid(),
                dto.getDescription(),
                dto.getPayment());
    }
}
