package pl.med.clinic.service;

import pl.med.clinic.dto.ProcedureDtoResponse;

import java.util.List;

public interface ProcedureService {

    List<ProcedureDtoResponse> search(String q);
}
