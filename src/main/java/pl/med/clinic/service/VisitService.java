package pl.med.clinic.service;

import pl.med.clinic.dto.VisitDto;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;

public interface VisitService {

    VisitsDtoResponse getPatientsVisits(Long patientId);

    VisitDto getVisit(Long visitId);

    VisitDto createVisit(VisitDtoRequest newVisit);

    void cancelVisit(Long visitId);
}
