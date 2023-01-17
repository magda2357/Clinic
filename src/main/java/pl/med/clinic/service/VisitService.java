package pl.med.clinic.service;

import pl.med.clinic.dto.VisitDtoResponse;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;

public interface VisitService {

    VisitsDtoResponse getPatientsVisits(Long patientId);

    VisitDtoResponse get(Long patientId, Long visitId);

    VisitDtoResponse create(Long patientId, VisitDtoRequest newVisit);

    void cancel(Long visitId, Long patientId);
}
