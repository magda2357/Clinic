package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.VisitDto;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.service.VisitService;

@RestController
@RequestMapping("/patient/{patientId}/visit")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping
    public VisitsDtoResponse getPatientsVisits(@PathVariable Long patientId) {
        return visitService.getPatientsVisits(patientId);
    }

    @GetMapping("/{visitId}")
    public void getVisit(@PathVariable Long visitId) {
        visitService.getVisit(visitId);
    }

    @PostMapping
    public void createVisit(@RequestBody VisitDtoRequest newVisit, Long patientId) {
        visitService.createVisit(newVisit, patientId);
    }

    @DeleteMapping("/{visitId}")
    public void cancelVisit(@PathVariable Long visitId, Long patientId) {
        visitService.cancelVisit(visitId, patientId);
    }


}
