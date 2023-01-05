package pl.med.clinic.service;

import pl.med.clinic.dto.VisitDto;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;

public interface VisitService {

    VisitsDtoResponse getPatientsVisits(Long patientId);

    void getVisit(Long visitId);

    void createVisit(VisitDtoRequest newVisit, Long patientId);

    void cancelVisit(Long visitId, Long patientId);
}
