package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.VisitDto;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.service.VisitService;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/{patientId}/visit")
    public VisitsDtoResponse getPatientsVisits(@PathVariable Long patientId) {
        return visitService.getPatientsVisits(patientId);
    }

    @GetMapping("/visit/{visitId}")
    public VisitDto getVisit(@PathVariable Long visitId) {
        return visitService.getVisit(visitId);
    }

    @PostMapping("/visit")
    public void createVisit(@RequestBody VisitDtoRequest newVisit) {
        visitService.createVisit(newVisit);
    }

    @DeleteMapping("/visit/{visitId}")
    public void cancelVisit(@PathVariable Long visitId) {
        visitService.cancelVisit(visitId);
    }


}
