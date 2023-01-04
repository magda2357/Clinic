package pl.med.clinic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.entity.VisitEntity;
import pl.med.clinic.repository.VisitRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public VisitsDtoResponse get(Long patientId) {
        List<VisitEntity> visits = visitRepository.getVisitEntitiesByPatientId(patientId);
        return new VisitsDtoResponse(visits);
    }

}
