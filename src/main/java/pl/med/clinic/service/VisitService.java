package pl.med.clinic.service;

import pl.med.clinic.dto.VisitsDtoResponse;

public interface VisitService {

    VisitsDtoResponse get(Long patientId);

}
