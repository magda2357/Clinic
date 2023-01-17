package pl.med.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.med.clinic.dto.VisitDtoRequest;
import pl.med.clinic.dto.VisitDtoResponse;
import pl.med.clinic.dto.VisitsDtoResponse;
import pl.med.clinic.service.VisitService;

import static org.springframework.http.HttpStatus.ACCEPTED;

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
    public VisitDtoResponse get(@PathVariable Long patientId, @PathVariable Long visitId) {
        return visitService.get(patientId, visitId);
    }

    @PostMapping
    public VisitDtoResponse create(@PathVariable Long patientId, @RequestBody VisitDtoRequest newVisit) {
        return visitService.create(patientId, newVisit);
    }

    @DeleteMapping("/{visitId}")
    @ResponseStatus(value = ACCEPTED, reason = "Visit has been deleted")
    public void cancel(@PathVariable Long patientId, @PathVariable Long visitId) {
        visitService.cancel(patientId, visitId);
    }

}
